package staticallytyped.kagawaassist.coordinate

import net.minecraft.client.Minecraft
import org.apache.logging.log4j.LogManager
import net.minecraft.client.ClipboardHelper

object CopyCoordinate {
  def onPressKey(): Unit =
    try {
      val player = Minecraft.getInstance().player
      val position = player.getPosition
      val clipboard = new ClipboardHelper()
      val text = s"${position.getX} ${position.getY} ${position.getZ}"
      val window = Minecraft.getInstance().getMainWindow.getHandle
      clipboard.setClipboardString(window, text)
    } catch {
      case e : Exception=>
        e.printStackTrace()
        LogManager.getLogger().info(s"コピーに失敗したよ")
    }
}
