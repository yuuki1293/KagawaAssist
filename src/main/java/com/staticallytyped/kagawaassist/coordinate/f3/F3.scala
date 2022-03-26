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
        renderCoordinate(event)
      case _ => ()
    }

  def renderCoordinate(event: RenderGameOverlayEvent): Unit = {
    val player = Minecraft.getInstance.player.getPosition
    val textX = s"x: "
    val textY = s"y: "
    val textZ = s"z: "
    val x = player.getX.toString + " "
    val y = player.getY.toString + " "
    val z = player.getZ.toString
    def draw(text: String, before: String, color: Int): Unit = {
      val dx = fontRenderer.getStringWidth(before)
      fontRenderer.drawStringWithShadow(event.getMatrixStack, text, 2 + dx, 2, color)
    }
    draw(textX, "", textColor)
    draw(x, textX, valueColor)
    draw(textY, textX + x, textColor)
    draw(y, textX + x + textY, valueColor)
    draw(textZ, textX + x + textY + y, textColor)
    draw(z, textX + x + textY + y + textZ, valueColor)
  }
}

