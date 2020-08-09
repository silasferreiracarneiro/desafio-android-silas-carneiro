package br.com.silas.desafio_android_silas_carneiro.ui.detailSerie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.model.HeroSeries
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.SERIE_HQ
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DetailSerieFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_detail_serie, container, false)



        return view
    }

    companion object {
        fun newInstance(serie: HeroSeries) = DetailSerieFragment().apply {
            val bundle = Bundle()
            bundle.putSerializable(SERIE_HQ, serie)
        }
    }
}