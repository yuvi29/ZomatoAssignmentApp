package com.yuvi.assingmentapp.service

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService


internal class ZomatoIntentSerive : JobIntentService() {

    private val TAG = "ServiceExample"
    private var mAlarmManager : AlarmManager? = null
    val JOB_ID = 1000


    companion object {
        const val ID = 100

        //method for enqueuing work to this service, just call from client to start
        fun enqueueWork(context : Context, work : Intent) {
            enqueueWork(context, ZomatoIntentSerive::class.java, ID, work)
        }
    }




//    override fun onHandleWork(arg0: Intent?) {
//        Log.i(TAG, "Intent Service started")
//
//        if(arg0 != null)
//        {
//            var extra : String = arg0.getStringExtra("data").toString()
//            Log.e("ZomatoIntentSerive",extra)
//
//
//
//            val mIntent = Intent(this, MyReceiver::class.java)
//
//            val mPendingIntent = PendingIntent.getBroadcast(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT)
//            mAlarmManager = this
//                .getSystemService(Context.ALARM_SERVICE) as AlarmManager
//            mAlarmManager!!.setRepeating(
//                AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
//                6000, mPendingIntent
//            )
//
//        }
//
//
//    }

    override fun onHandleWork(intent: Intent) {
        if(intent != null)
        {
            var extra : String = intent.getStringExtra("data").toString()
            Log.e("ZomatoIntentSerive",extra)



            val mIntent = Intent(this, MyReceiver::class.java)

            val mPendingIntent = PendingIntent.getBroadcast(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT)
            mAlarmManager = this
                .getSystemService(Context.ALARM_SERVICE) as AlarmManager
            mAlarmManager!!.setRepeating(
                AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                6000, mPendingIntent
            )

        }
    }
}