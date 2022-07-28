package ch.migrosonline.poc.microfrontent.app.shell

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ch.migrosonline.poc.microfrontent.ui.theme.MicrofrontentTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import java.util.*

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AppShell()
}

@Composable
fun BottomNavBar() {

    val menuItems = listOf("Migros", "List", "Wallet", "subitoGo", "Profile")
    val (selectedMenuItem, setSelectedMenuItem) = remember { mutableStateOf(0) }

    NavigationBar {
        menuItems.forEachIndexed { index, menuItem ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(menuItem, softWrap = false) },
                selected = selectedMenuItem == index,
                onClick = { setSelectedMenuItem(index) },
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppShell() {
    MicrofrontentTheme {
        Box(
            modifier = Modifier.fillMaxSize().background(Color.Red)

        ) {
            Scaffold(
                bottomBar = { BottomNavBar() }
            ) {

            }
            Box(
                modifier = Modifier.size(56.dp).background(Color.Magenta)
            )

        }
    }
}