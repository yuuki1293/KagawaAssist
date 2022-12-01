package staticallytyped.kagawaassist.f3

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.Config
import staticallytyped.kagawaassist.monad.Reader._

@Mod.EventBusSubscriber
object F3 {
  val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  val textColor: ForgeConfigSpec.ConfigValue[Int] = Config.textColor
  val valueColor: ForgeConfigSpec.ConfigValue[Int] = Config.valueColor

  val parts: List[Part] = List(
    Coordinate
  )

  @SubscribeEvent
  def render(event: RenderGameOverlayEvent): Unit = {
    if (event.getType == RenderGameOverlayEvent.ElementType.TEXT) {
      Coordinate.render _((0, 0))
        .map(DrawText.newLine)
        .map(Facing.render)
        .map(DrawText.newLine)
        .map(Time.render)
    }
  }
}

