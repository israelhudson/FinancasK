package xyz.ihudapp.financask.model

import java.math.BigDecimal

class Resumo(private val transacoes: List<Transacao>) {

    val receita get() = somaPor(Tipo.RECEITA)

    val despesa get() = somaPor(Tipo.DESPESA)

    val total get() = receita.subtract(despesa)

    private fun somaPor(tipo: Tipo): BigDecimal{
        val somaDeTransacoesPeloTipo = BigDecimal(transacoes
            .filter { it.tipo == tipo }
            .sumByDouble { it.valor.toDouble() })
        return somaDeTransacoesPeloTipo
    }

}