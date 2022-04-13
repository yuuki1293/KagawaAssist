package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue

abstract class AbstractPart(column: Int)(val f3: F3)(implicit matrixStack: MatrixStack) {
  val drawText: (String, ConfigValue[Int]) => Unit = new DrawText(f3.fontRenderer).draw(column)

  def render(): Unit
}
