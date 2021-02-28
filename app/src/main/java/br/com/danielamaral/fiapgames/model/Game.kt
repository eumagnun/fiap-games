package br.com.danielamaral.fiapgames.model

import android.graphics.Bitmap

data class Game(
    val nome: String,
    val console: String,
    val nota: Int,
    val foto: Bitmap? = null
)
