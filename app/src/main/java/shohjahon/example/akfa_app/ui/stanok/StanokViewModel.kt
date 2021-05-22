package shohjahon.example.akfa_app.ui.stanok

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import shohjahon.example.akfa_app.network.response.items.ItemsResponse
import uz.fizmasoft.xatlov.utils.Resource
import javax.inject.Inject

@HiltViewModel
class StanokViewModel @Inject constructor(
    private val repository: StanokRepository
) : ViewModel(){

    private val _stanokData = MutableLiveData<Resource<ItemsResponse>>()
    val stanokData: LiveData<Resource<ItemsResponse>> = _stanokData

    fun stanok( saw:String, token:String) = viewModelScope.launch {
        _stanokData.value = Resource.loading(null)
        try {
            _stanokData.value = Resource.success(repository.items(saw, token))
        } catch (e: Exception) {
            Log.d("ERROR", "stanok error -> stanok view model")
        }
    }


}