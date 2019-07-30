package xyz.ihudapp.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import xyz.ihudapp.financask.R

class ListaTransacoesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf("Comida - R$ 20,50",
            "Economia - R$ 100,00")

        val arrayAdapter = ArrayAdapter(
            this, android.R.layout.simple_list_item_1,
            transacoes)

        lista_transacoes_listview.setAdapter(arrayAdapter)
    }

}