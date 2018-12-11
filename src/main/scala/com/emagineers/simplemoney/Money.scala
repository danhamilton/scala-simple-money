package com.emagineers.simplemoney

import scala.math.BigDecimal.RoundingMode
import scala.math.BigDecimal.RoundingMode.RoundingMode

case class Money(rawAmount: BigDecimal,
                 currency: Currency = GBP,
                 roundingMode: RoundingMode = RoundingMode.HALF_EVEN,
                 roundingScale: Int = 2
                ) {

  def value: BigDecimal = rawAmount.setScale(roundingScale, roundingMode)
}