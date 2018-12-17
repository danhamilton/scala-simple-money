package com.emagineers.simplemoney


trait MoneyOpsTypeClass[T] {
  def gbp(): Money
  def usd(): Money
  def asCurrency(currency: Currency): Money

  def makeMoney(amount: BigDecimal, currency: Currency): Money =
    Money(amount, currency)
}

object MoneyOps {

  implicit class MoneyOpsBigDecimal(amount: BigDecimal) extends MoneyOpsTypeClass[BigDecimal] {
    def gbp(): Money = makeMoney(amount, GBP)
    def usd(): Money = makeMoney(amount, USD)
    def asCurrency(currency: Currency): Money = makeMoney(amount, currency)
  }

  implicit class MoneyOpsInt(amount: Int) extends MoneyOpsTypeClass[Int] {
    override def gbp(): Money = makeMoney(BigDecimal(amount), GBP)
    override def usd(): Money = makeMoney(BigDecimal(amount), USD)
    override def asCurrency(currency: Currency): Money = makeMoney(BigDecimal(amount), currency)
  }

  implicit class MoneyOpsLong(amount: Long) extends MoneyOpsTypeClass[Long] {
    override def gbp(): Money = makeMoney(BigDecimal(amount), GBP)
    override def usd(): Money = makeMoney(BigDecimal(amount), USD)
    override def asCurrency(currency: Currency): Money = makeMoney(BigDecimal(amount), currency)
  }

  implicit class MoneyOpsFloat(amount: Float) extends MoneyOpsTypeClass[Float] {
    override def gbp(): Money = makeMoney(BigDecimal(amount), GBP)
    override def usd(): Money = makeMoney(BigDecimal(amount), USD)
    override def asCurrency(currency: Currency): Money = makeMoney(BigDecimal(amount), currency)
  }

  implicit class MoneyOpsDouble(amount: Double) extends MoneyOpsTypeClass[Double] {
    override def gbp(): Money = makeMoney(BigDecimal(amount), GBP)
    override def usd(): Money = makeMoney(BigDecimal(amount), USD)
    override def asCurrency(currency: Currency): Money = makeMoney(BigDecimal(amount), currency)
  }
}