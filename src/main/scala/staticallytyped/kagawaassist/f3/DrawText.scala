package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue
import staticallytyped.kagawaassist.monad.Reader._

import scala.annotation.unused

object DrawText {
  def draw(text: String, color: ConfigValue[Int])(xy: (Int, Int))(mf: (MatrixStack, FontRenderer)): (Int, Int) = {
    val (x, y) = xy
    val (matrixStack, fontRenderer) = mf

    fontRenderer.drawStringWithShadow(
      matrixStack,
      text, 2 + x,
      2 + y,
      color.get()
    )

    val dx = fontRenderer.getStringWidth(text)
    (x + dx, y)
  }

  def drawln(text: String, color: ConfigValue[Int])(xy: (Int, Int))(mf: (MatrixStack, FontRenderer)): (Int, Int) = {
    (draw _)(text, color)(xy)
      .map(newLine)
      .apply(mf)
  }

  def newLine(xy: (Int, Int))(mf: (MatrixStack, FontRenderer)): (Int, Int) = {
    val (x, y) = xy
    val (_, fontRenderer) = mf
    (x, y + fontRenderer.FONT_HEIGHT + 1)
  }

  def apply(xy: (Int, Int))(@unused mf: (MatrixStack, FontRenderer)): (Int, Int) = xy
}
