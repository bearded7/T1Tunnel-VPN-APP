package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes2.dex */
abstract class AggregateFuture<InputT, OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());

    @NullableDecl
    private AggregateFuture<InputT, OutputT>.RunningState runningState;

    AggregateFuture() {
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void afterDone() {
        super.afterDone();
        releaseResources();
    }

    protected final void releaseResources() {
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
        if (runningState != null) {
            this.runningState = null;
            ImmutableCollection immutableCollection = ((RunningState) runningState).futures;
            boolean zWasInterrupted = wasInterrupted();
            if (zWasInterrupted) {
                runningState.interruptTask();
            }
            if (isCancelled() && (immutableCollection != null)) {
                UnmodifiableIterator it = immutableCollection.iterator();
                while (it.hasNext()) {
                    ((ListenableFuture) it.next()).cancel(zWasInterrupted);
                }
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected String pendingToString() {
        ImmutableCollection immutableCollection;
        AggregateFuture<InputT, OutputT>.RunningState runningState = this.runningState;
        if (runningState == null || (immutableCollection = ((RunningState) runningState).futures) == null) {
            return null;
        }
        return "futures=[" + immutableCollection + "]";
    }

    final void init(AggregateFuture<InputT, OutputT>.RunningState runningState) {
        this.runningState = runningState;
        runningState.init();
    }

    abstract class RunningState extends AggregateFutureState implements Runnable {
        private final boolean allMustSucceed;
        private final boolean collectsValues;
        private ImmutableCollection<? extends ListenableFuture<? extends InputT>> futures;

        abstract void collectOneValue(boolean z, int i, @NullableDecl InputT inputt);

        abstract void handleAllCompleted();

        void interruptTask() {
        }

        RunningState(ImmutableCollection<? extends ListenableFuture<? extends InputT>> immutableCollection, boolean z, boolean z2) {
            super(immutableCollection.size());
            this.futures = (ImmutableCollection) Preconditions.checkNotNull(immutableCollection);
            this.allMustSucceed = z;
            this.collectsValues = z2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            decrementCountAndMaybeComplete();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void init() {
            if (this.futures.isEmpty()) {
                handleAllCompleted();
                return;
            }
            if (this.allMustSucceed) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                final int i = 0;
                while (it.hasNext()) {
                    final ListenableFuture<? extends InputT> next = it.next();
                    next.addListener(new Runnable() { // from class: com.google.common.util.concurrent.AggregateFuture.RunningState.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                RunningState.this.handleOneInputDone(i, next);
                            } finally {
                                RunningState.this.decrementCountAndMaybeComplete();
                            }
                        }
                    }, MoreExecutors.directExecutor());
                    i++;
                }
                return;
            }
            UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it2 = this.futures.iterator();
            while (it2.hasNext()) {
                it2.next().addListener(this, MoreExecutors.directExecutor());
            }
        }

        /* JADX WARN: Code duplicated, block: B:12:0x0029 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:13:0x002b  */
        /* JADX WARN: Code duplicated, block: B:14:0x002e  */
        /* JADX WARN: Code duplicated, block: B:17:? A[RETURN, SYNTHETIC] */
        private void handleException(Throwable th) {
            boolean exception;
            boolean zAddCausalChain;
            boolean z;
            String str;
            Preconditions.checkNotNull(th);
            if (this.allMustSucceed) {
                exception = AggregateFuture.this.setException(th);
                if (!exception) {
                    zAddCausalChain = AggregateFuture.addCausalChain(getOrInitSeenExceptions(), th);
                } else {
                    releaseResourcesAfterFailure();
                }
                z = th instanceof Error;
                if (((!exception) & this.allMustSucceed & zAddCausalChain) || z) {
                    if (z) {
                        str = "Input Future failed with Error";
                    } else {
                        str = "Got more than one input Future failure. Logging failures after the first";
                    }
                    AggregateFuture.logger.log(Level.SEVERE, str, th);
                }
            }
            exception = false;
            zAddCausalChain = true;
            z = th instanceof Error;
            if (((!exception) & this.allMustSucceed & zAddCausalChain) || z) {
                if (z) {
                    str = "Input Future failed with Error";
                } else {
                    str = "Got more than one input Future failure. Logging failures after the first";
                }
                AggregateFuture.logger.log(Level.SEVERE, str, th);
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState
        final void addInitialException(Set<Throwable> set) {
            if (AggregateFuture.this.isCancelled()) {
                return;
            }
            AggregateFuture.addCausalChain(set, AggregateFuture.this.tryInternalFastPathGetFailure());
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public void handleOneInputDone(int i, Future<? extends InputT> future) {
            Preconditions.checkState(this.allMustSucceed || !AggregateFuture.this.isDone() || AggregateFuture.this.isCancelled(), "Future was done before all dependencies completed");
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                if (this.allMustSucceed) {
                    if (future.isCancelled()) {
                        AggregateFuture.this.runningState = null;
                        AggregateFuture.this.cancel(false);
                        return;
                    } else {
                        Object done = Futures.getDone(future);
                        if (this.collectsValues) {
                            collectOneValue(this.allMustSucceed, i, done);
                            return;
                        }
                        return;
                    }
                }
                if (!this.collectsValues || future.isCancelled()) {
                    return;
                }
                collectOneValue(this.allMustSucceed, i, Futures.getDone(future));
            } catch (ExecutionException e) {
                handleException(e.getCause());
            } catch (Throwable th) {
                handleException(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void decrementCountAndMaybeComplete() {
            int iDecrementRemainingAndGet = decrementRemainingAndGet();
            Preconditions.checkState(iDecrementRemainingAndGet >= 0, "Less than 0 remaining futures");
            if (iDecrementRemainingAndGet == 0) {
                processCompleted();
            }
        }

        private void processCompleted() {
            if (this.collectsValues & (!this.allMustSucceed)) {
                UnmodifiableIterator<? extends ListenableFuture<? extends InputT>> it = this.futures.iterator();
                int i = 0;
                while (it.hasNext()) {
                    handleOneInputDone(i, it.next());
                    i++;
                }
            }
            handleAllCompleted();
        }

        void releaseResourcesAfterFailure() {
            this.futures = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean addCausalChain(Set<Throwable> set, Throwable th) {
        while (th != null) {
            if (!set.add(th)) {
                return false;
            }
            th = th.getCause();
        }
        return true;
    }
}
