package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.Font
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

import scala.annotation.unused

object DrawText {
  def draw(text: String, color: ConfigValue[Int])(xy: (Int, Int))(@unused x0: Int, poseStack: PoseStack, font: Font): (Int, Int) = {
    val (x, y) = xy

    font.drawShadow(
      poseStack,
      text,
      2 + x,
      2 + y,
      color.get()
    )

    val dx = font.width(text)
    (x + dx, y)
  }

  def newLine(xy: (Int, Int))(x0: Int, @unused poseStack: PoseStack, font: Font): (Int, Int) = {
    val (_, y) = xy
    (x0, y + font.lineHeight + 1)
  }

  def apply(xy: (Int, Int))(@unused x0: Int, @unused poseStack: PoseStack, @unused font: Font): (Int, Int) = xy
}
