package checkout.system

import shopping.cart.BasketItem

case class Offer(item: BasketItem, eligibleNumberForItems: Int, itemsForFree: Int)
