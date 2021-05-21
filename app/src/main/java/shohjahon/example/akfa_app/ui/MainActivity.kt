package shohjahon.example.akfa_app.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.ui.home.HomeFragment
import shohjahon.example.akfa_app.ui.profile.ProfileFragment
import shohjahon.example.akfa_app.ui.settings.SettingsFragment

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                window.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
            }
        }
        window.statusBarColor = Color.TRANSPARENT

        changePage(HomeFragment())

        createDrawerLayout()

        onClicks()
    }

    private fun onClicks() {
        ic_menu.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
    }

    private fun changePage(newFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        transaction.replace(R.id.frameFragment, newFragment).commit()
    }

    private fun createDrawerLayout() {
        toggle = ActionBarDrawerToggle(this, drawerLayout, null, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    changePage(HomeFragment())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.settings -> {
                    changePage(SettingsFragment())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }

                R.id.profile -> {
                    changePage(ProfileFragment())
                    drawerLayout.closeDrawer(GravityCompat.START)
                }

            }
            true
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
            finishAffinity()
        }
    }


}