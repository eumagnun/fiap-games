package br.com.danielamaral.fiapgames.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import br.com.danielamaral.fiapgames.R
import br.com.danielamaral.fiapgames.model.Game
import java.text.NumberFormat
import java.util.*

class GameAdapter(contexto: Context) : ArrayAdapter<Game>(contexto, 0) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val v: View

        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }

        val item = getItem(position)

        val txt_game = v.findViewById<TextView>(R.id.txt_game)
        val txt_console = v.findViewById<TextView>(R.id.txt_console)
        val txt_nota = v.findViewById<TextView>(R.id.txt_nota)
        val img_item_foto = v.findViewById<ImageView>(R.id.img_item_foto)

        txt_console.text = item?.console.toString()
        txt_game.text = item?.nome

        val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))

        txt_nota.text = f.format(item?.nota)


        if (item?.foto != null) {
            img_item_foto.setImageBitmap(item.foto)
        }

        return v
    }
}