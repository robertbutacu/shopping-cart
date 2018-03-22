package currency

trait Price {
  def toPounds: BigDecimal
}

case class Pound(amount: BigDecimal = 0: BigDecimal) extends Price {
  override def toPounds: BigDecimal = amount

  override def toString: String = s"""$amount Pounds"""
}

//amount is Int so there will be no half a penny
case class Penny(amount: Int = 0) extends Price {
  override def toPounds: BigDecimal =
    (amount: BigDecimal) / 100

  override def toString: String = s"""$amount Pennies"""
}
