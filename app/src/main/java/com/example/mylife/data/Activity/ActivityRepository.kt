package com.example.mylife.data.Activity

interface ActivityRepository{
    fun getActivity(name: String): Activity
}