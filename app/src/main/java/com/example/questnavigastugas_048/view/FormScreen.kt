package com.example.questnavigastugas_048.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.questnavigastugas_048.R

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

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.form_pendaftaran), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = colorResource(id = R.color.teal_700)
                )
            )
        }
    ) {
        innerPadding ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.form_pendaftaran),
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = nama,
                onValueChange = { nama = it; namaError = null },
                label = { Text(stringResource(R.string.nama_lengkap)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = namaError != null,
                supportingText = {
                    val currentError = namaError
                    if (currentError != null) {
                        Text(text = currentError, color = MaterialTheme.colorScheme.error)
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = isJkDropdownExpanded,
                onExpandedChange = { isJkDropdownExpanded = it }
            ) {
                OutlinedTextField(
                    value = jk,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(R.string.jenis_kelamin)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isJkDropdownExpanded) },
                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                    isError = jkError != null
                )
                ExposedDropdownMenu(
                    expanded = isJkDropdownExpanded,
                    onDismissRequest = { isJkDropdownExpanded = false }
                ) {
                    listJenisKelamin.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                jk = item // Update state lokal
                                isJkDropdownExpanded = false
                            }
                        )
                    }
                }
            }
            val currentJkError = jkError
            if (currentJkError != null) {
                Text(text = currentJkError, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.labelSmall, modifier = Modifier.fillMaxWidth().padding(start = 16.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            ExposedDropdownMenuBox(
                expanded = isStatusDropdownExpanded,
                onExpandedChange = { isStatusDropdownExpanded = it }
            ) {
                OutlinedTextField(
                    value = status,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text(stringResource(R.string.status)) },
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isStatusDropdownExpanded) },
                    modifier = Modifier.fillMaxWidth().menuAnchor(),
                    isError = statusError != null
                )
                ExposedDropdownMenu(
                    expanded = isStatusDropdownExpanded,
                    onDismissRequest = { isStatusDropdownExpanded = false }
                ) {
                    listStatus.forEach { item ->
                        DropdownMenuItem(
                            text = { Text(item) },
                            onClick = {
                                status = item // Update state lokal
                                isStatusDropdownExpanded = false
                            }
                        )
                    }
                }
            }
            val currentSTError = statusError
            if (currentSTError != null) {
                Text(text = currentSTError, color = MaterialTheme.colorScheme.error, style = MaterialTheme.typography.labelSmall, modifier = Modifier.fillMaxWidth().padding(start = 16.dp))
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = alamat,
                onValueChange = { alamat = it; alamatError = null },
                label = { Text(stringResource(R.string.alamat)) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = alamatError != null,
                supportingText = {
                    val currentAlError = alamatError
                    if (currentAlError != null) {
                        Text(text = currentAlError, color = MaterialTheme.colorScheme.error)
                    }
                }
            )

        }

    }
}