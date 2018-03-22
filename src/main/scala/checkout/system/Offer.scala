package checkout.system

import shopping.cart.BasketItem

case class Offer(item: BasketItem, eligibleNumberForItems: Int, itemsForFree: Int) {
  type ItemsLeftToPayCount = Int
  require(eligibleNumberForItems > 0 && itemsForFree > 0)

  def applyOffer(amount: Int): ItemsLeftToPayCount = {
    0
  }
}
