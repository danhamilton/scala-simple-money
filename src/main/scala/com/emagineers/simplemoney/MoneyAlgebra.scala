package com.emagineers.simplemoney

object MoneyAlgebra {

  implicit class MoneyAlg(first: Money) {

    def +(second: Money): Option[Money] =
      if (first.currency == second.currency)
        Option(first.copy(rawAmount = (first.rawAmount + second.rawAmount).setScale(first.roundingScale, first.roundingMode)))
      else None

    def -(second: Money): Option[Money] =
      if (first.currency == second.currency)
        Option(first.copy(rawAmount = (first.rawAmount - second.rawAmount).setScale(first.roundingScale, first.roundingMode)))
      else None

    def *(multiplier: BigDecimal): Option[Money] =
    Option(first.copy(rawAmount = (first.rawAmount * multiplier).setScale(first.roundingScale, first.roundingMode)))

    def /(divider: BigDecimal): Option[Money] =
      if(divider != 0)
        Option(first.copy(rawAmount = (first.rawAmount / divider).setScale(first.roundingScale, first.roundingMode)))
      else None
  }
}