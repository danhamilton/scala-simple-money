package com.emagineers.simplemoney

trait Currency extends Product with Serializable {
  def symbol: String
  def name: String
  // ISO_4217
  def code: String
}

trait GBP extends Currency

case object GBP extends GBP {
  def symbol: String = "£"
  def name: String = "Pound Sterling"
  def code: String = "GBP"
}

trait USD extends Currency

case object USD extends USD {
  def symbol: String = "$"
  def name: String = "United States Dollar"
  def code: String = "USD"
}

trait EUR extends Currency

case object EUR extends EUR {
  def symbol: String = "€"
  def name: String = "European Euro"
  def code: String = "EUR"
}

