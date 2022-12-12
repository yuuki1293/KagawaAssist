package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import staticallytyped.kagawaassist.Config
import staticallytyped.kagawaassist.monad.Reader._
import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.gui.FontRenderer

object Coordinate extends Part {
  def render(xy: (Int, Int))(x0: Int, poseStack: PoseStack, fontRenderer: FontRenderer): (Int, Int) = {
    if (!Config.displayCoordinates.get()) cancel = true
    if (cancel) return xy

    val player: BlockPos = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString

    (DrawText.apply _)(xy)
      .map(DrawText.draw(textX, F3.textColor))
      .map(DrawText.draw(x, F3.valueColor))
      .map(DrawText.draw(textY, F3.textColor))
      .map(DrawText.draw(y, F3.valueColor))
      .map(DrawText.draw(textZ, F3.textColor))
      .map(DrawText.draw(z, F3.valueColor))
      .apply(x0, matrixStack, fontRenderer)
  }
}