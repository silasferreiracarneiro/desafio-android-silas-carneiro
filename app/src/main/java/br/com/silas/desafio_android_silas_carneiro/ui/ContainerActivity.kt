package br.com.silas.desafio_android_silas_carneiro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import br.com.silas.desafio_android_silas_carneiro.R

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)

        val host = NavHostFragment.create(R.navigation.navigation)
        supportFragmentManager.beginTransaction().replace(R.id.container, host)
            .setPrimaryNavigationFragment(host).commit()
    }
}