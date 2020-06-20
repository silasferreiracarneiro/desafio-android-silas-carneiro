package br.com.silas.desafio_android_silas_carneiro.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.SPLASH_TIME_OUT

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_splash, container, false)

        val action = SplashFragmentDirections.actionSplashFragmentToCharacterListFragment()
        Handler().postDelayed({
            view.findNavController().navigate(action)
        }, SPLASH_TIME_OUT)

        return view
    }
}