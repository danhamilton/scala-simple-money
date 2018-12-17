package com.emagineers.simplemoney

import org.scalatest.{FlatSpec, Matchers}

import scala.math.BigDecimal.RoundingMode

class PricingAlgSpec extends FlatSpec with Matchers  {

  import PricingAlgebra._

  "markupPriceByPercentage" should "calculate price with markup correctly" in {
    val price = markupPriceByPercentage(BigDecimal(1000), BigDecimal(0.2))
    price shouldBe (BigDecimal(1200))
  }

  "getMarkUpAmount" should "calculate markup correctly" in {
    val markup = getMarkUpAmount(BigDecimal(1000), BigDecimal(0.2))
    markup shouldBe (BigDecimal(200))
  }

  "getBaseCostFromMarkedUpPrice" should "calculate base price correctly" in {
    val markup = getBaseCostFromMarkedUpPrice(BigDecimal(1200), BigDecimal(0.2))
    markup shouldBe (BigDecimal(1000))
  }

  "marginatePriceByPercentage" should "calculate price with margin correctly" in {
    val price = marginatePriceByPercentage(BigDecimal(1000), BigDecimal(0.2))
    price shouldBe (BigDecimal(1250))
  }

  "getMarginAmount" should "calculate margin correctly" in {
    val margin = getMarginAmount(BigDecimal(1000), BigDecimal(0.2))
    margin shouldBe (BigDecimal(250))
  }

  "getBaseCostFromMarginatedPrice" should "calculate base price correctly" in {
    val markup = getBaseCostFromMarginatedPrice(BigDecimal(1250), BigDecimal(0.2))
    markup shouldBe (BigDecimal(1000))
  }
}

