package com.staticallytyped.kagawaassist.coordinate.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraftforge.client.event.RenderGameOverlayEvent

abstract class AbstractPart(column:Int, f3: F3)(event: RenderGameOverlayEvent) {
  val drawText = new DrawText(f3.fontRenderer)
  implicit val col: Int = column
  implicit val matrixStack: MatrixStack = event.getMatrixStack

  def render(): Unit
}
