package com.example.questnavigastugas_048.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    onKembaliClick: () -> Unit,
    onDialogDismiss: () -> Unit,
    modifier: Modifier = Modifier
)