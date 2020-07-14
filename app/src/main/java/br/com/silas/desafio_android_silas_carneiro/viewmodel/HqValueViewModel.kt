package br.com.silas.desafio_android_silas_carneiro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.silas.desafio_android_silas_carneiro.api.config.DataResponse
import br.com.silas.desafio_android_silas_carneiro.api.config.ResultApi
import br.com.silas.desafio_android_silas_carneiro.model.HqValue
import br.com.silas.desafio_android_silas_carneiro.provider.providerHqValueUseCase
import br.com.silas.desafio_android_silas_carneiro.usecase.HqValueUseCase
import br.com.silas.desafio_android_silas_carneiro.utils.Contants
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.hqValue.HqValueEvent
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.hqValue.HqValueState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

class HqValueViewModel(private var usecase: HqValueUseCase = providerHqValueUseCase()) : ViewModel() {

    private var state = MutableLiveData<HqValueState>()
    private var event = MutableLiveData<HqValueEvent>()

    var viewState: LiveData<HqValueState> = state
    var viewEvent: LiveData<HqValueEvent> = event

    fun getListHq(idHero: Int) {
        GlobalScope.launch {
            val result = usecase.getListHq(idHero)
            afterCall(
                result
            )
        }
    }

    private fun afterCall(result: ResultApi<DataResponse<ArrayList<HqValue>>>) {
        when (result.isSucess()) {
            true -> formatResultCallApi(result.value)
            false -> state.postValue(HqValueState.ErrorCallApi(result.error?.message))
        }
    }

    private fun formatResultCallApi(result: DataResponse<ArrayList<HqValue>>?) {
        when (result?.statusCode) {
            Contants.STATUS_CODE_DUZENTOS -> state.postValue(HqValueState.SucessCallApi(result.data?.result))
            else -> state.postValue(HqValueState.ErrorCallApi(result?.status))
        }
    }
}