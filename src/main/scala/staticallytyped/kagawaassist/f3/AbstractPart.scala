package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

abstract class AbstractPart(val f3: F3)(implicit poseStack: PoseStack) {
  def draw(text: String, color: Int): Unit = {
    f3.drawText.draw(text, color)
  }

  def draw(text: String, color: ConfigValue[Int]): Unit = {
    f3.drawText.draw(text, color)
  }

  var cancel = false

  def render(): Unit
}
