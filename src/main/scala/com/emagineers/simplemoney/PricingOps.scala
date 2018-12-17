package com.emagineers.simplemoney

object PricingOps {

  implicit class PricingOps(money: Money) {

    def addMarkup(markup: BigDecimal): Money =
      money.copy(rawAmount = PricingAlgebra.markupPriceByPercentage(money.value, markup))

    def getMarkup(markup: BigDecimal): Money =
      money.copy(rawAmount = PricingAlgebra.getMarkUpAmount(money.value, markup))

    def getBaseCostFromMarkedUp(markup: BigDecimal): Money =
      money.copy(rawAmount = PricingAlgebra.getBaseCostFromMarkedUpPrice(money.value, markup))

    def addMargin(margin: BigDecimal): Money =
      money.copy(rawAmount = PricingAlgebra.marginatePriceByPercentage(money.value, margin))

    def getMargin(margin: BigDecimal): Money =
      money.copy(rawAmount = PricingAlgebra.getMarginAmount(money.value, margin))

    def getBaseCostFromMarginated(margin: BigDecimal): Money =
      money.copy(rawAmount = PricingAlgebra.getBaseCostFromMarginatedPrice(money.value, margin))
  }
}