package expo.modules.location.records;

import android.location.Address;
import androidx.autofill.HintConstants;
import expo.modules.kotlin.records.Field;
import expo.modules.kotlin.records.Record;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: LocationResults.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b*\b\u0000\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001<B}\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0010\u0010\u0011B\u0011\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0010\u0010\u0014R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR&\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR&\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR&\u0010\b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR&\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010\u001aR&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR&\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0018\"\u0004\b/\u0010\u001aR&\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010\u0016\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR$\u0010\r\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010\u0016\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR&\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0016\u001a\u0004\b7\u0010\u0018\"\u0004\b8\u0010\u001aR&\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b9\u0010\u0016\u001a\u0004\b:\u0010\u0018\"\u0004\b;\u0010\u001a¨\u0006="}, d2 = {"Lexpo/modules/location/records/ReverseGeocodeResponse;", "Lexpo/modules/kotlin/records/Record;", "Ljava/io/Serializable;", "city", "", "district", "streetNumber", "street", "region", "subregion", "country", HintConstants.AUTOFILL_HINT_POSTAL_CODE, "name", "isoCountryCode", "timezone", "formattedAddress", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "address", "Landroid/location/Address;", "(Landroid/location/Address;)V", "getCity$annotations", "()V", "getCity", "()Ljava/lang/String;", "setCity", "(Ljava/lang/String;)V", "getDistrict$annotations", "getDistrict", "setDistrict", "getStreetNumber$annotations", "getStreetNumber", "setStreetNumber", "getStreet$annotations", "getStreet", "setStreet", "getRegion$annotations", "getRegion", "setRegion", "getSubregion$annotations", "getSubregion", "setSubregion", "getCountry$annotations", "getCountry", "setCountry", "getPostalCode$annotations", "getPostalCode", "setPostalCode", "getName$annotations", "getName", "setName", "getIsoCountryCode$annotations", "getIsoCountryCode", "setIsoCountryCode", "getTimezone$annotations", "getTimezone", "setTimezone", "getFormattedAddress$annotations", "getFormattedAddress", "setFormattedAddress", "Companion", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReverseGeocodeResponse implements Record, Serializable {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String city;
    private String country;
    private String district;
    private String formattedAddress;
    private String isoCountryCode;
    private String name;
    private String postalCode;
    private String region;
    private String street;
    private String streetNumber;
    private String subregion;
    private String timezone;

    @Field
    public static /* synthetic */ void getCity$annotations() {
    }

    @Field
    public static /* synthetic */ void getCountry$annotations() {
    }

    @Field
    public static /* synthetic */ void getDistrict$annotations() {
    }

    @Field
    public static /* synthetic */ void getFormattedAddress$annotations() {
    }

    @Field
    public static /* synthetic */ void getIsoCountryCode$annotations() {
    }

    @Field
    public static /* synthetic */ void getName$annotations() {
    }

    @Field
    public static /* synthetic */ void getPostalCode$annotations() {
    }

    @Field
    public static /* synthetic */ void getRegion$annotations() {
    }

    @Field
    public static /* synthetic */ void getStreet$annotations() {
    }

    @Field
    public static /* synthetic */ void getStreetNumber$annotations() {
    }

    @Field
    public static /* synthetic */ void getSubregion$annotations() {
    }

    @Field
    public static /* synthetic */ void getTimezone$annotations() {
    }

    public ReverseGeocodeResponse(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String isoCountryCode, String str10, String str11) {
        Intrinsics.checkNotNullParameter(isoCountryCode, "isoCountryCode");
        this.city = str;
        this.district = str2;
        this.streetNumber = str3;
        this.street = str4;
        this.region = str5;
        this.subregion = str6;
        this.country = str7;
        this.postalCode = str8;
        this.name = str9;
        this.isoCountryCode = isoCountryCode;
        this.timezone = str10;
        this.formattedAddress = str11;
    }

    public final String getCity() {
        return this.city;
    }

    public final void setCity(String str) {
        this.city = str;
    }

    public final String getDistrict() {
        return this.district;
    }

    public final void setDistrict(String str) {
        this.district = str;
    }

    public final String getStreetNumber() {
        return this.streetNumber;
    }

    public final void setStreetNumber(String str) {
        this.streetNumber = str;
    }

    public final String getStreet() {
        return this.street;
    }

    public final void setStreet(String str) {
        this.street = str;
    }

    public final String getRegion() {
        return this.region;
    }

    public final void setRegion(String str) {
        this.region = str;
    }

    public final String getSubregion() {
        return this.subregion;
    }

    public final void setSubregion(String str) {
        this.subregion = str;
    }

    public final String getCountry() {
        return this.country;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final void setPostalCode(String str) {
        this.postalCode = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getIsoCountryCode() {
        return this.isoCountryCode;
    }

    public final void setIsoCountryCode(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.isoCountryCode = str;
    }

    public final String getTimezone() {
        return this.timezone;
    }

    public final void setTimezone(String str) {
        this.timezone = str;
    }

    public final String getFormattedAddress() {
        return this.formattedAddress;
    }

    public final void setFormattedAddress(String str) {
        this.formattedAddress = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReverseGeocodeResponse(Address address) {
        Intrinsics.checkNotNullParameter(address, "address");
        String locality = address.getLocality();
        String subLocality = address.getSubLocality();
        String subThoroughfare = address.getSubThoroughfare();
        String thoroughfare = address.getThoroughfare();
        String adminArea = address.getAdminArea();
        String subAdminArea = address.getSubAdminArea();
        String countryName = address.getCountryName();
        String postalCode = address.getPostalCode();
        String featureName = address.getFeatureName();
        String countryCode = address.getCountryCode();
        Intrinsics.checkNotNullExpressionValue(countryCode, "getCountryCode(...)");
        this(locality, subLocality, subThoroughfare, thoroughfare, adminArea, subAdminArea, countryName, postalCode, featureName, countryCode, null, INSTANCE.constructFormattedAddress(address));
    }

    /* JADX INFO: compiled from: LocationResults.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/records/ReverseGeocodeResponse$Companion;", "", "<init>", "()V", "constructFormattedAddress", "", "address", "Landroid/location/Address;", "expo-location_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String constructFormattedAddress(Address address) {
            Intrinsics.checkNotNullParameter(address, "address");
            if (address.getMaxAddressLineIndex() == -1) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            int maxAddressLineIndex = address.getMaxAddressLineIndex();
            if (maxAddressLineIndex >= 0) {
                int i = 0;
                while (true) {
                    sb.append(address.getAddressLine(i));
                    if (i < address.getMaxAddressLineIndex()) {
                        sb.append(", ");
                    }
                    if (i == maxAddressLineIndex) {
                        break;
                    }
                    i++;
                }
            }
            return sb.toString();
        }
    }
}
