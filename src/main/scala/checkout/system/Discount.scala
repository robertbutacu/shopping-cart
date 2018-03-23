package checkout.system

import checkout.system.CheckoutSystem.ItemsLeftToPayCount
import shopping.cart.BasketItem

case class Discount(item: BasketItem, eligibleNumberForItems: Int, itemsForFree: Int) {
  require(eligibleNumberForItems > 0 && itemsForFree > 0 && eligibleNumberForItems >= itemsForFree)

  def applyDiscount(amount: Int): ItemsLeftToPayCount = {
    def basketPerfectMatches: Stream[Int] =
      Stream.from(0).map(i => i * eligibleNumberForItems + i * itemsForFree)

    val countOfEligibleOffers = basketPerfectMatches.takeWhile(_ <= amount).length

    amount - countOfEligibleOffers * itemsForFree
  }
}
