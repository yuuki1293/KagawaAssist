package staticallytyped.kagawaassist

import net.minecraft.client.settings.KeyBinding
import net.minecraft.client.util.InputMappings
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.settings.KeyConflictContext
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import org.lwjgl.glfw.GLFW
import staticallytyped.kagawaassist.coordinate.CopyCoordinate


@Mod.EventBusSubscriber
object KeyBind {
  val KeyBindingCategory = "Kagawa Assist"

  val copyCoordinateKeyBinding = new KeyBinding(
    "座標をクリップボードにコピー",
    KeyConflictContext.IN_GAME,
    InputMappings.Type.KEYSYM,
    GLFW.GLFW_KEY_Z,
    KeyBindingCategory)

  val sendCoordinateKeyBinding = new KeyBinding(
    "座標を送信",
    KeyConflictContext.IN_GAME,
    InputMappings.Type.KEYSYM,
    GLFW.GLFW_KEY_X,
    KeyBindingCategory)

  registryKeyBindings()

  def registryKeyBindings(): Unit = {
    ClientRegistry.registerKeyBinding(copyCoordinateKeyBinding)
    ClientRegistry.registerKeyBinding(sendCoordinateKeyBinding)
  }

  @SubscribeEvent
  def onKeyInput(event: InputEvent.KeyInputEvent): Unit =
    if (copyCoordinateKeyBinding.isPressed)
      CopyCoordinate.onPressKey()
}
