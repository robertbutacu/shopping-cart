package checkout.system

import org.scalatest.FlatSpec
import shopping.cart.{Apple, Orange}

import scala.math.BigDecimal.RoundingMode

class CheckoutSystemSpec extends FlatSpec {
  implicit val rounding: Rounding = Rounding(RoundingMode.HALF_EVEN, Some(2))

  "Given the example basket " should "return 2.05" in {
    CheckoutSystem.checkout(List(Apple(), Apple(), Orange(), Apple())) === (2.05: BigDecimal)
  }
}
