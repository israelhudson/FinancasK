package xyz.ihudapp.financask.ui

import android.view.View
import kotlinx.android.synthetic.main.resumo_card.view.*
import xyz.ihudapp.financask.extension.formataParaBrasileiro
import xyz.ihudapp.financask.model.Tipo
import xyz.ihudapp.financask.model.Transacao
import java.math.BigDecimal

class ResumoView(private val view: View,
                 private val transacoes: List<Transacao>) {

    fun adicionaReceita() {
        var totalReceita = BigDecimal.ZERO
        for (transacao in transacoes) {
            if (transacao.tipo == Tipo.RECEITA) {
                totalReceita = totalReceita.plus(transacao.valor)
            }
        }
        
        view.resumo_card_receita.text = totalReceita.formataParaBrasileiro()
    }

    fun adicionaDespesa() {
        var totalDespesa = BigDecimal.ZERO
        for (transacao in transacoes){
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }

        view.resumo_card_despesa.text = totalDespesa.formataParaBrasileiro()
    }

}