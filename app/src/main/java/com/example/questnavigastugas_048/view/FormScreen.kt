package com.example.questnavigastugas_048.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormScreen(
    onKembaliClick: () -> Unit,
    onDialogDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    var nama by remember { mutableStateOf(value = "") }
    var jk by remember { mutableStateOf(value = "") }
    var status by remember { mutableStateOf(value = "") }
    var alamat by remember { mutableStateOf(value = "") }

    var namaError by remember { mutableStateOf<String?>(value = null) }
    var jkError by remember { mutableStateOf<String?>(value = null) }
    var statusError by remember { mutableStateOf<String?>(value = null) }
    var alamatError by remember { mutableStateOf<String?>(value = null) }

    var showSuccessDialog by remember { mutableStateOf(value = false) }

    val listJenisKelamin = listOf("Laki-Laki", "Perempuan")
    val listStatus = listOf("Lajang", "Kawin", "Cerai")

    var isJkDropdownExpanded by remember { mutableStateOf(value = false) }
    var isStatusDropdownExpanded by remember { mutableStateOf(value = false) }
}