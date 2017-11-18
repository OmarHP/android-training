package com.example.android.androidoreo

import android.app.Service
import android.app.job.JobInfo
import android.app.job.JobParameters
import android.app.job.JobScheduler
import android.app.job.JobService
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyJobService : JobService() {

    override fun onStartJob(params: JobParameters): Boolean {
        doMyWork()
        Log.d(TAG, "onStartJob: doing something from job service")
        return true
    }

    override fun onStopJob(params: JobParameters): Boolean {
        // whether or not you would like JobScheduler to automatically retry your failed job.
        return false
    }

    private fun doMyWork() {
        // I am on the main thread, so if you need to do background work,
        // be sure to start up an AsyncTask, Thread, or IntentService!
    }

    companion object {

        private val TAG = MyJobService::class.java.simpleName + "_TAG_"

        private val JOB_ID = 1
        private val ONE_MIN = 20 * 1000

        fun schedule(context: Context) {
            val component = ComponentName(context, MyJobService::class.java)
            val builder = JobInfo.Builder(JOB_ID, component)
                    // schedule it to run any time between 1 - 5 minutes
                    .setMinimumLatency(ONE_MIN.toLong())
                    .setOverrideDeadline((3 * ONE_MIN).toLong())

            val jobScheduler = context.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
            jobScheduler.schedule(builder.build())
            Log.d(TAG, "schedule: MyJobService scheduled to start in one minute")
        }
    }
}
