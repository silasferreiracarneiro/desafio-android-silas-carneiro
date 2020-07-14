package br.com.silas.desafio_android_silas_carneiro.ui.hqValue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.silas.desafio_android_silas_carneiro.R
import br.com.silas.desafio_android_silas_carneiro.adapter.HqValueAdapter
import br.com.silas.desafio_android_silas_carneiro.model.HqValue
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.ID_HERO
import br.com.silas.desafio_android_silas_carneiro.viewmodel.HqValueViewModel
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.hqValue.HqValueState
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.ArrayList

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
    private lateinit var progress: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_hq_value, container, false)

        bindViewModel()
        bindProperties(view)
        addObservable()
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

    private fun addObservable() {
        viewmodel.viewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is HqValueState.SucessCallApi -> sucessCallApi(it.result)
                is HqValueState.ErrorCallApi -> errorCallApi(it.message)
            }
        })
    }

    private fun errorCallApi(message: String?) {
        progress.visibility = View.GONE
    }

    private fun sucessCallApi(result: ArrayList<HqValue>?) {
        result?.let {
            configureAdapter(it)
            progress.visibility = View.GONE
            recyclerHq.visibility = View.VISIBLE
        }
    }

    private fun configureAdapter(list: ArrayList<HqValue>) {
        recyclerHq.setHasFixedSize(true)
        recyclerHq.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerHq.isNestedScrollingEnabled = false
        recyclerHq.adapter = HqValueAdapter(list)
        ((recyclerHq.adapter as HqValueAdapter).notifyDataSetChanged())
    }

    private fun bindProperties(view: View) {
        recyclerHq = view.findViewById(R.id.list_hq)
        progress = view.findViewById(R.id.progress_load_hq)
    }
}