package com.emagineers.simplemoney

object MoneyOps {

  implicit class MoneyOps(amount: BigDecimal) {
    def gbp(): Money = Money(amount, GBP)
    def usd(): Money = Money(amount, USD)
    def asCurrency(currency: Currency): Money = Money(amount, currency)
  }
}