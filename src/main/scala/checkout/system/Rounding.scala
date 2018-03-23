package checkout.system

import scala.math.BigDecimal.RoundingMode
import scala.math.BigDecimal.RoundingMode.RoundingMode

case class Rounding(roundingMode: RoundingMode = RoundingMode.UNNECESSARY, scale: Option[Int] = None)
