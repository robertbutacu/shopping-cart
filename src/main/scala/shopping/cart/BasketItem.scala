package shopping.cart

import currency.Currency
/*
You are building a checkout system for a shop which only sells apples and
oranges.
● Apples cost 60p and oranges cost 25p.
● Build a checkout system which takes a list of items scanned at the till and outputs
the total cost
● For example: [ Apple, Apple, Orange, Apple ] => £2.05
● Make reasonable assumptions about the inputs to your solution; for example, many
candidates take a list of strings as input

 */
sealed trait BasketItem[A] {
  def price: A
}

case class Apple[A: Numeric](price: A, currency: Currency) extends BasketItem[A]

case class Orange[A: Numeric](price: A, currency: Currency) extends BasketItem[A]


