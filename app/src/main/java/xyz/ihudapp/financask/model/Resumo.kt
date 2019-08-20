package xyz.ihudapp.financask.model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    fun receita(): BigDecimal{
        val somaDeReceita: Double = transacoes
            .filter { transacao -> transacao.tipo == Tipo.RECEITA }
            .sumByDouble{ transacao -> transacao.valor.toDouble() }

        return BigDecimal(somaDeReceita)
    }

    fun despesa() :BigDecimal{
        var totalDespesa = BigDecimal.ZERO
        for (transacao in transacoes){
            if (transacao.tipo == Tipo.DESPESA) {
                totalDespesa = totalDespesa.plus(transacao.valor)
            }
        }

        return totalDespesa
    }

    fun total(): BigDecimal{
        return receita().subtract(despesa())
    }
}