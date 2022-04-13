package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.matrix.MatrixStack
import net.minecraft.client.Minecraft
import net.minecraft.util.math.BlockPos
import staticallytyped.kagawaassist.Config

class Coordinate(f3: F3)(implicit matrixStack: MatrixStack) extends AbstractPart(f3) {
  override def render(): Unit = {
    if (!Config.displayCoordinates.get()) cancel = true
    if (cancel) return

    val player: BlockPos = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString

    f3.drawText.newLine()
    draw(textX, f3.textColor)
    draw(x, f3.valueColor)
    draw(textY, f3.textColor)
    draw(y, f3.valueColor)
    draw(textZ, f3.textColor)
    draw(z, f3.valueColor)
  }
}
