package com.staticallytyped.kagawaassist.coordinate

import net.minecraft.client.Minecraft
import net.minecraft.command.ISuggestionProvider.Coordinates

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

object Coordinate {
  def onPressKey(): Unit = {
    try {
      val player = Minecraft.getInstance().player
      val position = player.getPosition
      val clipboard = Toolkit.getDefaultToolkit.getSystemClipboard
      val text = s"${position.getX} ${position.getY} ${position.getZ} in ${player.getEntityWorld.getDimensionType.toString}"
      clipboard.setContents(new StringSelection(text), null)
    } catch {
      case e: java.awt.HeadlessException => e.printStackTrace()
    }
  }
}
