package dev.voik.ghostolotlparty.core.players

import dev.voik.ghostolotlparty.GhostolotlPartyPlugin
import dev.voik.ghostolotlparty.core.teams.getTeam
import dev.voik.ghostolotlparty.core.teams.getTeamDisplayName
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object PlayerManager : Listener {
    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        event.joinMessage(Component.text("Hai ${player.name} :3").color(TextColor.color(123, 143, 240)))

        val playerTeam = getTeam(player)
        if (playerTeam != null) {
            val playerTeamName = getTeamDisplayName(playerTeam)
            GhostolotlPartyPlugin.EVENTLOGGER.info("${player.name} has joined! They are on team ${playerTeamName}.")
        }
        else {
            GhostolotlPartyPlugin.EVENTLOGGER.info("${player.name} has joined! They are not on a team yet.")
        }
    }
}