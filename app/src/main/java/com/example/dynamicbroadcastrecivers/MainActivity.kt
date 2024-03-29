package com.example.dynamicbroadcastrecivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val psr=PowerStateReceiver()
        val iFilter= IntentFilter().apply{
            addAction(Intent.ACTION_POWER_DISCONNECTED)
            addAction(Intent.ACTION_POWER_CONNECTED)
        }
        registerReceiver(psr,iFilter)
        //BroadCast to know if Charger Connected or not Connected
    }

    inner class PowerStateReceiver:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

            if (intent != null) {
                if(intent.action==Intent.ACTION_POWER_CONNECTED){
                    Toast.makeText(this@MainActivity,"CHARGER CONNECTED",Toast.LENGTH_SHORT
                    ).show()

                }
            }

            if (intent != null) {
                if(intent.action==Intent.ACTION_POWER_DISCONNECTED){
                    Toast.makeText(this@MainActivity,"CHARGER DISCONNECED",Toast.LENGTH_SHORT
                    ).show()

                }
            }



        }
    }
}