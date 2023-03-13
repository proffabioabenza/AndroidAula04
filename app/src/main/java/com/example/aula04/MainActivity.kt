package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //binding
        val editNome: EditText = findViewById(R.id.editNome)
        val editTelefone: EditText = findViewById(R.id.editTelefone)
        val editEmail: EditText = findViewById(R.id.editEmail)
        val checkTelefone: CheckBox = findViewById(R.id.checkTelefone)
        val checkEmail: CheckBox = findViewById(R.id.checkEmail)
        val buttonRegistrar: Button = findViewById(R.id.buttonRegistrar)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)

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

                val msg = """Nome: ${editNome.text}
                |Telefone: ${editTelefone.text}
                |Email: ${editEmail.text}
                |Contato por telefone: ${checkTelefone.isChecked}    
                |Contato por email: ${checkEmail.isChecked}
                |Horário de contato: $preferenciaHorario
                """.trimMargin()

                showMsg("Sucesso", msg)
            }
            else {
                showMsg("Erro", "Preencha todos os campos")
            }
        }

    }

    fun showMsg(titulo: String, msg: String) {

        AlertDialog.Builder(this)
            .setTitle(titulo)
            .setMessage(msg)
            .setPositiveButton("OK", null)
            .create()
            .show()

    }
}