package shohjahon.example.akfa_app.ui.home.deadline

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import shohjahon.example.akfa_app.network.response.expiredResponse.ExpiredResponse
import uz.fizmasoft.xatlov.utils.Resource
import javax.inject.Inject

@HiltViewModel
class DeadlineViewModel @Inject constructor(
    private val repository: DeadlineRepository
) :ViewModel(){

    private val _expiredData = MutableLiveData<Resource<ExpiredResponse>>()
    val expiredData: LiveData<Resource<ExpiredResponse>> = _expiredData

    fun expired(token: String) = viewModelScope.launch {
        _expiredData.value = Resource.loading(null)
        try {
            _expiredData.value = Resource.success(repository.expired(token))
        } catch (e: Exception) {
            Log.d("ERROR", "expired error -> deadline view model")
        }
    }


}