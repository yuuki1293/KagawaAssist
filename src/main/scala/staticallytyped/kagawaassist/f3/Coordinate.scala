package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Font
import staticallytyped.kagawaassist.Config
import staticallytyped.kagawaassist.monad.Reader._

object Coordinate extends Part {
  def render(xy: (Int, Int))(x0: Int, poseStack: PoseStack, font: Font): (Int, Int) = {
    if (!Config.displayCoordinates.get()) cancel = true
    if (cancel) return xy

    val player = Minecraft.getInstance().player
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toInt.toString + " "
    val y = player.getY.toInt.toString + " "
    val z = player.getZ.toInt.toString

    (DrawText.apply _)(xy)
      .map(DrawText.draw(textX, F3.textColor))
      .map(DrawText.draw(x, F3.valueColor))
      .map(DrawText.draw(textY, F3.textColor))
      .map(DrawText.draw(y, F3.valueColor))
      .map(DrawText.draw(textZ, F3.textColor))
      .map(DrawText.draw(z, F3.valueColor))
      .apply(x0, poseStack, font)
  }
}