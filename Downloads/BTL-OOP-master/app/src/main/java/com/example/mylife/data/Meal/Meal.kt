package com.example.mylife.data.Meal

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Locale


@Entity(tableName = "meal")
data class Meal(
    @PrimaryKey
    val meal_id: Int,
    val meal_calories: Int,
    val meal_protein: Int,
    val meal_carb: Int,
    val meal_fat: Int,
    @TypeConverters(Converters::class)
    val creationDate: String?

)
class Converters {
    @TypeConverter
    fun toDate(dateString: String?): Date? {
        return dateString?.let { SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(it) }
    }
    @TypeConverter
    fun toString(date: Date?): String? {
        return date?.let { SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(it) }
    }
}


