package com.emagineers.simplemoney

import scala.math.BigDecimal.RoundingMode

object InterestAlgebra {

  def compoundInterestRate(nominalInterestRatePerAnnum: BigDecimal,
                           compoundingPeriodsPerAnnum: Int = 12,
                           periods: Int = 1): BigDecimal = {

    val nominalInterestRatePerPeriod: BigDecimal = nominalInterestRatePerAnnum / compoundingPeriodsPerAnnum
    val apr = (1 + nominalInterestRatePerPeriod).pow(compoundingPeriodsPerAnnum * periods)
    apr.setScale(5, RoundingMode.HALF_EVEN) - 1
  }

  def totalAccruedAmount(principalAmount: BigDecimal,
                         nominalInterestRatePerAnnum: BigDecimal,
                         years: Int,
                         compoundingPeriodsPerAnnum: Int = 12
                        ): BigDecimal = {

    val compoundRate: BigDecimal = 1 + compoundInterestRate(nominalInterestRatePerAnnum, compoundingPeriodsPerAnnum, years)
    (principalAmount * compoundRate).setScale(5, RoundingMode.HALF_EVEN)
  }

  def interestAmount(principalAmount: BigDecimal,
                     nominalInterestRatePerAnnum: BigDecimal,
                     years: Int,
                     compoundingPeriodsPerAnnum: Int = 12
                        ): BigDecimal = {

    val compoundRate: BigDecimal = compoundInterestRate(nominalInterestRatePerAnnum, compoundingPeriodsPerAnnum, years)
    (principalAmount * compoundRate).setScale(5, RoundingMode.HALF_EVEN)
  }
}