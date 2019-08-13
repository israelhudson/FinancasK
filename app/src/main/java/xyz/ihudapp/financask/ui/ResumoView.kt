package xyz.ihudapp.financask.ui

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import kotlinx.android.synthetic.main.resumo_card.view.*
import xyz.ihudapp.financask.R
import xyz.ihudapp.financask.extension.formataParaBrasileiro
import xyz.ihudapp.financask.model.Resumo
import xyz.ihudapp.financask.model.Transacao
import java.math.BigDecimal

class ResumoView(private val context: Context,
                 private val view: View,
                 transacoes: List<Transacao>) {

    private val resumo: Resumo = Resumo(transacoes)

    fun adicionaReceita() {
        val totalReceita = resumo.receita()
        view.resumo_card_receita.setTextColor(ContextCompat.getColor(context, R.color.receita))
        view.resumo_card_receita.text = totalReceita
            .formataParaBrasileiro()
    }

    fun adicionaDespesa() {
        val totalDespesa = resumo.despesa()
        view.resumo_card_despesa.setTextColor(ContextCompat.getColor(context, R.color.despesa))
        view.resumo_card_despesa.text = totalDespesa
            .formataParaBrasileiro()
    }

    fun adicionaTotal(){
        val total = resumo.total()
        if(total.compareTo(BigDecimal.ZERO) >= 0){
            view.resumo_card_total.setTextColor(ContextCompat.getColor(context, R.color.receita))
        }else{
            view.resumo_card_total.setTextColor(ContextCompat.getColor(context, R.color.despesa))
        }

        view.resumo_card_total.text = total
            .formataParaBrasileiro()
    }

}