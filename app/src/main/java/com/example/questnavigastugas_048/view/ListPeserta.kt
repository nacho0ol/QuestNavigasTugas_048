package com.example.questnavigastugas_048.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.questnavigastugas_048.data.DataSource

@Composable
fun ListPeserta(
    isLoading: Boolean,
    onBerandaClick: () -> Unit,
    onFormulirClick: () -> Unit,
    modifier: Modifier = Modifier
){
    val listPeserta = DataSource.listPeserta
}