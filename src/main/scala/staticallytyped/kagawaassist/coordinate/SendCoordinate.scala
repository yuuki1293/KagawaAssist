package staticallytyped.kagawaassist.coordinate

import net.minecraft.client.Minecraft
import net.minecraft.client.entity.player.ClientPlayerEntity
import net.minecraft.util.math.BlockPos

object SendCoordinate {
  def onPressKey(): Unit = {
    val player: ClientPlayerEntity = Minecraft.getInstance().player
    val position: BlockPos = player.getPosition
    val text = s"${position.getX} ${position.getY} ${position.getZ}"
    player.sendChatMessage(text)
  }
}
