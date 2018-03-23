package checkout.system

import org.scalatest.FlatSpec
import shopping.cart.{Apple, Orange}

import scala.math.BigDecimal.RoundingMode

class CheckoutSystemSpec extends FlatSpec {
  implicit val rounding: Rounding = Rounding(RoundingMode.HALF_EVEN, Some(2))
  val apple = Apple()
  val orange = Orange()
  val basket = List(apple, apple, orange, apple)
  val appleDiscount = Discount(apple, 1, 1)
  val orangeDiscount = Discount(orange, 2, 1)


  "Given the example basket " should "return 2.05" in {
    CheckoutSystem.checkout(basket) === (2.05: BigDecimal)
  }

  //  ○ buy one, get one free on Apples
  //○ 3 for the price of 2 on Oranges
  "Given the example basket " should " return  after the discount " in {
    CheckoutSystem.checkoutWithOffer(basket, Set(appleDiscount, orangeDiscount)) === (1.45: BigDecimal)
  }

  "Given a basket eligible for a discount on oranges too" should "apply the discount " in {
    val newBasket = basket ::: List(orange, orange)
    CheckoutSystem.checkoutWithOffer(newBasket, Set(appleDiscount, orangeDiscount)) === (1.70: BigDecimal)
  }

  "Given a larger basket " should " apply the discount correctly " in {
    val largerBasket = basket ::: List(orange, orange, orange, apple, apple)

    //5 apples => 2 are on discount, has to pay 3
    //4 oranges => 1 is on discount, has to pay 3

    // 3 * 60 + 3 * 25 = 180 + 75 = 255 / 100 => 25.5 pounds

    CheckoutSystem.checkoutWithOffer(largerBasket, Set(appleDiscount, orangeDiscount)) === (25.5: BigDecimal)
  }
}
