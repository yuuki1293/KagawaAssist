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
  val coordinateKeyBinding = new KeyBinding(
    "key.kagawaassist.name",
    KeyConflictContext.IN_GAME,
    InputMappings.Type.KEYSYM,
    GLFW.GLFW_KEY_Z,
  "key.kagawaassist.coordinate")
  ClientRegistry.registerKeyBinding(coordinateKeyBinding)

  @SubscribeEvent
  def onKeyInput(event: InputEvent.KeyInputEvent): Unit = {
    if (coordinateKeyBinding.isPressed) {
      Coordinate.onPressKey()
    }
  }
}
