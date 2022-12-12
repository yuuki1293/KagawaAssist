package staticallytyped.kagawaassist

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import org.apache.logging.log4j.{LogManager, Logger}
import staticallytyped.kagawaassist.f3.F3

@Mod(KagawaAssist.MODID)
class KagawaAssist {
  ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.spec, "KagawaAssist.toml")

  MinecraftForge.EVENT_BUS.register(this)
  MinecraftForge.EVENT_BUS.register(F3)
}

object KagawaAssist {
  final val MODID = "kagawa-assist"
  final val LOGGER: Logger = LogManager.getLogger
}