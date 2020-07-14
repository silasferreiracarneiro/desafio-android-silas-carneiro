package br.com.silas.desafio_android_silas_carneiro.ui.hqValue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.ID_HERO
import br.com.silas.desafio_android_silas_carneiro.viewmodel.HqValueViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class HqValueFragment : BottomSheetDialogFragment() {

    companion object {
        fun newInstance(idHero: Int) = HqValueFragment().apply {
            val bundle = Bundle()
            bundle.putInt(ID_HERO, idHero)
            this.arguments = bundle
        }
    }

    private lateinit var viewmodel: HqValueViewModel

    private lateinit var recyclerHq: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hq_value, container, false)

        bindViewModel()
        bindProperties(view)
        getListHq()

        return view
    }

    private fun getListHq() {
        val idHero = arguments?.getInt(ID_HERO)
        idHero?.let {
            viewmodel.getListHq(it)
        }
    }

    private fun bindViewModel() {
        viewmodel = ViewModelProviders.of(this).get(HqValueViewModel::class.java)
    }

    private fun bindProperties(view: View) {
        recyclerHq = view.findViewById(R.id.list_hq)
    }
}