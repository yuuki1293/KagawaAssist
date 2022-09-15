package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import net.minecraft.client.gui.Font
import net.minecraftforge.client.event.RenderGuiOverlayEvent
import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import staticallytyped.kagawaassist.Config

@Mod.EventBusSubscriber
class F3() {

  val fontRenderer: Font = Minecraft.getInstance.font
  val textColor: ForgeConfigSpec.ConfigValue[Int] = Config.textColor
  val valueColor: ForgeConfigSpec.ConfigValue[Int] = Config.valueColor
  var drawText = new DrawText(fontRenderer)

  @SubscribeEvent
  def render(event: RenderGuiOverlayEvent): Unit = {
    implicit val poseStack: PoseStack = event.getPoseStack
    drawText = new DrawText(fontRenderer)
    new Coordinate(this).render()
    new Facing(this).render()
    new Time(this).render()
  }
}

