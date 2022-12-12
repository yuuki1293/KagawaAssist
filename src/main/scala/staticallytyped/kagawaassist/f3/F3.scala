package staticallytyped.kagawaassist.f3

import net.minecraft.client.Minecraft
import net.minecraftforge.client.event.RenderGuiOverlayEvent
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.Config
import staticallytyped.kagawaassist.monad.Reader._

@Mod.EventBusSubscriber
object F3 {
  val textColor: ForgeConfigSpec.ConfigValue[Int] = Config.textColor
  val valueColor: ForgeConfigSpec.ConfigValue[Int] = Config.valueColor

  @SubscribeEvent
  def render(event: RenderGuiOverlayEvent.Pre): Unit = {
    (Coordinate.render _)((0, 0))
      .map(DrawText.newLine)
      .map(Facing.render)
      .map(DrawText.newLine)
      .map(Time.render)
      .apply(
        0,
        event.getPoseStack,
        Minecraft.getInstance().font
      )
  }
}