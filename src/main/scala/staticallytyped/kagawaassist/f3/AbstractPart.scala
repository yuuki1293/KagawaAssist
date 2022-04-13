package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

abstract class AbstractPart(val f3: F3)(implicit matrixStack: MatrixStack) {
  val draw: (String, ConfigValue[Int]) => Unit = f3.drawText.draw

  var cancel = false

  def render(): Unit
}
