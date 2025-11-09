package com.example.questnavigastugas_048.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
    }
}