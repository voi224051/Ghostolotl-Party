package dev.voik.ghostolotlparty.core.registeries

import com.mojang.brigadier.Command
import io.papermc.paper.command.brigadier.Commands
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents
import org.bukkit.plugin.Plugin

@Suppress("UnstableApiUsage")
object RegisteryManager {
    private lateinit var cmdManager: LifecycleEventManager<Plugin>

    fun setCmdManager(newCmdManager: LifecycleEventManager<Plugin>) {
        cmdManager = newCmdManager
    }

    fun registerCommand() {
        cmdManager.registerEventHandler(LifecycleEvents.COMMANDS) { event ->
            val commands: Commands = event.registrar()
            commands.register(
                Commands.literal("new-command")
                    .executes { ctx ->
                        ctx.source.sender.sendPlainMessage("some message")
                        Command.SINGLE_SUCCESS
                    }
                    .build(),
                "some bukkit help description string",
                listOf("an-alias")
            )
        }
    }
}