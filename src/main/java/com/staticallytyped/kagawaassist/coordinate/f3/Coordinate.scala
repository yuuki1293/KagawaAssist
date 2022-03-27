package com.staticallytyped.kagawaassist.coordinate.f3

import net.minecraft.client.Minecraft
import net.minecraft.util.math.BlockPos
import net.minecraftforge.client.event.RenderGameOverlayEvent

class Coordinate(column:Int, f3: F3)(implicit event:RenderGameOverlayEvent) extends AbstractPart(column, f3)(event) {
  override def render(): Unit = {
    val player: BlockPos = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString

    drawText.draw(textX, f3.textColor)
    drawText.draw(x, f3.valueColor)
    drawText.draw(textY, f3.textColor)
    drawText.draw(y, f3.valueColor)
    drawText.draw(textZ, f3.textColor)
    drawText.draw(z, f3.valueColor)
  }
}
