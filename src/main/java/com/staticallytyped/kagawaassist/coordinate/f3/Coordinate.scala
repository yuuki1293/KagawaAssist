package com.staticallytyped.kagawaassist.coordinate.f3

import net.minecraft.client.Minecraft
import net.minecraft.util.math.BlockPos
import net.minecraftforge.client.event.RenderGameOverlayEvent

class Coordinate(column:Int)(implicit event:RenderGameOverlayEvent) extends AbstractPart(column)(event) {
  override def render(): Unit = {
    val player: BlockPos = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString

    draw(textX, "", textColor)
    draw(x, textX, valueColor)
    draw(textY, textX + x, textColor)
    draw(y, textX + x + textY, valueColor)
    draw(textZ, textX + x + textY + y, textColor)
    draw(z, textX + x + textY + y + textZ, valueColor)
  }
}
