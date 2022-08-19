package staticallytyped.kagawaassist

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.ClientRegistry
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.settings.KeyConflictContext
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.coordinate.{CopyCoordinate, SendCoordinate}


@Mod.EventBusSubscriber
object KeyBind {
  val KeyMappingCategory = "Kagawa Assist"

  val copyCoordinateKeyMapping = new KeyMapping(
    "座標をクリップボードにコピー",
    InputConstants.KEY_Z,
    KeyMappingCategory)

  val sendCoordinateKeyMapping = new KeyMapping(
    "座標を送信",
    InputConstants.KEY_V,
    KeyMappingCategory)

  registryKeyBindings()

  def registryKeyBindings(): Unit = {
    ClientRegistry.registerKeyBinding(copyCoordinateKeyMapping)
    ClientRegistry.registerKeyBinding(sendCoordinateKeyMapping)
  }

  @SubscribeEvent
  def onKeyInput(event: InputEvent.KeyInputEvent): Unit = {
    if (copyCoordinateKeyMapping.isDown)
      CopyCoordinate.onPressKey()
    if (sendCoordinateKeyMapping.isDown)
      SendCoordinate.onPressKey()
  }
}
