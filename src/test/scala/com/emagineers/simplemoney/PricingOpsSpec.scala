package com.emagineers.simplemoney

import org.scalatest.{FlatSpec, Matchers}

class PricingOpsSpec extends FlatSpec with Matchers  {

  import PricingOps._
  import MoneyOps._

  "addMarkup" should "markup money correctly" in {
    val markedUpMoney: Money = 1000.usd addMarkup(BigDecimal(0.2))
    markedUpMoney shouldBe 1200.usd
  }

  "getMarkup" should "get markup money correctly" in {
    val markUpMoney: Money = 1000.usd getMarkup(BigDecimal(0.2))
    markUpMoney shouldBe 200.usd
  }

  "getBaseCostFromMarkedUp" should "get base cost money from marked up money" in {
    val baseCostMoney: Money = 1200.usd getBaseCostFromMarkedUp(BigDecimal(0.2))
    baseCostMoney shouldBe 1000.usd
  }

  "margin money" should "marginate money correctly" in {
    val marginedMoney: Money = 1000.usd addMargin(BigDecimal(0.2))
    marginedMoney shouldBe 1250.usd
  }

  "get margin money" should "get margin money correctly" in {
    val marginMoney: Money = 1000.usd getMargin(BigDecimal(0.2))
    marginMoney shouldBe 250.usd
  }

  "getBaseCostFromMarginated" should "get base cost money from marginated money" in {
    val baseCostMoney: Money = 1250.usd getBaseCostFromMarginated(BigDecimal(0.2))
    baseCostMoney shouldBe 1000.usd
  }
}

