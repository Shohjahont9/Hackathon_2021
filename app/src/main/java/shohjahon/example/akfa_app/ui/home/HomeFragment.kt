package shohjahon.example.akfa_app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.note.ui.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.adapter.ViewPagerAdapter
import shohjahon.example.akfa_app.databinding.FragmentHomeBinding

class HomeFragment :BaseFragment<FragmentHomeBinding>(){

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding  = FragmentHomeBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()

    }


    private fun setViewPager() {
        with(binding!!) {
            viewPager.adapter = ViewPagerAdapter(this@HomeFragment)
            viewPager.isUserInputEnabled = true
            val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Muddati yaqin"
                    1 -> tab.text = "Nagruzka"
                }
            }
            tabLayoutMediator.attach()
        }
    }
}