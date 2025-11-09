package com.example.questnavigastugas_048.data

import android.R

data class Peserta(
    val nama: String,
    val gender: String,
    val status: String,
    val alamat: String
)

object DataSource {
    val listPeserta = listOf(
        Peserta(
            nama = "Kairi Kumar",
            gender = "Laki-laki",
            status = "Cerai",
            alamat = "jl pegangsaan timur"
        ),
        Peserta(
            nama = "badut petrik",
            gender = "Perempuan",
            status = "Lajang",
            alamat = "sleman"
        ),
        Peserta(
            nama = "pitekantropus",
            gender = "laki-laki",
            status = "Kawin",
            alamat = "sangiran"
        ),
        Peserta(
            nama = "imroatus",
            gender = "Laki-laki",
            status = "Lajang",
            alamat = "parkiran UB"
        ),
        Peserta(
            nama = "sabo",
            gender = "Perempuan",
            status = "Lajang",
            alamat = "jl asbunawan"
        ),
        Peserta(
            nama = "umi rosdiah",
            gender = "Perempuan",
            status = "Kawin",
            alamat = "pochinki"
        )
    )
}