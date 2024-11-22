package com.example.minggu8.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minggu8.model.Mahasiswa
import com.example.minggu8.model.RencanaStudy
import java.lang.reflect.Modifier

@Composable
fun Tampil(
    modifie: Modifier = Modifier,
    uiStateMahasiswa: Mahasiswa,
    uiMahasiswa: RencanaStudy,
    onClickButton: () -> Unit
)
{
    val listDataMhs = listOf(
        Pair("NIM", uiStateMahasiswa.nim),
        Pair("Nama", uiStateMahasiswa.nama),
        Pair("Mata Kuliah", uiMahasiswa.mataKuliah),
        Pair("Kelas", uiMahasiswa.kelas),
        Pair("Email", uiStateMahasiswa.email),
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier.padding(16.dp))

        Text("Tampilan Data",
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold)

        Spacer(Modifier.padding(16.dp))

        listDataMhs.forEach{ items ->
            CardSection(
                judulParam = items.first,
                isiParam = items.second
            )
        }

        Spacer(Modifier.padding(16.dp))

        Button(onClick = {onClickButton()}) {
            Text(text = "Halaman Utama")
        }
    }
}

