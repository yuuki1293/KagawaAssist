package staticallytyped.kagawaassist

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.screen.Screen
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.{ExtensionPoint, ModLoadingContext}
import org.apache.logging.log4j.{LogManager, Logger}
import staticallytyped.kagawaassist.chat.Chat
import staticallytyped.kagawaassist.f3.F3
import staticallytyped.kagawaassist.gui.screen.ModSettingsScreen

import java.util.function.BiFunction

@Mod(KagawaAssist.MODID)
class KagawaAssist {
  ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.spec, "KagawaAssist.toml")
  ModLoadingContext.get().registerExtensionPoint(
    ExtensionPoint.CONFIGGUIFACTORY,
    () => ((mc: Minecraft, screen: Screen) => new ModSettingsScreen(screen)): BiFunction[Minecraft,Screen,Screen]
  )

  MinecraftForge.EVENT_BUS.register(this)
  MinecraftForge.EVENT_BUS.register(F3)
  MinecraftForge.EVENT_BUS.register(Chat)
}

object KagawaAssist {
  final val MODID = "kagawa-assist"
  final val LOGGER: Logger = LogManager.getLogger
}