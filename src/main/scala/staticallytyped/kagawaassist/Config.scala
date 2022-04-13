package staticallytyped.kagawaassist

import net.minecraftforge.common.ForgeConfigSpec
import net.minecraftforge.common.ForgeConfigSpec.{Builder, ConfigValue}

object Config {
  val builder = new Builder()

  val textColor: ConfigValue[Int] =
    builder
      .comment("テキストの色", "default: 0xf3a305")
      .define("text color", 0xf3a305)

  val valueColor: ConfigValue[Int] =
    builder
      .comment("値の色", "default: 0xffffff")
      .define("value color", 0xffffff)

  builder.push("display toggle")

  val displayCoordinates: ForgeConfigSpec.BooleanValue =
    builder
      .comment("座標を表示するか", "default: true")
      .define("display coordinates", true)

  val displayFacing: ForgeConfigSpec.BooleanValue =
    builder
      .comment("向いている方角（東西南北）を表示するか", "default: true")
      .define("display facing", true)

  val displayDirection: ForgeConfigSpec.BooleanValue =
    builder
      .comment("向いている方向（X± Z±)を表示するか", "default: true")
      .define("display direction", true)

  val displayTime: ForgeConfigSpec.BooleanValue =
    builder
      .comment("現在時刻を表示するか", "default: true")
      .define("display time", true)

  builder.pop()

  val timePattern: ConfigValue[String] =
    builder
      .comment("時刻表示のパターン", "詳しくはこちらを参照 https://docs.oracle.com/javase/jp/8/docs/api/java/time/format/DateTimeFormatter.html#patterns", "default: HH:mm:ss")
      .define("time pattern", "HH:mm:ss")

  val spec: ForgeConfigSpec = builder.build()
}