package com.emagineers.simplemoney

import org.scalatest.{FlatSpec, Matchers}

class PricingOpsSpec extends FlatSpec with Matchers  {

  import PricingOps._
  import MoneyOps._

  "addMarkup" should "markup money correctly" in {
    val markedUpMoney: Money = BigDecimal(1000).usd.addMarkup(BigDecimal(0.2))
    markedUpMoney shouldBe Money(BigDecimal(1200), USD)
  }

  "getMarkup" should "get markup money correctly" in {
    val markUpMoney: Money = BigDecimal(1000).usd.getMarkup(BigDecimal(0.2))
    markUpMoney shouldBe Money(BigDecimal(200), USD)
  }

  "getBaseCostFromMarkedUp" should "get base cost money from marked up money" in {
    val baseCostMoney: Money = BigDecimal(1200).usd.getBaseCostFromMarkedUp(BigDecimal(0.2))
    baseCostMoney shouldBe Money(BigDecimal(1000), USD)
  }

  "margin money" should "marginate money correctly" in {
    val marginedMoney: Money = BigDecimal(1000).usd.addMargin(BigDecimal(0.2))
    marginedMoney shouldBe Money(BigDecimal(1250), USD)
  }

  "get margin money" should "get margin money correctly" in {
    val marginMoney: Money = BigDecimal(1000).usd.getMargin(BigDecimal(0.2))
    marginMoney shouldBe Money(BigDecimal(250), USD)
  }

  "getBaseCostFromMarginated" should "get base cost money from marginated money" in {
    val baseCostMoney: Money = BigDecimal(1250).usd.getBaseCostFromMarginated(BigDecimal(0.2))
    baseCostMoney shouldBe Money(BigDecimal(1000), USD)
  }
}

