package br.com.danielamaral.fiapgames

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.danielamaral.fiapgames.model.Game
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    private val requestCode = 1984
    private var imageBitMap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btn_inserir.setOnClickListener {
            val game = txt_game.text.toString()
            val console = txt_console.text.toString()
            val nota = txt_nota.text.toString()

            if (game.isNotEmpty() && console.isNotEmpty() && nota.isNotEmpty()) {
                val prod = Game(game, console, nota.toInt(), imageBitMap)

                produtosGlobal.add(prod)
                clearForm()
            } else {
                txt_game.error =
                    if (txt_game.text.isEmpty()) "Informe o nome do game" else null
                txt_console.error =
                    if (txt_console.text.isEmpty()) "Informe o console" else null
                txt_nota.error =
                    if (txt_nota.text.isEmpty()) "Informe a nota" else null
            }
        }

        img_foto.setOnClickListener {
            opengallery()
        }
    }

    private fun clearForm() {
        txt_game.text.clear()
        txt_console.text.clear()
        txt_nota.text.clear()
        img_foto.setImageResource(R.drawable.sem_foto)
        imageBitMap = null
    }

    private fun opengallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startActivityForResult(Intent.createChooser(intent, "Selecione	uma	imagem"), this.requestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == requestCode && resultCode == Activity.RESULT_OK) {

            if (data != null) {
                val inputStream = data.data?.let { contentResolver.openInputStream(it) }
                imageBitMap = BitmapFactory.decodeStream(inputStream)
                img_foto.setImageBitmap(imageBitMap)
            }
        }
    }

}