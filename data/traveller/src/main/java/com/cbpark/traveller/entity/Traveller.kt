package com.cbpark.traveller.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.cbpark.travel.entity.Travel
import kotlinx.serialization.SerialName

@Entity(
  tableName = "traveller",
  foreignKeys = [ForeignKey(
    entity = Travel::class,
    parentColumns = ["id"],
    childColumns = ["travel_id"],
    onDelete = ForeignKey.CASCADE
  )]
)
data class Traveller(
  @PrimaryKey(autoGenerate = true) val id: Int = 0,
  @ColumnInfo(name = "travel_id") val travelId: Int,
  @SerialName("name") val name: String,
  @SerialName("budget") val budget: Double = 0.0
)