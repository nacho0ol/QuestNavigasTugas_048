package com.example.questnavigastugas_048.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigastugas_048.R
import com.example.questnavigastugas_048.data.DataSource

@Composable
fun ListPeserta(
    isLoading: Boolean,
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val listPeserta = DataSource.listPeserta
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(id = R.string.list_peserta),
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(height = 16.dp))

        if (isLoading) {
            CircularProgressIndicator()
        } else {
            listPeserta.forEach { peserta ->
                PesertaCard(peserta = peserta)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onBerandaClick) {
                Text(text = stringResource(id = R.string.beranda))
            }
            Button(onClick = onFormulirClick) {
                Text(text = stringResource(R.string.formulir))
            }
        }
    }
}