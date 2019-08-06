package xyz.ihudapp.financask.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import xyz.ihudapp.financask.R
import xyz.ihudapp.financask.model.Tipo
import xyz.ihudapp.financask.model.Transacao
import xyz.ihudapp.financask.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes = listOf(Transacao(BigDecimal(20.5),
            "Comida", Tipo.DESPESA),
            Transacao(BigDecimal(100.0),
                "Economia", Tipo.RECEITA,
                Calendar.getInstance()))

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes, this))
    }

}