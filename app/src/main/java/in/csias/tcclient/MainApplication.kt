/*
 * Copyright 2016 - 2021 Anton Tananaev (anton@in.in)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package `in`.csias.tcclient

import androidx.multidex.MultiDexApplication
import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Notification
import android.graphics.Color
import android.os.Build
import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.messaging.FirebaseMessaging

open class MainApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        System.setProperty("http.keepAliveDuration", (30 * 60 * 1000).toString())
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerChannel()
        }
        val intentFilter = IntentFilter(MainFragment.EVENT_LOGIN)
        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                getString(R.string.notification_channel_id),
                getString(R.string.notification_channel),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)
        }
    }

    private val broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            FirebaseMessaging.getInstance().token.addOnCompleteListener {
                if (it.isSuccessful) {
                    broadcastToken(it.result)
                }
            }
        }
    }

    fun broadcastToken(token: String?) {
        val intent = Intent(MainFragment.EVENT_TOKEN)
        intent.putExtra(MainFragment.KEY_TOKEN, token)
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent)
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun registerChannel() {
        val channel = NotificationChannel(
            PRIMARY_CHANNEL, getString(R.string.channel_default), NotificationManager.IMPORTANCE_LOW
        )
        channel.lightColor = Color.GREEN
        channel.lockscreenVisibility = Notification.VISIBILITY_SECRET
        (getSystemService(NOTIFICATION_SERVICE) as NotificationManager).createNotificationChannel(channel)
    }

    open fun handleRatingFlow(activity: Activity) {}

    companion object {
        const val PRIMARY_CHANNEL = "default"
    }

}
