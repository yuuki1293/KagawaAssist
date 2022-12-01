package staticallytyped.kagawaassist.f3

import net.minecraft.client.Minecraft
import net.minecraft.util.math.BlockPos
import staticallytyped.kagawaassist.Config
import staticallytyped.kagawaassist.monad.Reader._
import com.mojang.blaze3d.matrix.MatrixStack

object Coordinate extends Part {
  def render(xy: (Int, Int))(matrixStack: MatrixStack): (Int, Int) = {
    if (!Config.displayCoordinates.get()) cancel = true
    if (cancel) return xy

    val player: BlockPos = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString

    //    val f = for {
    //      i1 <- DrawText.newLine _((0, 0))
    //      i2 <- DrawText.draw(textX, F3.textColor)(i1)
    //      i3 <- DrawText.draw(x, F3.valueColor)(i2)
    //      i4 <- DrawText.draw(textY, F3.textColor)(i3)
    //      i5 <- DrawText.draw(y, F3.valueColor)(i4)
    //      i6 <- DrawText.draw(textZ, F3.textColor)(i5)
    //      i7 <- DrawText.draw(z, F3.valueColor)(i6)
    //    } yield i7
    //    f(matrixStack)

    DrawText _(xy)
      .map(DrawText.draw(textX, F3.textColor))
      .map(DrawText.draw(x, F3.valueColor))
      .map(DrawText.draw(textY, F3.textColor))
      .map(DrawText.draw(y, F3.valueColor))
      .map(DrawText.draw(textZ, F3.textColor))
      .map(DrawText.draw(z, F3.valueColor))
      .apply(matrixStack)
  }
}