package co.ritinha.numerosmegasena

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MegaSena : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mega_sena)

        val editNumber: EditText = findViewById(R.id.edit_number)
        val textResult: TextView = findViewById(R.id.text_result)
        val btnGenerate: Button = findViewById(R.id.btn_generate)

        // inicializando
        prefs = getSharedPreferences("db", Context.MODE_PRIVATE)

        // chave e valor
        val result = prefs.getString("result", null)

        // verificar se o valor é doferente de null
        result.let{
            textResult.text = "$result"
        }

        // bottao gerar
        btnGenerate.setOnClickListener {
            val text = editNumber.text.toString()
            numberGerator(text, textResult)
        }

    }

    fun numberGerator(text: String, textResult: TextView){
        // falha em branco
        if (text.isEmpty()){
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_SHORT).show()
            return
        }

        val qtd = text.toInt()

        // falha
        if (qtd < 6 || qtd > 15){
            Toast.makeText(this, "Informe um numero entre 6 e 15", Toast.LENGTH_SHORT).show()
            return
        }

        // sucesso
        val numbers = mutableSetOf<Int>()
        val random = Random()

        while (true){
            val number = random.nextInt(60)//0..59
            numbers.add(number + 1) // add 1 no numero gerado

            if (numbers.size == qtd){
                break
            }
        }

        // texto de resultado
        textResult.text = numbers.joinToString(" | ")

        // gravando registros
        prefs.edit().apply{
            putString("result", textResult.text.toString())
            apply()
        }
    }
}