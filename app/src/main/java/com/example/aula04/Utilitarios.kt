package com.example.aula04

import android.content.Context
import androidx.appcompat.app.AlertDialog

//funções globais: esta disponivel pra chamar onde quiser. necessita de um lugar para colocar > um arquivo kotlin.
//não necessita instanciar pois não possui nada. semelhante a static. this só existe em atividades, onde tem classes.

fun showMsg(titulo: String, msg: String, contexto: Context) {

    AlertDialog.Builder(contexto)
    .setTitle(titulo)
        .setMessage(msg)
        .setPositiveButton("OK", null)
        .create()
        .show()

}
