package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

class DrawText(fontRenderer: FontRenderer) {
  private var beforeText: String = ""
  private var column = -1

  def draw(text: String, color: ConfigValue[Int])(implicit matrixStack: MatrixStack): Unit = {
    val dx = fontRenderer.getStringWidth(beforeText)
    val dy = fontRenderer.FONT_HEIGHT + 1
    fontRenderer.drawStringWithShadow(matrixStack, text, 2 + dx, 2 + dy * column, color.get())
    beforeText += text
  }

  def newLine(): Unit = {
    column += 1
    beforeText = ""
  }
}
