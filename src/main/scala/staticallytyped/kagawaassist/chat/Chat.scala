package staticallytyped.kagawaassist.chat

import net.minecraftforge.client.event.ClientChatReceivedEvent
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.Config
import scala.jdk.CollectionConverters._

import java.util

@Mod.EventBusSubscriber
object Chat {
  val enable: ForgeConfigSpec.BooleanValue = Config.enableChatFilter
  val filters: ConfigValue[util.List[String]] = Config.chatFilter

  @SubscribeEvent
  def onChatReceived(event: ClientChatReceivedEvent): Unit = {
    if (enable.get()) {
      val message = event.getMessage.getString

      if (containFiltered(message)) {
        event.setCanceled(true)
      }
    }
  }

  private def containFiltered(message: String): Boolean = {
    filters.get().asScala
      .exists(message.contains)
  }
}
