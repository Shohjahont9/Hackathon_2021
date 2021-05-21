package shohjahon.example.akfa_app.ui.login

import uz.fizmasoft.xatlov.network.ApiService
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api:ApiService
) {
    suspend fun login(data:String) = api.login(data)


}