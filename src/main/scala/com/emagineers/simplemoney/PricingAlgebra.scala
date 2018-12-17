package com.emagineers.simplemoney

import scala.math.BigDecimal.RoundingMode

object PricingAlgebra {

  def markupPriceByPercentage(base: BigDecimal, markupPercentage: BigDecimal): BigDecimal =
    (base * (1 + markupPercentage)).setScale(2, RoundingMode.HALF_EVEN)

  def getMarkUpAmount(base: BigDecimal, markupPercentage: BigDecimal): BigDecimal =
    (base * markupPercentage).setScale(2, RoundingMode.HALF_EVEN)

  def getBaseCostFromMarkedUpPrice(price: BigDecimal, markupPercentage: BigDecimal): BigDecimal =
      price / (1 + markupPercentage).setScale(2, RoundingMode.HALF_EVEN)

  def marginatePriceByPercentage(base: BigDecimal, marginPercentage: BigDecimal): BigDecimal =
    (base / (1 - marginPercentage)).setScale(2, RoundingMode.HALF_EVEN)

  def getMarginAmount(base: BigDecimal, marginPercentage: BigDecimal): BigDecimal =
    (base / (1 - marginPercentage) - base).setScale(2, RoundingMode.HALF_EVEN)

  def getBaseCostFromMarginatedPrice(price: BigDecimal, marginPercentage: BigDecimal): BigDecimal =
    (price * (1 - marginPercentage)).setScale(2, RoundingMode.HALF_EVEN)

}