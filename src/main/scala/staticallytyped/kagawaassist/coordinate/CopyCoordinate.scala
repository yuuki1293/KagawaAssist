package staticallytyped.kagawaassist.coordinate

import com.mojang.blaze3d.platform.ClipboardManager
import net.minecraft.client.Minecraft
import org.apache.logging.log4j.LogManager

object CopyCoordinate {
  def onPressKey(): Unit =
    try {
      val player = Minecraft.getInstance().player
      val clipboard = new ClipboardManager()
      val text = s"${player.getX()} ${player.getY()} ${player.getZ()}"
      val window = Minecraft.getInstance().getWindow.getWindow
      clipboard.setClipboard(window, text)
    } catch {
      case e: Exception =>
        e.printStackTrace()
        LogManager.getLogger().info(s"コピーに失敗したよ")
    }
}
