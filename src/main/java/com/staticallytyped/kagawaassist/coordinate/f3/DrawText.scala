package com.staticallytyped.kagawaassist.coordinate.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.FontRenderer

class DrawText(fontRenderer: FontRenderer) {
  private var beforeText: String = ""

  def draw(text: String, color: Int)(implicit column: Int, matrixStack: MatrixStack): Unit = {
    val dx = fontRenderer.getStringWidth(beforeText)
    val dy = fontRenderer.FONT_HEIGHT + 1
    fontRenderer.drawStringWithShadow(matrixStack, text, 2 + dx, 2 + dy * column, color)
    beforeText += text
  }
}
