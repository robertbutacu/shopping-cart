package checkout.system

import scala.math.BigDecimal.RoundingMode.RoundingMode

case class Rounding(roundingMode: RoundingMode, scale: Option[Int] = None)
