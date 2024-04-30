package me.odinmain.features.impl.subaddons

import me.odinmain.OdinMain.mc
import me.odinmain.utils.ServerUtils.getPing
import net.minecraft.entity.Entity

object SubUtils {

    fun Entity.isOnTeam(): Boolean {
        if (mc.thePlayer.displayName.unformattedText.startsWith("§")) {
            if (mc.thePlayer.displayName.unformattedText.length <= 2 || this.displayName.unformattedText.length <= 2) return false
            if (mc.thePlayer.displayName.unformattedText.substring(0, 2) == this.displayName.unformattedText.substring(0, 2)) return true
        }
        return false
    }

    fun Entity.isIt(): Boolean {
        return this.displayName.unformattedText.startsWith("§c[IT]") //Who plays tnt tag??
    }

    fun Entity.isPlayer(): Boolean {
        return this.getPing() == 1 //this method doesn't work in lobbies, for some reason.
    }
}