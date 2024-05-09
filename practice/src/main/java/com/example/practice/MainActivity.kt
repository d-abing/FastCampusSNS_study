package com.example.practice

import android.os.Bundle
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
import dagger.Lazy
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import javax.inject.Provider

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val TAG: String = MainActivity::class.java.simpleName

    @Inject
    lateinit var providerFoo1: Provider<Foo>

    @Inject
    lateinit var providerFoo2: Lazy<Foo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val foo1: Foo = providerFoo1.get()
        val foo2: Foo = providerFoo2.get()

        assert(foo1 !== foo2)

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