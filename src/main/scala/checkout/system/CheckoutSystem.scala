package checkout.system

import currency.BasketPrice
import shopping.cart.BasketItem

/*
Build a checkout system which takes a list of items scanned at the till and outputs
the total cost
● For example: [ Apple, Apple, Orange, Apple ] => £2.05
 */
object CheckoutSystem {
  def checkout(basket: List[BasketItem]): BigDecimal = {
    val basketPrice = basket.foldRight(BasketPrice())((curr, acc) => acc.add(curr))

    basketPrice.toPounds
  }
}
