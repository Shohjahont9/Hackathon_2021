package shohjahon.example.akfa_app.ui.home

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.note.ui.base.BaseFragment
import com.example.note.ui.utils.nextPageMain
import com.google.android.material.tabs.TabLayoutMediator
import com.yabu.livechart.model.DataPoint
import com.yabu.livechart.model.Dataset
import com.yabu.livechart.view.LiveChartStyle
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.adapter.ViewPagerAdapter
import shohjahon.example.akfa_app.databinding.FragmentHomeBinding
import shohjahon.example.akfa_app.ui.persons.PersonsFragment

@AndroidEntryPoint
class HomeFragment :BaseFragment<FragmentHomeBinding>(){

    override fun setBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding  = FragmentHomeBinding.inflate(layoutInflater)

    val firstDataset = Dataset(
        mutableListOf(
            DataPoint(0f, 24f),
            DataPoint(1f, 26f),
            DataPoint(2f, 23f),
            DataPoint(3f, 24f),
            DataPoint(4f, 20f),
            DataPoint(5f, 18f),
            DataPoint(6f, 24f),
            DataPoint(7f, 23f),
            DataPoint(8f, 20f),
            DataPoint(9f, 25f),
            DataPoint(10f, 28f)
        )
    )

    val secondDataset = Dataset(
        mutableListOf(
            DataPoint(0f, 11560f),
            DataPoint(1f, 9212f),
            DataPoint(2f, 11243f),
            DataPoint(3f, 14335f),
            DataPoint(4f, 9324f),
            DataPoint(5f, 11240f),
            DataPoint(6f, 9244f),
            DataPoint(7f, 8124f),
            DataPoint(8f, 14421f),
            DataPoint(9f, 10000f),
            DataPoint(10f, 10273f)
        )
    )
    val thirdDataset = Dataset(
        mutableListOf(
            DataPoint(0f, 7560f),
            DataPoint(1f, 14212f),
            DataPoint(2f, 13243f),
            DataPoint(3f, 12335f),
            DataPoint(4f, 9324f),
            DataPoint(5f, 13240f),
            DataPoint(6f, 9244f),
            DataPoint(7f, 12124f),
            DataPoint(8f, 10421f),
            DataPoint(9f, 16600f),
            DataPoint(10f, 11273f)
        )
    )

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPager()

        onClicks()

        with(binding!!) {

            val style = LiveChartStyle().apply {
                mainColor = requireContext().getColor(R.color.blue_custom)
                secondColor = requireContext().getColor(R.color.blue_custom)
                pathStrokeWidth = 10f
                secondPathStrokeWidth = 10f
                boundsLineColor =  requireContext().getColor(R.color.blue_custom)
                mainFillColor =  requireContext().getColor(R.color.bb_custom)
                overlayLineColor = Color.BLUE
                overlayCircleDiameter = 32f
                overlayCircleColor = Color.parseColor("#9092F8")
            }

            val x  = liveChart.pivotX
            println("x -> $x")

            liveChart.setDataset(firstDataset)
                .setDataset(secondDataset)
                .setSecondDataset(thirdDataset)
                .setLiveChartStyle(style)
                .setBaselineManually(10.0f)
                .drawYBounds()
                .drawBaselineFromFirstPoint()
                .drawBaseline()
                .drawFill(withGradient = true)
                .drawBaselineConditionalColor()
                .drawHorizontalGuidelines(steps = 4)
                .drawSmoothPath()
                .drawDataset()

        }
    }

    private fun onClicks() {
        ll_stanok.setOnClickListener{
            nextPageMain(PersonsFragment(), "gg->Person")
        }
    }


    private fun setViewPager() {
        with(binding!!) {
            viewPager.adapter = ViewPagerAdapter(this@HomeFragment)
            viewPager.isUserInputEnabled = true
            val tabLayoutMediator = TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "Состояние"
                    1 -> tab.text = "Под нагрузкой"
                }
            }
            tabLayoutMediator.attach()
        }
    }
}