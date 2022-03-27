package com.staticallytyped.kagawaassist.coordinate.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.util.math.BlockPos

class Coordinate(column:Int, f3: F3)(implicit matrixStack: MatrixStack) extends AbstractPart(column, f3) {
  override def render(): Unit = {
    implicit val col: Int = column
    val player: BlockPos = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString

    drawText(textX, f3.textColor)
    drawText(x, f3.valueColor)
    drawText(textY, f3.textColor)
    drawText(y, f3.valueColor)
    drawText(textZ, f3.textColor)
    drawText(z, f3.valueColor)
  }
}
