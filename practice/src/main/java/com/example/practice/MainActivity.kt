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
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val TAG: String = MainActivity::class.java.simpleName

    lateinit var foo: Foo

    @UserQualifier(50, 180)
    @Inject
    lateinit var charles: User

    @UserQualifier(10, 120)
    @Inject
    lateinit var john: User

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Log.e(TAG, "1) ${charles.name}")
        Log.e(TAG, "2) ${john.name}")

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
    fun injectFoo(
        @Named("foo 1") foo: Foo
    ){
        Log.e(TAG, "injected Foo's id : ${foo.id}")
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