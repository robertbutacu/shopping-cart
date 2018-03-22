package checkout.system

import shopping.cart.BasketItem

/*
Build a checkout system which takes a list of items scanned at the till and outputs
the total cost
● For example: [ Apple, Apple, Orange, Apple ] => £2.05
 */
object CheckoutSystem {
  def checkout[A: Numeric](basket: List[BasketItem]): BigDecimal = {
    0:BigDecimal
  }
}
