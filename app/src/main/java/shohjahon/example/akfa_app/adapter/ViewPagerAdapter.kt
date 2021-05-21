package shohjahon.example.akfa_app.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import shohjahon.example.akfa_app.ui.home.deadline.DeadlineFragment
import shohjahon.example.akfa_app.ui.home.nagruzka.NagruzkaFragment

class ViewPagerAdapter(
    private val fragment: Fragment,
) : FragmentStateAdapter(fragment) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> DeadlineFragment(fragment)
            1 -> NagruzkaFragment(fragment)
            else -> DeadlineFragment(fragment)
        }
    }

}