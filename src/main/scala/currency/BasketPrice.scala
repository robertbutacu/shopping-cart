package currency

import shopping.cart.BasketItem

case class BasketPrice(pounds: Pound = Pound(), pennies: Penny = Penny()) {
  def add(basketItem: BasketItem): BasketPrice = {
    basketItem.price match {
      case Pound(a) => BasketPrice(Pound(pounds.amount + a), pennies)
      case Penny(a) => BasketPrice(pounds, Penny(pennies.amount + a))
    }
  }

  def toPounds: BigDecimal = pounds.toPounds + pennies.toPounds
}
