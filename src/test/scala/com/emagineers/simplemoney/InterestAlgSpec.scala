package com.emagineers.simplemoney

import org.scalatest.{FlatSpec, Matchers}

class InterestAlgSpec extends FlatSpec with Matchers  {

  import InterestAlgebra._

  "compoundAnnualPercentageRate" should "calculate APR from 10% nominal rate correctly for monthly interest charging period" in {
    val compoundRate = compoundInterestRate(BigDecimal(0.1))
    compoundRate shouldBe (BigDecimal(0.10471))
  }

  it should "calculate APR from 0% nominal rate correctly" in {
    val compoundRate = compoundInterestRate(BigDecimal(0))
    compoundRate shouldBe (BigDecimal(0))
  }

  it should "calculate APR from 15% nominal rate correctly for daily interest charging period" in {
    val compoundRate = compoundInterestRate(BigDecimal(0.15), 365)
    compoundRate shouldBe (BigDecimal(0.1618))
  }

  "totalAccruedAmount" should "calculate total accrued for 10% nominal rate on £1000 with monthly interest rate charging for 1 year" in {
    val accruedAmount = totalAccruedAmount(BigDecimal(1000), BigDecimal(0.1), 1, 12)
    accruedAmount shouldBe BigDecimal(1104.71)
  }

  it should "calculate total accrued for 15% nominal rate on £1000 with daily interest rate charging for 5 year" in {
    val accruedAmount = totalAccruedAmount(BigDecimal(1000), BigDecimal(0.15), 5, 365)
    accruedAmount shouldBe BigDecimal(2116.67)
  }

  "interestAmount" should "calculate interest accrued for 10% nominal rate on £1000 with monthly interest rate charging for 1 year" in {
    val accruedAmount = interestAmount(BigDecimal(1000), BigDecimal(0.1), 1, 12)
    accruedAmount shouldBe BigDecimal(104.71)
  }

  it should "calculate interest accrued for 15% nominal rate on £1000 with daily interest rate charging for 5 year" in {
    val accruedAmount = interestAmount(BigDecimal(1000), BigDecimal(0.15), 5, 365)
    accruedAmount shouldBe BigDecimal(1116.67)
  }
}

