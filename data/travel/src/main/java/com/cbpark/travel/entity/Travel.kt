package com.cbpark.travel.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cbpark.travel.converter.LocalDateConverter
import kotlinx.serialization.SerialName
import java.time.LocalDate

@Entity(tableName = "travel")
@TypeConverters(LocalDateConverter::class)
data class Travel(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,

  @SerialName("country_code") val countryCode: String = CountryCode.USA.code,

  @SerialName("name") val name: String = "Default Travel",

  @SerialName("currency") val currency: String = CountryCode.USA.currency,

  @SerialName("start_date") val startDate: LocalDate = LocalDate.now(),

  @SerialName("end_data") val endDate: LocalDate = LocalDate.now(),
)