package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.* //KAE

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Nas KAE os IDs se tornam "variaveis(?)" só funciona no kotlin.
        //tipos de binding 1 - findingviewbyid > mais simples disponivel.
        // 2 - kotlin android extensions (KAE) > para não fazer binding toda hora, necessita de configurações, não vem ativado no projeto.
        // classe criada que mapeia tudo que foi criado no xml
        // 3 - ViewBinding automatico > necessita de config na atividade para ativar. Versão melhorada do KAE. Funciona no Java. Está sempre no XML certo.


        //--------------------------- binding < usando findviewbyid.
//        val editNome: EditText = findViewById(R.id.editNome)
//        val editTelefone: EditText = findViewById(R.id.editTelefone)
//        val editEmail: EditText = findViewById(R.id.editEmail)
//        val checkTelefone: CheckBox = findViewById(R.id.checkTelefone)
//        val checkEmail: CheckBox = findViewById(R.id.checkEmail)
//        val buttonRegistrar: Button = findViewById(R.id.buttonRegistrar)
//        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)


        buttonRegistrar.setOnClickListener {
            if (!editNome.text.isBlank() && !editTelefone.text.isBlank()
                && !editEmail.text.isBlank()) {

                var preferenciaHorario = when(radioGroup.checkedRadioButtonId) {
                    R.id.radioManha -> "Manhã"
                    R.id.radioTarde -> "Tarde"
                    R.id.radioNoite -> "Noite"
                    else -> "Não informado"
                }

                /*
                var preferenciaHorario = ""
                when(radioGroup.checkedRadioButtonId) {
                    R.id.radioManha -> preferenciaHorario = "Manhã"
                    R.id.radioTarde -> preferenciaHorario = "Tarde"
                    R.id.radioNoite -> preferenciaHorario = "Noite"
                    else -> preferenciaHorario = "Não informado"
                }
                 */

                val msg = """${getString(R.string.nome)}: ${editNome.text}
                |Telefone: ${editTelefone.text}
                |Email: ${editEmail.text}
                |Contato por telefone: ${checkTelefone.isChecked}    
                |Contato por email: ${checkEmail.isChecked}
                |Horário de contato: $preferenciaHorario
                """.trimMargin()

                //passar contexto por parametro: this.
                showMsg("Sucesso", msg, this)
            }
            else {
                showMsg("Erro", getString(R.string.msg_erro), this)
            }
        }

    }
}