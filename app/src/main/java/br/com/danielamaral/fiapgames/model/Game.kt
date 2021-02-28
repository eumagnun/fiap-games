package br.com.danielamaral.fiapgames.model

import android.graphics.Bitmap

data class Game(
    var nome: String,
    var console: String,
    var nota: Int,
    var foto: Bitmap? = null
)
