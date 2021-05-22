package shohjahon.example.akfa_app.ui.home.deadline

import uz.fizmasoft.xatlov.network.ApiService
import javax.inject.Inject

class DeadlineRepository @Inject constructor(
    private val api:ApiService
) {
    suspend fun expired(token:String) = api.expired(token)

}