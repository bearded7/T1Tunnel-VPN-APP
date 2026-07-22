package com.canhub.cropper.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.canhub.cropper.CropImageView;
import com.canhub.cropper.R;

/* JADX INFO: loaded from: classes.dex */
public final class CropImageActivityBinding implements ViewBinding {
    public final CropImageView cropImageView;
    private final CropImageView rootView;

    private CropImageActivityBinding(CropImageView cropImageView, CropImageView cropImageView2) {
        this.rootView = cropImageView;
        this.cropImageView = cropImageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CropImageView getRoot() {
        return this.rootView;
    }

    public static CropImageActivityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static CropImageActivityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.crop_image_activity, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static CropImageActivityBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        CropImageView cropImageView = (CropImageView) view;
        return new CropImageActivityBinding(cropImageView, cropImageView);
    }
}
