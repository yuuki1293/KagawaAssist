package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.Font
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue
import staticallytyped.kagawaassist.monad.Reader._

import scala.annotation.unused

object DrawText {
  def draw(text: String, color: ConfigValue[Int])(xy: (Int, Int))(@unused x0: Int, matrixStack: MatrixStack, fontRenderer: FontRenderer): (Int, Int) = {
    val (x, y) = xy

    fontRenderer.drawShadow(
      poseStack,
      text,
      2 + x,
      2 + y,
      color.get()
    )

    val dx = fontRenderer.getStringWidth(text)
    (x + dx, y)
  }

  def newLine(xy: (Int, Int))(x0: Int, @unused poseStack: PoseStack, fontRenderer: FontRenderer): (Int, Int) = {
    val (_, y) = xy
    (x0, y + fontRenderer.FONT_HEIGHT + 1)
  }

  def apply(xy: (Int, Int))(@unused x0: Int, @unused poseStack: PoseStack, @unused fontRenderer: FontRenderer): (Int, Int) = xy
}
