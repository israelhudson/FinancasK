package xyz.ihudapp.financask.ui.activity

import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.DatePicker
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_lista_transacoes.*
import kotlinx.android.synthetic.main.form_transacao.view.*
import xyz.ihudapp.financask.R
import xyz.ihudapp.financask.extension.formataParaBrasileiro
import xyz.ihudapp.financask.model.Tipo
import xyz.ihudapp.financask.model.Transacao
import xyz.ihudapp.financask.ui.ResumoView
import xyz.ihudapp.financask.ui.adapter.ListaTransacoesAdapter
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

class ListaTransacoesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_transacoes)

        val transacoes: List<Transacao> = transacoesDeExemplo()

        configuraResumo(transacoes)

        configuraLista(transacoes)

        lista_transacoes_adiciona_receita
            .setOnClickListener {
                val view: View = window.decorView
                val viewCriada = LayoutInflater.from(this).inflate(
                    R.layout.form_transacao,
                    view as ViewGroup,
                    false)

                val ano = 2017
                val mes = 9
                val dia = 18

                val hoje = Calendar.getInstance()
                viewCriada.form_transacao_data.setText(hoje.formataParaBrasileiro())
                viewCriada.form_transacao_data.setOnClickListener {
                    DatePickerDialog(this,
                        DatePickerDialog.OnDateSetListener { view, ano, mes, dia ->
                            val dataSelecionada = Calendar.getInstance()
                            dataSelecionada.set(ano, mes, dia)
                            viewCriada.form_transacao_data
                                .setText(dataSelecionada.formataParaBrasileiro())
                        }, ano, mes, dia)
                        .show()
                }

                val adapter = ArrayAdapter
                    .createFromResource(this,
                        R.array.categorias_de_receita,
                        android.R.layout.simple_spinner_dropdown_item)

                viewCriada.form_transacao_categoria.adapter = adapter

                AlertDialog.Builder(this)
                    .setTitle("Adiciona Receita")
                    .setView(viewCriada)
                    .setPositiveButton("Adicionar") { dialog, which ->

                        val valorEmTexto = viewCriada
                            .form_transacao_valor.text.toString()
                        val dataEmTexto = viewCriada
                            .form_transacao_data.text.toString()
                        val categoriaEmTexto = viewCriada
                            .form_transacao_categoria.selectedItem.toString()

                        val valor = BigDecimal(valorEmTexto)

                        val formatoBrasileiro = SimpleDateFormat("dd/MM/yyyy")

                        val dataConvertida: Date = formatoBrasileiro.parse(dataEmTexto)
                        val data = Calendar.getInstance()
                        data.time = dataConvertida

                        val transacaoCriada = Transacao(
                            tipo = Tipo.RECEITA,
                            valor = valor,
                            data = data,
                            categoria = categoriaEmTexto
                        )

                        Log.d("GUGU", "FOI")

                        Toast.makeText(this, "${transacaoCriada.tipo} - " +
                                "${transacaoCriada.valor} - " +
                                "${transacaoCriada.categoria} - ${transacaoCriada.data.formataParaBrasileiro()}", Toast.LENGTH_LONG).show()

                    }
                    .setNegativeButton("Cancelar", null)
                    .show()
            }
    }

    private fun configuraResumo(transacoes: List<Transacao>) {
        val view: View = window.decorView
        val resumoView = ResumoView(this, view, transacoes)
        resumoView.atualiza()
    }

    private fun configuraLista(transacoes: List<Transacao>) {
        lista_transacoes_listview.adapter = ListaTransacoesAdapter(transacoes, this)
    }

    private fun transacoesDeExemplo() : List<Transacao> {
        return listOf(
            Transacao(
                categoria = "Almoço de final de semana",
                tipo = Tipo.DESPESA, data = Calendar.getInstance(), valor = BigDecimal(100.0)
            ),
            Transacao(
                valor = BigDecimal(100.0), tipo = Tipo.RECEITA,
                categoria = "Economia"
            ),
            Transacao(
                valor = BigDecimal(100.0), tipo = Tipo.DESPESA
            ),
            Transacao(
                valor = BigDecimal(200.0),
                categoria = "Prêmio",
                tipo = Tipo.RECEITA
            )
        )
    }

}