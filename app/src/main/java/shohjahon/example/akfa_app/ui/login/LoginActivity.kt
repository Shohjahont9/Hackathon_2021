package shohjahon.example.akfa_app.ui.login

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log.println
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.note.ui.utils.visible
import com.google.gson.JsonObject
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.ui.MainActivity
import shohjahon.example.akfa_app.utils.exhaustive
import shohjahon.example.akfa_app.utils.hideKeyBoard
import uz.fizmasoft.xatlov.db.preferences.PreferencesManager
import uz.fizmasoft.xatlov.utils.Status
import javax.inject.Inject

@Suppress("DEPRECATION")

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var preferences: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
        window.statusBarColor = Color.TRANSPARENT

        if(preferences.isPermission){
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }

        llyes.setOnClickListener {
            if (et_username.text.toString().isNotEmpty() && et_password.text.toString()
                    .isNotEmpty()
            ) {

                val data = JsonObject()
                data.addProperty("username", et_username.text.toString().trim())
                data.addProperty("password", et_password.text.toString().trim())
                viewModel.login(data.toString())
                observeLogin()
                hideKeyBoard(llyes)

            } else Toast.makeText(
                applicationContext,
                "Bo`sh maydonlarni to`ldiring",
                Toast.LENGTH_SHORT
            ).show()

        }

    }

    private fun observeLogin() {
        viewModel.loginToApp.observe(this, Observer {
            when (it.status) {
                Status.LOADING -> animationView.visible(true)
                Status.SUCCESS -> {
                    animationView.visible(false)
                    val data = it.data
                    if (data != null) {
                        val token = data.token
                        preferences.userToken = token!!
                        preferences.isPermission= true
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    } else {
                    }
                }
                Status.ERROR -> {
                    animationView.visible(false)
                }
            }.exhaustive
        })
    }

}