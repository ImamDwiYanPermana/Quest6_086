package com.example.minggu8.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.minggu8.ui.screen.MahasiswaFormView
import com.example.minggu8.ui.screen.RencanaStudyView
import com.example.minggu8.ui.screen.SplashView
import com.example.minggu8.ui.screen.Tampil
import com.example.minggu8.ui.viewModel.MahasiswaViewModel
import com.example.minggu8.ui.viewModel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    krsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
    ) {
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                modifier = Modifier.fillMaxSize(),
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMahasiswa(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBacButtonClicked =  {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonCliked = {
                    krsViewModel.saveDataKRS(it)
                    navController.navigate(Halaman.Tampil.name)
                },
              onBackButtonCliked   = { navController.popBackStack() }
            )
        }
        composable(route = Halaman.Tampil.name) {
            Tampil(
                uiStateMahasiswa = mahasiswaUiState,
                uiMahasiswa = krsViewModel.krsStateUi.collectAsState().value,
                onClickButton = {
                    navController.navigate(Halaman.Splash.name)
                }
            )
        }
    }
}


