package com.emagineers.simplemoney

import org.scalatest.{FlatSpec, Matchers}

import scala.math.BigDecimal.RoundingMode

class MoneyAlgSpec extends FlatSpec with Matchers  {

  import MoneyAlgebra._


  "Money Alg" should "add 2 simple Money correctly" in {

    val money1 = Money(20)
    val money2 = Money(10.44)

    val summed: Option[Money] = money1 + money2

    summed should contain(Money(30.44, GBP))
  }

   it should "add 2 decimal Money correctly" in {

    val money1 = Money(20.5555, GBP, RoundingMode.HALF_EVEN, 4)
    val money2 = Money(10.4444)

    val summed: Option[Money] = money1 + money2

    summed should contain(Money(30.9999, GBP, RoundingMode.HALF_EVEN, 4))
  }

  it should "return None when attempting to add different currencies" in {
    val money1 = Money(20.55555, GBP)
    val money2 = Money(10.4444, USD)

    (money1 + money2) shouldBe None
  }

  it should "subtract 2 Money correctly" in {

    val money1 = Money(20.55555)
    val money2 = Money(10.4444)

    val summed: Option[Money] = money1 - money2

    summed should contain(Money(10.11, GBP))
  }

  it should "return None when attempting to subtract different currencies" in {
    val money1 = Money(20.55555, GBP)
    val money2 = Money(10.4444, USD)

    (money1 - money2) shouldBe None
  }

  it should "multiply int Money correctly" in {
    val money1 = Money(20)

    val summed: Option[Money] = money1 * 5

    summed should contain(Money(100, GBP))
    summed.get.value shouldBe(100)
  }

  it should "multiply decimal Money correctly" in {
    val money1 = Money(20.55555)

    val summed: Option[Money] = money1 * 3.142

    summed should contain(Money(64.59, GBP))
  }

  it should "divide int Money correctly" in {
    val money1 = Money(10)

    val summed: Option[Money] = money1 / 2

    summed should contain(Money(5, GBP))
    summed.get.value shouldBe(5)
  }

  it should "divide decimal Money correctly" in {
    val money1 = Money(10)

    val summed: Option[Money] = money1 / 3

    summed should contain(Money(3.33, GBP))
  }

  it should "handle attempted divide by 0 gracefully" in {
    val money1 = Money(10)

    val summed: Option[Money] = money1 / 0

    summed shouldBe None

  }
}

