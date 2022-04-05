package staticallytyped.kagawaassist.coordinate

import net.minecraft.client.Minecraft
import org.apache.logging.log4j.LogManager

object Coordinate {
  def onPressKey(): Unit =
    try {
      val player = Minecraft.getInstance().player
      val position = player.getPosition
      player.sendChatMessage(s"!${position.getX} ${position.getY} ${position.getZ}")
    } catch {
      case e : Exception=>
        e.printStackTrace()
        LogManager.getLogger().info(s"チャットの送信に失敗したよ")
    }
}
