package com.example.practice

import java.util.UUID

class MyName {

    private val uuid : UUID = UUID.randomUUID()
    override fun toString(): String {
        return uuid.toString()
    }
}