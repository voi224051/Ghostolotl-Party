package dev.voik.ghostolotlparty.games

import dev.voik.ghostolotlparty.GhostolotlPartyPlugin
import org.bukkit.World

abstract class EventGame {
    val flags = mutableSetOf<String>()
    var state: State = State.IDLE
    abstract var world: World

    abstract fun register(plugin: GhostolotlPartyPlugin)
    abstract fun prep()

    abstract fun init()
    abstract fun process(delta: Double)
    abstract fun end()

    abstract fun reset()

    enum class State {IDLE,STARTING,RUNNING,PAUSED,ENDED}
}