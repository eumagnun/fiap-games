package br.com.danielamaral.fiapgames.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import br.com.danielamaral.fiapgames.adapter.GameAdapter
import br.com.danielamaral.fiapgames.R
import br.com.danielamaral.fiapgames.utils.produtosGlobal
import kotlinx.android.synthetic.main.activity_lista.*

class ListaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        val produtosAdapter = GameAdapter(this)

        list_view_produtos.adapter = produtosAdapter

        list_view_produtos.setOnItemLongClickListener() { adapterView: AdapterView<*>, view: View, position: Int, id: Long ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)
            produtosGlobal.remove(item)
            txt_total.text = sum()
            true
        }

        btn_adicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        val adapter = list_view_produtos.adapter as GameAdapter
        adapter.clear()
        adapter.addAll(produtosGlobal)

        txt_total.text = sum()
    }

    fun sum(): String {
        return "Quantidade:	${produtosGlobal.size}"
    }
}