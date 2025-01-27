package com.cbpark.travel.converter

import androidx.room.TypeConverter
import java.time.LocalDate

class LocalDateConverter {
  @TypeConverter
  fun fromLocalDate(date: LocalDate): String
      = date.toString()

  @TypeConverter
  fun toLocalDate(dateString: String): LocalDate
      = LocalDate.parse(dateString)
}