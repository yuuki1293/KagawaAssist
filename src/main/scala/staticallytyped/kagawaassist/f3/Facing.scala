package staticallytyped.kagawaassist.f3

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.Minecraft
import staticallytyped.kagawaassist.Config

//NOTE: north 180, south 0, east 270, west 90
object Facing extends Part {
  override def render(xy: (Int, Int))(x0: Int, matrixStack: MatrixStack, fontRenderer: FontRenderer): (Int, Int) = {
    if (!Config.displayFacing.get() || !Config.displayDirection.get()) cancel = true
    if (cancel) return xy

    val text = s"facing: "

    val f1 = (DrawText.apply _)(xy)
      .map(DrawText.draw(text, F3.textColor))

    val player = Minecraft.getInstance.player
    val facing = player.getRotationVector.y

    val f2 = if (Config.displayFacing.get()) {
      val valueUS = getUS(facing)
      f1.map(DrawText.draw(valueUS, F3.valueColor))
        .map(DrawText.draw(" ", F3.textColor))
    } else f1

    val f3 = if (Config.displayDirection.get()) {
      val valueXY = getXZ(facing)
      f2.map(DrawText.draw(valueXY, F3.valueColor))
    } else f2

    f3.apply(x0, matrixStack, fontRenderer)
  }

  private def trimFacing(facing: Float): Float = {
    val trimFacing = facing % 360
    val unsignedFacing = if (trimFacing < 0) trimFacing + 360 else trimFacing
    unsignedFacing
  }

  private def getUS(facing: Float): String = {
    val trimmed = trimFacing(facing)
    trimmed match {
      case x if x < 11.25 => "S"
      case x if x < 33.75 => "SSW"
      case x if x < 56.25 => "SW"
      case x if x < 78.75 => "WSW"
      case x if x < 101.25 => "W"
      case x if x < 123.75 => "WNW"
      case x if x < 146.25 => "NW"
      case x if x < 168.75 => "NNW"
      case x if x < 191.25 => "N"
      case x if x < 213.75 => "NNE"
      case x if x < 236.25 => "NE"
      case x if x < 258.75 => "ENE"
      case x if x < 281.25 => "E"
      case x if x < 303.75 => "ESE"
      case x if x < 326.25 => "SE"
      case x if x < 348.75 => "SSE"
      case _ => "S"
    }
  }

  private def getXZ(facing: Float): String = {
    val trimmed = trimFacing(facing)
    val X = {
      trimmed match {
        case x if x < 180 => "X-"
        case _ => "X+"
      }
    }
    val Z = {
      trimmed match {
        case y if y < 90 => "Z+"
        case y if y < 270 => "Z-"
        case _ => "Z+"
      }
    }
    X + " " + Z
  }
}
