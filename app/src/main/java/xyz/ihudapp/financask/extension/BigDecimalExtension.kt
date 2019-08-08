package xyz.ihudapp.financask.extension

import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.Locale

fun BigDecimal.formataParaBrasileiro() : String {

    val formatoBrasileiro = DecimalFormat
        .getCurrencyInstance(Locale("pt", "br"))

    var moedaFormatada = formatoBrasileiro.format(this).replace("R$", "R$ ")

    return moedaFormatada

}