package com.staticallytyped.kagawaassist
import com.staticallytyped.kagawaassist.coordinate.Coordinate
import net.minecraft.client.settings.KeyBinding
import net.minecraft.client.util.InputMappings
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.settings.KeyConflictContext
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.client.registry.ClientRegistry
import net.minecraftforge.fml.common.Mod
import org.lwjgl.glfw.GLFW


@Mod.EventBusSubscriber
object KeyBind {
  val KeyBindingDescription = "Kagawa Assist"

  val coordinateKeyBinding = new KeyBinding(
    KeyBindingDescription,
    KeyConflictContext.IN_GAME,
    InputMappings.Type.KEYSYM,
    GLFW.GLFW_KEY_Z,
  "座標をクリップボードにコピー")
  ClientRegistry.registerKeyBinding(coordinateKeyBinding)

  @SubscribeEvent
  def onKeyInput(event: InputEvent.KeyInputEvent): Unit = {
    if (coordinateKeyBinding.isPressed) {
      Coordinate.onPressKey()
    }
  }
}
