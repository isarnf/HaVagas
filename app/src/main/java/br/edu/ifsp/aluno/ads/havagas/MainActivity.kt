package br.edu.ifsp.aluno.ads.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import br.edu.ifsp.aluno.ads.havagas.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

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

                val pessoa = Pessoa(nomeCompletoEt.text.toString(), emailEt.text.toString(), desejaReceberEmail,
                    telefoneEt.text.toString(), telefoneTipo, telefoneCelularEt.text.toString(), sexo,
                    data, formacaoSp.selectedItem.toString(), anoFormacaoEt.text.toString(),
                    instituicaoEt.text.toString(),tituloMonografiaEt.text.toString(),
                    orientadorEt.text.toString(), vagasInteresseEt.text.toString())
                Toast.makeText(this@MainActivity, pessoa.toString(), Toast.LENGTH_LONG).show()
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
}