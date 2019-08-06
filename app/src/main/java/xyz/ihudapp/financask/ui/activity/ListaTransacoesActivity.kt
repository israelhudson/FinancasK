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

        val transacoes = listOf(Transacao(
            tipo = Tipo.DESPESA, data = Calendar.getInstance(), valor = BigDecimal(20.5)),
            Transacao(valor = BigDecimal(100.0), tipo = Tipo.RECEITA,
                categoria = "Economia"))

        lista_transacoes_listview.setAdapter(ListaTransacoesAdapter(transacoes, this))
    }

}