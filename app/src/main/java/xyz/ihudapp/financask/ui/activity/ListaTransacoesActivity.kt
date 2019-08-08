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

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraLista(transacoes)
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo() : List<Transacao> {
        return listOf(
            Transacao(
                categoria = "Almoço de final de semana",
                tipo = Tipo.DESPESA, data = Calendar.getInstance(), valor = BigDecimal(20.5)
            ),
            Transacao(
                valor = BigDecimal(100.0), tipo = Tipo.RECEITA,
                categoria = "Economia"
            ),
            Transacao(
                valor = BigDecimal(200.0), tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(500.0),
                categoria = "Prêmio",
                tipo = Tipo.RECEITA
            )
        )
    }

}