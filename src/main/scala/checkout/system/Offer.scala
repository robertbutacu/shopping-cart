package checkout.system

import checkout.system.CheckoutSystem.ItemsLeftToPayCount
import shopping.cart.BasketItem


case class Offer(item: BasketItem, eligibleNumberForItems: Int, itemsForFree: Int) {
  require(eligibleNumberForItems > 0 && itemsForFree > 0)

  def applyOffer(amount: Int): ItemsLeftToPayCount = {
    val countOfEligibleOffers = amount / eligibleNumberForItems

    amount - countOfEligibleOffers * itemsForFree
  }
}
