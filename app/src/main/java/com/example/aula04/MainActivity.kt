package com.example.aula04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
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

        buttonRegistrar.setOnClickListener {
            if (!editNome.text.isBlank() && !editTelefone.text.isBlank()
                && !editEmail.text.isBlank()) {

                val msg = """Nome: ${editNome.text}
                |Telefone: ${editTelefone.text}
                |Email: ${editEmail.text}
                |Contato por telefone: ${checkTelefone.isChecked}    
                |Contato por email: ${checkEmail.isChecked}
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