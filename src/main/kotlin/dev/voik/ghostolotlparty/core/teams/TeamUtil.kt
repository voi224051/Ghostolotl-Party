package dev.voik.ghostolotlparty.core.teams

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.scoreboard.Scoreboard
import org.bukkit.scoreboard.Team

fun getTeam(player: Player): Team? {
    return Bukkit.getScoreboardManager().mainScoreboard.getPlayerTeam(player)
}

fun getTeamDisplayName(team: Team): String {
    return team.name
}

fun eventTeamSetup() {
    val sb : Scoreboard = Bukkit.getScoreboardManager().mainScoreboard
    if (sb.teams.contains(sb.getTeam("e1"))) {
        sb.registerNewTeam("e1")
    }
}