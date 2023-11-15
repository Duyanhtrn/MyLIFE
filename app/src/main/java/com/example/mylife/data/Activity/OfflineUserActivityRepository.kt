package com.example.mylife.data.Activity

import kotlinx.coroutines.flow.Flow

class OfflineUserActivityRepository(private var userActivityDao: UserActivityDao): UserActivityRepository {
    override suspend fun addActivity(activity: Activity) = userActivityDao.addActivity(activity)
    override suspend fun deleteActivity(activity: Activity) = userActivityDao.deleteActivity(activity)
    override fun getActivity(id: Int): Flow<UserActivity> = userActivityDao.getActivity(id)
    override suspend fun updateActivity(activity: Activity) = userActivityDao.updateActivity(activity)
    override fun getActivityForToday(): Flow<List<UserActivity>> = userActivityDao.getActivityForToday()
}