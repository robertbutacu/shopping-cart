package checkout.system

import org.scalatest.FlatSpec
import shopping.cart.{Apple, Orange}

class CheckoutSystemSpec extends FlatSpec {
  "Given the example basket " should "return 2.05" in {
    CheckoutSystem.checkout(List(Apple(), Apple(), Orange(), Apple())) === (2.05: BigDecimal)
  }
}
