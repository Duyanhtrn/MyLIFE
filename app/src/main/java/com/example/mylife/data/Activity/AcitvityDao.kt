package com.example.mylife.data.Activity

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ActivityDao {
    @Query("SELECT * FROM activity WHERE activity_name = :name")
    fun getActivity(name: String): Activity
}