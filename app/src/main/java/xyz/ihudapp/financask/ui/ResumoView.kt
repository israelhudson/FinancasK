package xyz.ihudapp.financask.ui

import android.view.View
import kotlinx.android.synthetic.main.resumo_card.view.*
import xyz.ihudapp.financask.extension.formataParaBrasileiro
import xyz.ihudapp.financask.model.Resumo
import xyz.ihudapp.financask.model.Transacao

class ResumoView(private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        view.resumo_card_receita.text = totalReceita
            .formataParaBrasileiro()
    }

    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        view.resumo_card_despesa.text = totalDespesa
            .formataParaBrasileiro()
    }

    fun adicionaTotal(){
        val total = resumo.total()
        view.resumo_card_total.text = total
            .formataParaBrasileiro()
    }

}