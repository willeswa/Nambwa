package app.monkpad.nambwa.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import app.monkpad.nambwa.framework.permissions.Permissions
import app.monkpad.nambwa.ui.viewmodel.MainViewModel
import com.example.compose.NambwaTheme
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NambwaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: MainViewModel = hiltViewModel()

                    SideEffect {
                        val hasPerms = viewModel.hasPermissions(Permissions.USAGE_STATS)
                        Timber.d("===>", hasPerms)
                    }

                    Text(text = "Hello World", style =  MaterialTheme.typography.bodyLarge)
                    Text(text = "Hello World", style =  MaterialTheme.typography.headlineLarge)
                }
            }
        }
    }
}

