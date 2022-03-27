package com.staticallytyped.kagawaassist.coordinate.f3

import net.minecraft.client.Minecraft
import net.minecraft.client.gui.FontRenderer
import net.minecraftforge.api.distmarker.{Dist, OnlyIn}
import net.minecraftforge.client.event.RenderGameOverlayEvent
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.SubscribeEvent

@OnlyIn(Dist.CLIENT)
class F3() {
  MinecraftForge.EVENT_BUS.register(this)

  private val fontRenderer: FontRenderer = Minecraft.getInstance.fontRenderer
  private val textColor = 0xf3a305
  private val valueColor = 0xFFFFFF

  @SubscribeEvent
  def render(event: RenderGameOverlayEvent): Unit =
    event.getType match {
      case RenderGameOverlayEvent.ElementType.TEXT =>
        implicit val e: RenderGameOverlayEvent = event
        new Coordinate(0).render()
        new Facing(1).render()
      case _ => ()
    }

  def draw(text: String, before: String, color: Int)(implicit column: Int, event:RenderGameOverlayEvent): Unit = {
    val dx = fontRenderer.getStringWidth(before)
    val dy = fontRenderer.FONT_HEIGHT + 1
    fontRenderer.drawStringWithShadow(event.getMatrixStack, text, 2 + dx, 2 + dy * column, color)
  }
}

