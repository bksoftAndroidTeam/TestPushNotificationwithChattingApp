package com.example.singhkshitiz.letschat.Notification

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import org.json.JSONObject

class FcmListenerService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        Log.w("onMessageReceived", "Message Received from " + remoteMessage.from)


//        PNExtension.getMessageFromJson(JSONObject(remoteMessage.data["message"]), object : CometChat.CallbackListener<BaseMessage>(){
//            override fun onSuccess(baseMessage: BaseMessage?) {
//                when(baseMessage)
//                {
//                    is TextMessage -> {
//                        // Convert BaseMessage to TextMessage
//                        var textMessage = baseMessage
//
//                        // Send notification for this text message here
//
//                    }
//                }
//            }
//
//            override fun onError(exception: CometChatException?) {
//                exception?.printStackTrace()
//            }
//        })
    }
    override fun onNewToken(token: String) {
        super.onNewToken(token)
    }

}
