package xyz.ihudapp.financask.model

import java.math.BigDecimal
import java.util.Calendar

class Transacao(val valor: BigDecimal,
                val categoria: String = "Indefinida",
                val tipo: Tipo,
                val data: Calendar = Calendar.getInstance())

//    val valor: BigDecimal = valor
//    private val categoria: String = categoria
//    private val data: Calendar = data
