package com.mindmoney
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mindmoney.ui.finanzas.FinanzasFragment
import com.mindmoney.ui.inicio.InicioFragment
import com.mindmoney.ui.mensajes.MensajesFragment
import com.mindmoney.ui.tareas.TareasFragment
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//carga activity_main
        val bottomNavigation =
            findViewById<BottomNavigationView>(R.id.bottom_navigation)//busca menu inferior
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, InicioFragment())//InicioFragment abre inicialmente
            .commit()
        //nav inferior
        bottomNavigation.setOnItemSelectedListener { item ->//seton... detectar botón pulsado
            val fragment = when (item.itemId) {
                R.id.navigation_inicio -> InicioFragment()
                R.id.navigation_finanzas -> FinanzasFragment()
                R.id.navigation_tareas -> TareasFragment()
                R.id.navigation_mensajes -> MensajesFragment()
                else -> InicioFragment()
            }
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)//replace cambia pantalla actual
                .commit()
            true
        }
    }
}