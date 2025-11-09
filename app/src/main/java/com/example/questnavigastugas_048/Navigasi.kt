package com.example.questnavigastugas_048

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.questnavigastugas_048.view.dashboard
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.questnavigastugas_048.view.ListPeserta
import com.example.questnavigastugas_048.view.FormScreen

enum class Navigasi { Welcome, List, Formulir }

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    var isLoading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    NavHost(
        navController = navController,
        startDestination = Navigasi.Welcome.name,
    ) {
        composable(route = Navigasi.Welcome.name) {
            dashboard(
                onMasukClick = {
                    scope.launch {
                        isLoading = true
                        delay(2000L)
                        isLoading = false
                        navController.navigate(route = Navigasi.List.name)
                    }
                }
            )
        }

        composable(route = Navigasi.List.name) {
            ListPeserta(
                isLoading = isLoading,
                onBerandaClick = {
                    navController.popBackStack(Navigasi.Welcome.name, inclusive = false)
                },
                onFormulirClick = {
                    navController.navigate(Navigasi.Formulir.name)
                }
            )
        }

        composable(route = Navigasi.Formulir.name) {
            FormScreen(
                onKembaliClick = {
                    navController.popBackStack()
                },
                onDialogDismiss = {
                    navController.popBackStack()
                }
            )
        }
    }
}