package com.cbpark.travel.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.cbpark.travel.converter.LocalDateConverter
import kotlinx.serialization.SerialName
import java.time.LocalDate

@Entity(tableName = "travel")
@TypeConverters(LocalDateConverter::class)
data class Travel(
  @PrimaryKey
  @SerialName("id")
  val id: Int = -1,

  @ColumnInfo
  @SerialName("country_code")
  val countryCode: String = CountryCode.USA.code,

  @ColumnInfo
  @SerialName("name")
  val name: String = "Default Travel",

  @ColumnInfo
  @SerialName("currency")
  val currency: String = CountryCode.USA.currency,

  @ColumnInfo
  @SerialName("start_date")
  val startDate: LocalDate = LocalDate.now(),

  @ColumnInfo
  @SerialName("end_data")
  val endDate: LocalDate = LocalDate.now(),
)