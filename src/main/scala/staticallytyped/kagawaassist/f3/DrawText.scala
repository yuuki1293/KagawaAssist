package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

object DrawText {
  def draw(text: String, color: ConfigValue[Int])(xy: (Int, Int))(matrixStack: MatrixStack): (Int, Int) = {
    val (x, y) = xy

    F3.fontRenderer.drawStringWithShadow(
      matrixStack,
      text, 2 + x,
      2 + y,
      color.get()
    )

    val dx = F3.fontRenderer.getStringWidth(text)
    (x + dx, y)
  }

  def drawln(text: String, color: ConfigValue[Int])(xy: (Int, Int))(matrixStack: MatrixStack): (Int, Int) = {
    newLine(draw(text, color)(xy)(matrixStack))(matrixStack)
  }

  def newLine(xy: (Int, Int))(matrixStack: MatrixStack): (Int, Int) = {
    val (x, y) = xy
    (x, y + F3.fontRenderer.FONT_HEIGHT + 1)
  }

  def apply(xy: (Int, Int))(matrixStack: MatrixStack): (Int, Int) = xy
}
