package currency

trait Price {
  def toPounds: BigDecimal
}

case class Pound(amount: BigDecimal) extends Price {
  override def toPounds: BigDecimal = amount

  override def toString: String = s"""$amount Pounds"""
}

case class Penny(amount: BigDecimal) extends Price {
  override def toPounds: BigDecimal =
    amount / 100

  override def toString: String = s"""$amount Pennies"""
}
