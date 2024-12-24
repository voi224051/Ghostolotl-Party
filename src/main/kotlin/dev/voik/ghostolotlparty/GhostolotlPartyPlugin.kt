package dev.voik.ghostolotlparty

import dev.voik.ghostolotlparty.core.players.PlayerManager
import dev.voik.ghostolotlparty.games.EventGame
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Suppress("Unused", "UnstableApiUsage")
class GhostolotlPartyPlugin : JavaPlugin() {
    companion object {
        val EVENTLOGGER: Logger = LoggerFactory.getLogger("GhostolotlParty")
        lateinit var instance: GhostolotlPartyPlugin
        lateinit var game: EventGame
    }

    override fun onEnable() {
        instance = this

        Bukkit.getPluginManager().registerEvents(PlayerManager, this)

        val manager: LifecycleEventManager<Plugin> = this.lifecycleManager

        EVENTLOGGER.info("GhostolotlPartyPlugin Enabled!")
    }

    override fun onDisable() { }
}