package staticallytyped.kagawaassist.coordinate

import net.minecraft.client.Minecraft

object SendCoordinate {
  def onPressKey(): Unit = {
    val player = Minecraft.getInstance().player
    val text = s"${player.getX()} ${player.getY()} ${player.getZ()}"
    player.chat(text)
  }
}
