package br.com.silas.desafio_android_silas_carneiro.viewmodel.states.hqValue

import br.com.silas.desafio_android_silas_carneiro.model.HqValue

open class HqValueState {
    data class SucessCallApi(val result: ArrayList<HqValue>?) : HqValueState()
    data class ErrorCallApi(val message: String?) : HqValueState()
}