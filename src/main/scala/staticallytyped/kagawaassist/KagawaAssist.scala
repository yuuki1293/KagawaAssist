package staticallytyped.kagawaassist;

import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.ModLoadingContext
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.config.ModConfig
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import org.apache.logging.log4j.LogManager
import staticallytyped.kagawaassist.f3.F3;

@Mod(KagawaAssist.MODID)
object KagawaAssist {
  final val MODID = "kagawaassist"
  final val LOGGER = LogManager.getLogger()

  FMLJavaModLoadingContext.get().getModEventBus.addListener(doClientStuff)

  ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.spec, "KagawaAssist.toml")
  // Register ourselves for server and other game events we are interested in
  MinecraftForge.EVENT_BUS.register(this)

  private def doClientStuff(event: FMLClientSetupEvent): Unit = {
    MinecraftForge.EVENT_BUS.register(new F3())
  }
}
