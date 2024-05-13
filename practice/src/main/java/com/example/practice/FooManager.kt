package com.example.practice

import android.content.Context
import android.util.Log
import dagger.hilt.EntryPoints

class FooManager {
    val TAG = FooManager::class.java.simpleName

    fun doSomething(context: Context) {
        val fooEntryPoint = EntryPoints.get(context, FooEntryPoint::class.java)
        val foo = fooEntryPoint.getFoo()
        Log.e(TAG, "foo = $foo")
    }
}