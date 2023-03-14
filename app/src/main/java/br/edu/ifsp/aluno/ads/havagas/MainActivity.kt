package br.edu.ifsp.aluno.ads.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import androidx.core.view.isVisible
import br.edu.ifsp.aluno.ads.havagas.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    companion object {
        val NOME = "NOME"
        val EMAIL = "EMAIL"
        val TELEFONE = "TELEFONE"
        val TELEFONE_CELULAR = "TELEFONE_CELULAR"
        val DATA_NASC = "DATA_NASC"
        val FORMACAO = "FORMACAO"
        val ANO_FORMACAO = "ANO_FORMACAO"
        val INSTITUICAO = "INSTITUICAO"
        val TITULO_MONO = "TITULO_MONO"
        val ORIENTADOR = "ORIENTADOR"
        val VAGAS_INT = "VAGAS_INT"
    }


    private val activityMainBinding: ActivityMainBinding by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activityMainBinding.root)

        with(activityMainBinding) {
            telefoneCelularBt.setOnClickListener {
                telefoneCelularEt.visibility = View.VISIBLE
            }




            formacaoSp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (position == 1 || position == 2) {
                        anoFormacaoEt.visibility = View.VISIBLE
                        instituicaoEt.visibility = View.GONE
                        tituloMonografiaEt.visibility = View.GONE
                        orientadorEt.visibility = View.GONE
                    } else if (position == 3 || position == 4) {
                        anoFormacaoEt.visibility = View.VISIBLE
                        instituicaoEt.visibility = View.VISIBLE
                        tituloMonografiaEt.visibility = View.GONE
                        orientadorEt.visibility = View.GONE
                    } else if (position == 5 || position == 6) {
                        anoFormacaoEt.visibility = View.VISIBLE
                        instituicaoEt.visibility = View.VISIBLE
                        tituloMonografiaEt.visibility = View.VISIBLE
                        orientadorEt.visibility = View.VISIBLE
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    //NAO SE APLICA
                }
            }


            salvarBt.setOnClickListener {
                val sexo: String?
                if(femininoRb.isSelected){
                    sexo="Feminino"
                }else{
                    sexo="Masculino"
                }

                val desejaReceberEmail: String?
                if(simRb.isSelected){
                    desejaReceberEmail="Sim"
                }else{
                    desejaReceberEmail="Não"
                }

                val telefoneTipo: String?
                if(comercialRb.isSelected){
                    telefoneTipo="Comercial"
                }else{
                    telefoneTipo="Residencial"
                }

                val day=dataNascimentoDp.dayOfMonth
                val month=dataNascimentoDp.month
                val year=dataNascimentoDp.year
                val data = "${day}/${month}/${year}"

                if(nomeCompletoEt.text.isNotEmpty() && emailEt.text.isNotEmpty()
                    && desejaReceberEmail.toString().isNotEmpty() && telefoneEt.text.isNotEmpty()
                    && telefoneTipo.isNotEmpty() && telefoneCelularEt.text.isNotEmpty()
                    && sexo.isNotEmpty() && data.isNotEmpty() && formacaoSp.selectedItem.toString().isNotEmpty()
                    && anoFormacaoEt.text.isNotEmpty() && vagasInteresseEt.text.isNotEmpty()){

                    if(formacaoSp.selectedItem.toString().equals("Graduação") || formacaoSp.selectedItem.toString().equals("Especialização")){
                        if(instituicaoEt.text.toString().isNotEmpty()){
                            Toast.makeText(this@MainActivity, "Nome completo: " +
                                    "${nomeCompletoEt.text.toString()}, E-mail: ${emailEt.text.toString()}, " +
                                    "Deseja receber e-mail? ${desejaReceberEmail.toString()}, " +
                                    "Tipo telefone: ${telefoneTipo}, Telefone: ${telefoneEt.text.toString()}" +
                                    "Telefone celular: ${telefoneCelularEt.text.toString()}, " +
                                    "Sexo: ${sexo}, Data nascimento: ${data}, Formação: ${formacaoSp.selectedItem.toString()}, " +
                                    "Ano de formação: ${anoFormacaoEt.text.toString()}, Instituição: ${instituicaoEt.text.toString()}, " +
                                    "Vagas de interesse: ${vagasInteresseEt.text.toString()}",
                                Toast.LENGTH_LONG).show()
                        }
                    }else if(formacaoSp.selectedItem.toString().equals("Mestrado") || formacaoSp.selectedItem.toString().equals("Doutorado")){
                        if(tituloMonografiaEt.text.toString().isNotEmpty() && orientadorEt.text.toString().isNotEmpty()){
                            Toast.makeText(this@MainActivity, "Nome completo: " +
                                    "${nomeCompletoEt.text.toString()}, E-mail: ${emailEt.text.toString()}, " +
                                    "Deseja receber e-mail? ${desejaReceberEmail.toString()}, " +
                                    "Tipo telefone: ${telefoneTipo}, Telefone: ${telefoneEt.text.toString()}, " +
                                    "Telefone celular: ${telefoneCelularEt.text.toString()}, " +
                                    "Sexo: ${sexo}, Data nascimento: ${data}, Formação: ${formacaoSp.selectedItem.toString()}, " +
                                    "Ano de formação: ${anoFormacaoEt.text.toString()}, Instituição: ${instituicaoEt.text.toString()}, " +
                                    "Título monografia: ${tituloMonografiaEt.text.toString()}, " +
                                    "Orientador: ${orientadorEt.text.toString()}, " +
                                    "Vagas de interesse: ${vagasInteresseEt.text.toString()}",
                                Toast.LENGTH_LONG).show()
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Nome completo: " +
                                "${nomeCompletoEt.text.toString()}, E-mail: ${emailEt.text.toString()}, " +
                                "Deseja receber e-mail? ${desejaReceberEmail.toString()}, " +
                                "Tipo telefone: ${telefoneTipo}, Telefone: ${telefoneEt.text.toString()}, " +
                                "Telefone celular: ${telefoneCelularEt.text.toString()}, " +
                                "Sexo: ${sexo}, Data nascimento: ${data}, Formação: ${formacaoSp.selectedItem.toString()}, " +
                                "Ano de formação: ${anoFormacaoEt.text.toString()}, Vagas de interesse: ${vagasInteresseEt.text.toString()}",
                            Toast.LENGTH_LONG).show()
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Preencha todos os campos obrigatórios!",
                        Toast.LENGTH_LONG).show()
                }
            }


            limparBt.setOnClickListener {
                nomeCompletoEt.setText("")
                emailEt.setText("")
                telefoneEt.setText("")
                telefoneCelularEt.setText("")
                telefoneCelularEt.visibility= View.GONE
                vagasInteresseEt.setText("")
                receberEmailsRg.clearCheck()
                telefoneTipoRg.clearCheck()
                sexoRg.clearCheck()
                dataNascimentoDp.updateDate(Calendar.YEAR, Calendar.MONTH, Calendar.DAY_OF_MONTH)
                formacaoSp.setSelection(0)
                anoFormacaoEt.setText("")
                instituicaoEt.setText("")
                tituloMonografiaEt.setText("")
                orientadorEt.setText("")
                anoFormacaoEt.visibility = View.GONE
                instituicaoEt.visibility = View.GONE
                tituloMonografiaEt.visibility = View.GONE
                orientadorEt.visibility = View.GONE

            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(NOME, activityMainBinding.nomeCompletoEt.text.toString())
        outState.putString(EMAIL, activityMainBinding.emailEt.text.toString())
        outState.putString(TELEFONE, activityMainBinding.telefoneEt.text.toString())
        outState.putString(TELEFONE_CELULAR, activityMainBinding.telefoneCelularEt.text.toString())
        outState.putString(DATA_NASC, activityMainBinding.dataNascimentoDp.toString())
        outState.putString(FORMACAO, activityMainBinding.formacaoSp.selectedItem.toString())
        outState.putString(ANO_FORMACAO, activityMainBinding.anoFormacaoEt.text.toString())
        outState.putString(INSTITUICAO, activityMainBinding.instituicaoEt.text.toString())
        outState.putString(TITULO_MONO, activityMainBinding.tituloMonografiaEt.text.toString())
        outState.putString(ORIENTADOR, activityMainBinding.orientadorEt.text.toString())
        outState.putString(VAGAS_INT, activityMainBinding.vagasInteresseEt.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        activityMainBinding.nomeCompletoEt.setText(savedInstanceState?.getString(NOME, ""))
        activityMainBinding.emailEt.setText(savedInstanceState?.getString(EMAIL, ""))
        activityMainBinding.telefoneEt.setText(savedInstanceState?.getString(TELEFONE, ""))
        activityMainBinding.telefoneCelularEt.setText(savedInstanceState?.getString(TELEFONE_CELULAR, ""))
        activityMainBinding.anoFormacaoEt.setText(savedInstanceState?.getString(ANO_FORMACAO, ""))
        activityMainBinding.instituicaoEt.setText(savedInstanceState?.getString(INSTITUICAO, ""))
        activityMainBinding.tituloMonografiaEt.setText(savedInstanceState?.getString(TITULO_MONO, ""))
        activityMainBinding.orientadorEt.setText(savedInstanceState?.getString(ORIENTADOR, ""))
        activityMainBinding.vagasInteresseEt.setText(savedInstanceState?.getString(VAGAS_INT, ""))

    }
}