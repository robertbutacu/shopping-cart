package checkout.system

import currency.BasketPrice
import shopping.cart.{Apple, BasketItem}

import scala.math.BigDecimal.RoundingMode
import scala.math.BigDecimal.RoundingMode.RoundingMode


object CheckoutSystem {
  /*
    Build a checkout system which takes a list of items scanned at the till and outputs
    the total cost
    ● For example: [ Apple, Apple, Orange, Apple ] => £2.05
 */
  def checkout(basket: List[BasketItem], roundingMode: RoundingMode): BigDecimal = {
    val basketPrice = basket.foldRight(BasketPrice())((curr, acc) => acc.add(curr))

    basketPrice.toPounds.setScale(2, roundingMode)
  }

  /*
  The shop decides to introduce two new offers
  ○ buy one, get one free on Apples
  ○ 3 for the price of 2 on Oranges
  ● Update your checkout functions accordingly
   */

  def checkoutWithOffer(basket: List[BasketItem]): BigDecimal = {
    val amountOfApples = basket.count(_.toString == "Apple")

    val amountOfOranges = basket.count(_.toString == "Orange")

    0: BigDecimal
  }
}
