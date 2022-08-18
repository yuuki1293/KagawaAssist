package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

abstract class AbstractPart(val f3: F3)(implicit poseStack: PoseStack) {
  val draw: (String, ConfigValue[Int]) => Unit = f3.drawText.draw

  var cancel = false

  def render(): Unit
}
