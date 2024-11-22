package com.example.minggu8.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.minggu8.model.Mahasiswa
import com.example.minggu8.model.RencanaStudy


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

@Composable
fun CardSection(judulParam: String, isiParam: String) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = judulParam, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f)
            )
        }
    }
}

