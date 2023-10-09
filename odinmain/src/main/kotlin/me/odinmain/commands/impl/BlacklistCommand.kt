package me.odinmain.commands.impl

import me.odinmain.commands.AbstractCommand
import me.odinmain.config.MiscConfig
import me.odinmain.utils.skyblock.ChatUtils.modMessage

object BlacklistCommand : AbstractCommand("blacklist", "odblacklist", description = "Command for Blacklist.") {
    init {
        empty {
            modMessage("§cArguments empty. §fUsage: add, remove, clear, list")
        }

        "add" {
            does {
                if (it.isEmpty()) return@does modMessage("You need to name someone to add to the Blacklist.")
                val name = it[0]
                if (name !in MiscConfig.blacklist) return@does modMessage("$name is already in the Blacklist.")

                modMessage("Added $name to Blacklist.")
                MiscConfig.blacklist.add(name)
                MiscConfig.saveAllConfigs()
            }
        }

        "remove" {
            does {
                if (it.isEmpty()) return@does modMessage("You need to name someone to remove from the Blacklist.")
                val name = it[0]
                if (name !in MiscConfig.blacklist) return@does modMessage("$name isn't in the Blacklist.")

                modMessage("Removed $name from Blacklist.")
                MiscConfig.blacklist.remove(name)
                MiscConfig.saveAllConfigs()
            }
        }

        "clear" {
            does {
                modMessage("Blacklist cleared.")
                MiscConfig.blacklist.clear()
                MiscConfig.saveAllConfigs()
            }
        }

        "list" {
            does {
                MiscConfig.blacklist.forEach { modMessage(it) }
            }
        }

        orElse {
            modMessage("Blacklist incorrect usage. Usage: add, remove, clear, list")
        }
    }
}