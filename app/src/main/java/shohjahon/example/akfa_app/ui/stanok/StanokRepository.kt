package shohjahon.example.akfa_app.ui.stanok

import uz.fizmasoft.xatlov.network.ApiService
import javax.inject.Inject

class StanokRepository @Inject constructor(
   private val api:ApiService
){
    suspend fun items(saw:String,token:String, ) = api.items(saw,token)
}