package com.staticallytyped.kagawaassist.coordinate.f3

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.client.event.RenderGameOverlayEvent

abstract class AbstractPart(column:Int)(event: RenderGameOverlayEvent) {
  protected val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  protected val textColor = 0xf3a305
  protected val valueColor = 0xFFFFFF

  protected def draw(text: String, before: String, color: Int): Unit = {
    val dx = fontRenderer.getStringWidth(before)
    val dy = fontRenderer.FONT_HEIGHT + 1
    fontRenderer.drawStringWithShadow(event.getMatrixStack, text, 2 + dx, 2 + dy * column, color)
  }

  def render(): Unit
}
