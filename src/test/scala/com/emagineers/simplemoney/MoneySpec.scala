package com.emagineers.simplemoney

import org.scalatest.FlatSpec
import scala.math.BigDecimal.RoundingMode

class MoneySpec extends FlatSpec {

  import MoneyOps._

  "Money" should "create with defaults" in {

    val actualMoney = Money(20.50)
    val expectedMoney = Money(BigDecimal(20.50), GBP, RoundingMode.HALF_EVEN, 2)

    assert(actualMoney == expectedMoney)
  }

  it should "round value correctly for defaults" in {
    assert(Money(20.554).value == BigDecimal(20.55))
    assert(Money(20.555).value == BigDecimal(20.56))
  }


  "Money Ops" should "create correct money from Big Int for GBP and USD" in {

    val expectedGBP = Money(10, GBP)
    val expectedUSD = Money(20, USD)

    val actualGBP = BigDecimal(10).gbp
    val actualUSD = BigDecimal(20).usd

    assert(actualGBP == expectedGBP)
    assert(actualUSD == expectedUSD)
  }

  it should "create correct money from asCurrency" in {

    val expectedEur = Money(30, EUR)

    val actualEur = BigDecimal(30).asCurrency(EUR)
    assert(actualEur == expectedEur)
  }

  it should "allow creation of new currency and create money with it" in {

    trait FUN extends Currency

    case object FUN extends FUN {
      def symbol: String = "F"
      def name: String = "Funny Money"
      def code: String = "FUN"
    }

    val expectedFun = Money(40, FUN)
    val actualFun = BigDecimal(40).asCurrency(FUN)

    assert(actualFun == expectedFun)
  }
}

