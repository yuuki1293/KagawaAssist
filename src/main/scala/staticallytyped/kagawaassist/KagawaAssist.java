package staticallytyped.kagawaassist;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import staticallytyped.kagawaassist.f3.F3;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KagawaAssist.MODID)
public class KagawaAssist {
    public static final String MODID = "kagawaassist";
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public KagawaAssist() {
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(KeyBind::registerKeyMapping);

        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.spec(), "KagawaAssist.toml");
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new F3());
    }
}
