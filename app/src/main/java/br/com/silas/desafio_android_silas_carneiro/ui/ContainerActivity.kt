package br.com.silas.desafio_android_silas_carneiro.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.ui.characterList.CharacterListFragment

class ContainerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.container_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharacterListFragment.newInstance())
                .commit()
        }
    }
}