package com.example.mylife.data.Activity

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface UserActivityRepository {
    suspend fun addActivity(activity: Activity)
    suspend fun deleteActivity(activity: Activity)
    suspend fun updateActivity(activity: Activity)
    fun getActivity(id: Int): Flow<UserActivity>
    fun getActivityForToday(): Flow<List<UserActivity>>

}