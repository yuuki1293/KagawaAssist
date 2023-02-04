package staticallytyped.kagawaassist

import net.minecraft.client.GameSettings
import net.minecraft.client.settings.{BooleanOption, SliderMultiplierOption}
import net.minecraft.util.text.{StringTextComponent, TextComponent}

object ModOption {
  final val TEXT_COLOR = new SliderMultiplierOption(
    "options.kagawaassist.textColor",
    0x000000,
    0xffffff,
    1,
    _ => Config.textColor.get(),
    (_, value) => Config.textColor.set(value.toInt),
    (_, _) => new StringTextComponent(Config.textColor.get().toString)
  )

  final val VALUE_COLOR = new SliderMultiplierOption(
    "options.kagawaassist.valueColor",
    0x000000,
    0xffffff,
    1,
    _ => Config.valueColor.get(),
    (_, value) => Config.valueColor.set(value.toInt),
    (_, _) => new StringTextComponent(Config.valueColor.get().toString)
  )

  final val DISPLAY_COORDINATES = new BooleanOption(
    "options.kagawaassist.displayCoordinates",
    (_: GameSettings) => Config.displayCoordinates.get(),
    (_, value) => Config.displayCoordinates.set(value)
  )

  final val DISPLAY_FACING = new BooleanOption(
    "options.kagawaassist.displayFacing",
    (_: GameSettings) => Config.displayFacing.get(),
    (_, value) => Config.displayFacing.set(value)
  )

  final val DISPLAY_DIRECTION = new BooleanOption(
    "options.kagawaassist.displayDirection",
    (_: GameSettings) => Config.displayDirection.get(),
    (_, value) => Config.displayDirection.set(value)
  )

  final val DISPLAY_TIME = new BooleanOption(
    "options.kagawaassist.displayTime",
    (_: GameSettings) => Config.displayTime.get(),
    (_, value) => Config.displayTime.set(value)
  )
}
