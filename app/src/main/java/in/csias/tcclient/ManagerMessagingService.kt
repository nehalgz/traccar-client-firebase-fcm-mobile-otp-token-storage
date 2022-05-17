package `in`.csias.tcclient

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class ManagerMessagingService : FirebaseMessagingService() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        val notificationIntent = Intent(Intent.ACTION_VIEW, Uri.parse(remoteMessage.data.get("url")))
        val pendingFlags = PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE
        val notificationIntentClear = Intent(applicationContext, MainActivity::class.java)
        notificationIntent.putExtra("fromNotification", true)
        notificationIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        val contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, pendingFlags)
        val pendingIntent =
                PendingIntent.getActivity(this, 0,notificationIntentClear,PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_MUTABLE)
        val builder = NotificationCompat.Builder(this, getString(R.string.notification_channel_id))
                .setSmallIcon(R.drawable.ic_stat_notify)
                .setContentTitle(getString(R.string.app_name))
                .setStyle(NotificationCompat.BigTextStyle()
                        .bigText(remoteMessage.notification?.body))
                .setContentText(remoteMessage.notification?.body)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.ic_baseline_check_24,"Yes", contentIntent)
                .addAction(R.drawable.ic_baseline_delete_24,"No",pendingIntent);
        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).notify(remoteMessage.hashCode(), builder.build())
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        (application as MainApplication).broadcastToken(token)
    }
}