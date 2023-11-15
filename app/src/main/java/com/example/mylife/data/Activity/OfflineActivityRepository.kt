package com.example.mylife.data.Activity

class OfflineActivityRepository(private var activityDao: ActivityDao): ActivityRepository{
    override fun getActivity(name: String): Activity = activityDao.getActivity(name)
}