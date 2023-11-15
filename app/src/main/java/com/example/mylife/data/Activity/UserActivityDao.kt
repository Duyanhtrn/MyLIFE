package com.example.mylife.data.Activity

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserActivityDao {
    @Insert
    suspend fun addActivity(activity: Activity)

    @Delete
    suspend fun deleteActivity(activity: Activity)

    @Update
    suspend fun updateActivity(activity: Activity)

    @Query("SELECT * from user_activity WHERE activity_id = :id")
    fun getActivity(id: Int): Flow<UserActivity>
    @Query("SELECT * FROM user_activity WHERE DATE(user_activity.creationDate) = DATE('now')")
    fun getActivityForToday(): Flow<List<UserActivity>>
}