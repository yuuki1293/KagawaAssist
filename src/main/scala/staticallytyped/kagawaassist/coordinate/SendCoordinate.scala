package staticallytyped.kagawaassist.coordinate

import net.minecraft.client.Minecraft

object SendCoordinate {
  def onPressKey(): Unit = {
    val player = Minecraft.getInstance().player
    val text = s"${player.getX.toInt} ${player.getY.toInt} ${player.getZ.toInt}"
    player.chat(text)
  }
}
