package staticallytyped.kagawaassist.chat

import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber
object Chat {
  @SubscribeEvent
  def onChatReceived(event: ClientChatReceivedEvent): Unit = {
    val message = event.getMessage.getString
    if (message.contains("hoge")){
      event.setCanceled(true)
    }
  }
}
