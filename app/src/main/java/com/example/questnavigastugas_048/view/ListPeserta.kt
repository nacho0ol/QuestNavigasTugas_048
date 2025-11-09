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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.questnavigastugas_048.data.Peserta

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

@Composable
fun PesertaCard(peserta: Peserta, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InfoKolom(title = stringResource(R.string.nama_lengkap), value = peserta.nama)
                InfoKolom(title = stringResource(R.string.jenis_kelamin), value = peserta.gender)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                InfoKolom(title = stringResource(R.string.status), value = peserta.status)
                InfoKolom(title = stringResource(R.string.alamat), value = peserta.alamat)
            }
        }
    }
}

@Composable
fun InfoKolom(title: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.labelSmall)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}