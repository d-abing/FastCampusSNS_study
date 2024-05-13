package com.example.practice

import android.app.Activity
import android.app.Dialog
import android.os.Bundle
import android.widget.TextView
import dagger.hilt.EntryPoints
import javax.inject.Inject

class MyDialog @Inject constructor(
    private val context: Activity,
    private val dialogComponentManager: DialogComponentManager
) : Dialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val entryPoint = EntryPoints.get(dialogComponentManager, DialogEntryPoint::class.java)
        val user = entryPoint.getUser()
        val number1 = entryPoint.getRandomNumber()
        val number2 = entryPoint.getRandomNumber()
        val number3 = entryPoint.getRandomNumber()
        val localDateTime = entryPoint.getLocalDateTime()
        setContentView(TextView(context).apply {
            text = "${user.name}\n" +
                    "${number1}\n" +
                    "${number2}\n" +
                    "${number3}\n" +
                    "${localDateTime}"
        })
    }
}