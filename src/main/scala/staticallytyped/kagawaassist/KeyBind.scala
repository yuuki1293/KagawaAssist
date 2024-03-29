package staticallytyped.kagawaassist

import com.mojang.blaze3d.platform.InputConstants
import com.mojang.blaze3d.platform.InputConstants._
import net.minecraftforge.client.event.{InputEvent, RegisterKeyMappingsEvent}
import net.minecraftforge.client.settings.{KeyConflictContext, KeyModifier}
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.coordinate.{CopyCoordinate, SendCoordinate}

@Mod.EventBusSubscriber
object KeyBind {
  implicit val keyMappingCategory: String = "Kagawa Assist"

  val keyMappings: List[KagawaAssistKeyMapping] = List(
    newKeyMap("座標をクリップボードにコピー", KEY_Z, _ => CopyCoordinate.onPressKey()),
    newKeyMap("座標を送信", KEY_V, _ => SendCoordinate.onPressKey())
  )

  def newKeyMap(name: String, key: Int, f: Unit => _)(implicit category: String): KagawaAssistKeyMapping = {
    new KagawaAssistKeyMapping(name, KeyConflictContext.IN_GAME, KeyModifier.NONE, InputConstants.Type.KEYSYM.getOrCreate(key), f)(category)
  }

  @SubscribeEvent
  def onKeyInput(event: InputEvent.Key): Unit = {
    keyMappings.foreach(keyMapping => {
      if (keyMapping.consumeClick()) {
        keyMapping.f(())
      }
    })
  }

  @SubscribeEvent
  def registerKeyMapping(event: RegisterKeyMappingsEvent): Unit = {
    keyMappings.foreach(event.register)
  }
}
