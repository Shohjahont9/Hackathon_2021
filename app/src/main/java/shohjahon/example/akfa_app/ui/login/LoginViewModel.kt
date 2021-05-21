package shohjahon.example.akfa_app.ui.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import shohjahon.example.akfa_app.network.response.loginResponse.LogiResponse
import uz.fizmasoft.xatlov.utils.Resource
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    private val _loginToApp = MutableLiveData<Resource<LogiResponse>>()
    val loginToApp: LiveData<Resource<LogiResponse>> = _loginToApp

    fun login(data: String) = viewModelScope.launch {
        _loginToApp.value = Resource.loading(null)
        try {
            _loginToApp.value = Resource.success(repository.login(data))
        } catch (e: Exception) {
            Log.d("ERROR", "login error -> login view model")
        }
    }


}