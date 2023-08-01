package co.ritinha.numerosmegasena

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // mega-sena
        val btnMegaSena: LinearLayout = findViewById(R.id.layout_megasena)
        btnMegaSena.setOnClickListener{
            startActivity(Intent(this, MegaSena::class.java))
        }

        // lotofacil
        val btnLotoFacil: LinearLayout = findViewById(R.id.layout_lotofacil)
        btnLotoFacil.setOnClickListener{
            startActivity(Intent(this, LotoFacil::class.java))
        }

        // quina
        val btnQuina: LinearLayout = findViewById(R.id.layout_quina)
        btnQuina.setOnClickListener{
            startActivity(Intent(this, Quina::class.java))
        }

        // lotomania
        val btnLotoMania: LinearLayout = findViewById(R.id.layout_lotomania)
        btnLotoMania.setOnClickListener{
            startActivity(Intent(this, LotoMania::class.java))
        }
    }
}