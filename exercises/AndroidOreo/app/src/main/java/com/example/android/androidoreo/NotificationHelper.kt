package com.example.android.androidoreo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.Color
import android.support.v4.app.TaskStackBuilder
import java.util.*

/**
 * Created by Aptivist-U001 on 11/9/2017.
 */
internal class NotificationHelper (context: Context) : ContextWrapper(context) {

    companion object {
        val followerChannel = "follower"
        val dmChannel = "direct_message"
    }

    private val mNotificationManager:NotificationManager by lazy{
        getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    init{
        // Submit the notification chanel object to the notification manager
        val followerChannel = buildChannel(followerChannel, "Followe Notification Channel", Color.GREEN)
        val dmChannel = buildChannel(dmChannel, "DM Notification Channel", Color.BLUE)
        mNotificationManager.createNotificationChannel(followerChannel)
        mNotificationManager.createNotificationChannel(dmChannel)

    }

    /**
     *  Build a notification channel
     */
    fun buildChannel(id: String, name: String, color: Int): NotificationChannel{

        // Create the channel object with the unique ID
        val channel = NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT)

        // Configure the channels's initial settings
        channel.lightColor = Color.GREEN
        channel.vibrationPattern = longArrayOf(100, 200, 300, 400, 500, 400, 500, 200, 500)

        return channel
    }

    /**
     * Get a follow/un-follow notification
     */
    fun getNotificationFollower(title: String, body: String): Notification.Builder {
        return Notification.Builder(applicationContext, followerChannel)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(smallIcon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
    }

    /**
     * Get a direct message notification
     */
    fun getNotificationDM(title: String, body: String): Notification.Builder {
        return Notification.Builder(applicationContext, dmChannel)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(smallIcon)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
    }

    private val pendingIntent: PendingIntent
        get() {
            val openMainIntent = Intent(this, NotificationsActivity::class.java)
            val stackBuilder = TaskStackBuilder.create(this)
            .addParentStack(MainActivity::class.java)
            .addNextIntent(openMainIntent)
            return stackBuilder.getPendingIntent(0, PendingIntent.FLAG_ONE_SHOT)
        }

    fun notify(id: Int, notification: Notification.Builder) {
        mNotificationManager.notify(id, notification.build())
    }

    private val smallIcon: Int
        get() = android.R.drawable.stat_notify_chat

    val randomName: String
        get() {
            var names = Arrays.asList("Omar", "Edwin", "Pepe", "Isaias", "Alfredo")
            return names[Random().nextInt(names.size)]
        }

}