package br.com.silas.desafio_android_silas_carneiro.ui.base

import android.app.AlertDialog
import androidx.fragment.app.Fragment
import br.com.silas.desafio_android_silas_carneiro.R

abstract class BaseFragment : Fragment() {

    private lateinit var dialog: AlertDialog

    fun showLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater
        builder.setView(inflater?.inflate(R.layout.custom_loading, null))
        builder.setCancelable(false)

        dialog = builder.create()
        dialog.show()
    }

    fun dismissDialog() {
        dialog.dismiss()
    }

    fun showDialogError() {

    }

    fun hideDialogError() {

    }
}