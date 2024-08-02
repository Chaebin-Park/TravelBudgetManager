package com.cbpark.travel.entity


enum class CountryCode(val code: String, val currency: String) {
  USA(code = "\uD83C\uDDFA\uD83C\uDDF8", currency = "USD"),
  Japan(code = "\uD83C\uDDEF\uD83C\uDDF5", currency = "JPY"),
  Mongolia(code = "\uD83C\uDDF2\uD83C\uDDF3", currency = "MNT"),
  Vietnam(code = "\uD83C\uDDFB\uD83C\uDDF3", currency = "VND");
  companion object {
    fun find(code: String): CountryCode =
      entries.firstOrNull { it.code == code } ?: USA
  }
}