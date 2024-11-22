package com.example.minggu8.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.minggu8.model.Mahasiswa
import com.example.minggu8.model.RencanaStudy

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonCliked: (MutableList<String>) -> Unit,
    onBackButtonCliked: () -> Unit
){
    var choosenDropdown by remember {
        mutableStateOf("")
    }

    var  checked by remember {
        mutableStateOf("")
    }

    var pilihanKelas by remember {
        mutableStateOf("")
        }

}