// IOpenVPNAPIService.aidl
// Sourced from schwabe/ics-openvpn's published external control API
// (main/src/main/aidl/de/blinkt/openvpn/api/IOpenVPNAPIService.aidl), which the
// project explicitly documents for third-party apps to bind against - this is an
// interop contract, not their VPN engine. Requires "OpenVPN for Android" installed
// and the user granting this app permission via its Settings > API screen.
package de.blinkt.openvpn.api;

import de.blinkt.openvpn.api.APIVpnProfile;
import de.blinkt.openvpn.api.IOpenVPNStatusCallback;

import android.content.Intent;
import android.os.ParcelFileDescriptor;

interface IOpenVPNAPIService {
    List<APIVpnProfile> getProfiles();

    void startProfile(String profileUUID);

    boolean addVPNProfile(String name, String config);

    void startVPN(in String inlineconfig);

    Intent prepare(in String packagename);

    Intent prepareVPNService();

    void disconnect();

    void pause();

    void resume();

    void registerStatusCallback(in IOpenVPNStatusCallback cb);

    void unregisterStatusCallback(in IOpenVPNStatusCallback cb);

    void removeProfile(in String profileUUID);

    boolean protectSocket(in ParcelFileDescriptor fd);

    APIVpnProfile addNewVPNProfile(String name, boolean userEditable, String config);

    void startVPNwithExtras(in String inlineconfig, in Bundle extras);

    APIVpnProfile addNewVPNProfileWithExtras(String name, boolean userEditable, String config, in Bundle extras);

    @nullable APIVpnProfile getDefaultProfile();

    void setDefaultProfile(String profileUUID);
}
