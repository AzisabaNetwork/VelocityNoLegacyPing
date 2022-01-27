package net.azisaba.velocityNoLegacyPing;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.network.ProtocolVersion;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.server.ServerPing;

@Plugin(id = "velocitynolegacyping", name = "VelocityNoLegacyPing")
public class VNLPPlugin {
    @Inject
    public VNLPPlugin() {}

    @Subscribe
    public void onProxyInitialization(ProxyPingEvent e) {
        if (e.getPing().getVersion().getProtocol() == -2) {
            e.setPing(e.getPing().asBuilder().version(new ServerPing.Version(4, "Velocity " + ProtocolVersion.SUPPORTED_VERSION_STRING)).build());
        }
    }
}
