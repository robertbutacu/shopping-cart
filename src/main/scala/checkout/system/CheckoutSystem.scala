package checkout.system

import currency.BasketPrice
import shopping.cart.BasketItem

object CheckoutSystem {
  type ItemsLeftToPayCount = Int
  type Amount = Int

  /*
    Build a checkout system which takes a list of items scanned at the till and outputs
    the total cost
    ● For example: [ Apple, Apple, Orange, Apple ] => £2.05
 */
  def checkout(basket: List[BasketItem])(implicit round: Rounding = Rounding()): BigDecimal = {
    val basketPrice = basket.foldRight(BasketPrice())((curr, acc) => acc.add(curr))

    round.scale match {
      case None => basketPrice.toPounds
      case Some(s) => basketPrice.toPounds.setScale(s, round.roundingMode)

    }
  }

  /*
  The shop decides to introduce two new offers
  ○ buy one, get one free on Apples
  ○ 3 for the price of 2 on Oranges
  ● Update your checkout functions accordingly
   */

  def checkoutWithOffer(basket: List[BasketItem], offer: Set[Discount])(implicit round: Rounding): BigDecimal = {
    // if there is a discount available, try to apply it
    def tryToApplyDiscount(item: (BasketItem, Amount), discounts: Set[Discount]): ItemsLeftToPayCount = {
      discounts find (_.item == item._1) match {
        case None => item._2
        case Some(d) => d.applyDiscount(item._2)
      }
    }

    //needed so the discount can be applied easier
    val itemsWithCount = basket.toSet.map((item: BasketItem) => (item, basket.count(_ == item)))

    // maybe an useless optimization, but try not to fit every possible offer on every basket
    // some offers might not even be valid
    val eligibleDiscounts = offer filter basket.contains

    // for each amount of items bought, there might be discounts to apply
    // if that's the case, try to reduce the amount of items that need to be paid
    val basketToPayAfterDiscount = itemsWithCount.map(i => (i._1, tryToApplyDiscount(i, eligibleDiscounts)))

    //fill a list with the number of each item and then flatten the list
    checkout(basketToPayAfterDiscount.map(i => List.fill(i._2)(i._1)).toList.flatten)
  }
}
