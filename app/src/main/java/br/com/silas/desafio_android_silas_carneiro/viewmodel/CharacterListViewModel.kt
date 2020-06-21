package br.com.silas.desafio_android_silas_carneiro.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.silas.desafio_android_silas_carneiro.api.config.DataResponse
import br.com.silas.desafio_android_silas_carneiro.api.config.ResultApi
import br.com.silas.desafio_android_silas_carneiro.model.CharacterPerson
import br.com.silas.desafio_android_silas_carneiro.provider.providerCharacterListUseCase
import br.com.silas.desafio_android_silas_carneiro.usecase.CharacterListUseCase
import br.com.silas.desafio_android_silas_carneiro.utils.Contants.STATUS_CODE_DUZENTOS
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList.CharacterListEvent
import br.com.silas.desafio_android_silas_carneiro.viewmodel.states.characterList.CharacterListState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CharacterListViewModel(private val usecase: CharacterListUseCase = providerCharacterListUseCase()) : ViewModel() {

    private var event = MutableLiveData<CharacterListEvent>()
    private var state = MutableLiveData<CharacterListState>()

    var viewEvent: LiveData<CharacterListEvent> = event
    var viewState: LiveData<CharacterListState> = state

    fun getListCharacter() {
        GlobalScope.launch {
            val result = usecase.getListCharacter()
            afterCall(
                    result
                )
        }
    }

    private fun afterCall(result: ResultApi<DataResponse<CharacterPerson>>) {
        when (result.isSucess()) {
            true -> formatResultCallApi(result.value)
            false -> state.postValue(CharacterListState.ErrorCallApi(result.error?.message))
        }
    }

    private fun formatResultCallApi(result: DataResponse<CharacterPerson>?) {
        when (result?.statusCode) {
            STATUS_CODE_DUZENTOS -> state.postValue(CharacterListState.SucessCallApi(result.data?.result))
            else -> state.postValue(CharacterListState.ErrorCallApi(result?.status))
        }
    }
}