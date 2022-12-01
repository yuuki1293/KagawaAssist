package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack

trait Part {
  var cancel = false

  def render(xy: (Int, Int))(matrixStack: MatrixStack): (Int, Int)
}