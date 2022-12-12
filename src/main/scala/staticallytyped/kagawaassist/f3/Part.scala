package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.FontRenderer

trait Part {
  var cancel = false

  def render(xy: (Int, Int))(mf: (MatrixStack, FontRenderer)): (Int, Int)
}