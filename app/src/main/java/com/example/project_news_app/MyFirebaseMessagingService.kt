package com.example.project_news_app

import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)

        val title = remoteMessage.notification?.title ?: "ข่าวสำคัญ"
        val message = remoteMessage.notification?.body ?: "เนื้อหาใหม่"
        showNotification(title, message)
    }

    private fun showNotification(title: String, message: String) {
        val channelId = "important_news_channel"
        val intent = Intent(this, NewsDetailsActivity::class.java).apply {
            putExtra("news_title", title)
            putExtra("news_content", message)
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)

        val builder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.images)  // Replace with your app icon
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        try {
            with(NotificationManagerCompat.from(this)) {
                notify(1001, builder.build())
            }
        } catch (e: SecurityException) {
            e.printStackTrace() // จัดการ error ที่อาจเกิดขึ้น
        }
    }
}