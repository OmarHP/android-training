package com.example.android.androidoreo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notifications.*

class NotificationsActivity : AppCompatActivity() {

    private lateinit var mNotificationHelper: NotificationHelper

    companion object {
        private val TAG = "${MainActivity::class.java.simpleName}_TAG_"

        private val NOTIFICATION_FOLLOW = 1100
        private val NOTIFICATION_UNFOLLOW = 1101
        private val NOTIFICATION_DM_FRIEND = 1200
        private val NOTIFICATION_DM_COWORKER = 1201
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)
        mNotificationHelper = NotificationHelper(this)

        a_notif_follower_added.setOnClickListener({v -> sendNotification(NOTIFICATION_FOLLOW)})
        a_notif_follower_removed.setOnClickListener({v -> sendNotification(NOTIFICATION_UNFOLLOW)})
        a_notif_from_coworker.setOnClickListener({v -> sendNotification(NOTIFICATION_DM_COWORKER)})
        a_notif_from_friend.setOnClickListener({v -> sendNotification(NOTIFICATION_DM_FRIEND)})
    }

    fun sendNotification(id: Int){
        when(id){
            NOTIFICATION_FOLLOW -> mNotificationHelper.notify(id, mNotificationHelper.getNotificationFollower(
                    "Follower", "${mNotificationHelper.randomName} is now following you!"))

            NOTIFICATION_UNFOLLOW ->  mNotificationHelper.notify(id, mNotificationHelper.getNotificationFollower(
                    "Follower", "${mNotificationHelper.randomName} has stopped following you."))

            NOTIFICATION_DM_FRIEND ->  mNotificationHelper.notify(id, mNotificationHelper.getNotificationDM(
                    "Direct Message", "${mNotificationHelper.randomName}: What\'s up?"))

            NOTIFICATION_DM_COWORKER ->  mNotificationHelper.notify(id, mNotificationHelper.getNotificationDM(
                    "Direct Message", "${mNotificationHelper.randomName}: Have you finished the report?"))
        }
    }
}
