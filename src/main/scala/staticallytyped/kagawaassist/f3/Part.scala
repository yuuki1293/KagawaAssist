package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.Font

trait Part {
  var cancel = false

  def render(xy: (Int, Int))(x0: Int, poseStack: PoseStack, font: Font): (Int, Int)
}