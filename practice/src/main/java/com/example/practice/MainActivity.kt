package com.example.practice

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practice.ui.theme.FastCampusSNSTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val TAG: String = MainActivity::class.java.simpleName

    lateinit var foo: Foo

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        assert(this::foo.isInitialized) // assert() : throws an AssertionError if the value is false
        setContent {
            FastCampusSNSTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(name = "Dabin")
                }
            }
        }
    }
    @Inject
    fun injectFoo(foo: Foo){
        Log.e(TAG, "injectFoo : ${foo.toString()}")
        this.foo = foo
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FastCampusSNSTheme {
        Greeting("Android")
    }
}