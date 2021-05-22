package shohjahon.example.akfa_app.ui.stanok

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.ui.base.BaseFragment
import com.example.note.ui.utils.toast
import com.example.note.ui.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.adapter.ExpiredAdapter
import shohjahon.example.akfa_app.adapter.ItemsAdapter
import shohjahon.example.akfa_app.databinding.FragmentStanokBinding
import shohjahon.example.akfa_app.network.response.expiredResponse.DataExperid
import shohjahon.example.akfa_app.network.response.items.DataItems
import shohjahon.example.akfa_app.ui.home.deadline.DeadlineViewModel
import shohjahon.example.akfa_app.utils.exhaustive
import uz.fizmasoft.xatlov.db.preferences.PreferencesManager
import uz.fizmasoft.xatlov.utils.Status
import javax.inject.Inject

@AndroidEntryPoint
class StanokFragment : BaseFragment<FragmentStanokBinding>(), ItemsAdapter.CardAdapterListener {

    lateinit var mAdapter: ItemsAdapter
    val listOfStanok = ArrayList<DataItems>()
    private val viewModel: StanokViewModel by viewModels()
        var saw = ""
    @Inject
    lateinit var preferences: PreferencesManager

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentStanokBinding = FragmentStanokBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments.let {
            saw = it!!.getString("saw").toString()
        }

        loadData()

    }

    private fun loadData() {
        viewModel.stanok(saw, preferences.userToken)
        viewModel.stanokData.observe(viewLifecycleOwner, Observer {
            with(binding!!) {
                when (it.status) {
                    Status.LOADING -> animationView.visible(true)
                    Status.SUCCESS -> {
                        animationView.visible(false)
                        val data = it.data!!.data
                        if (data != null) {
                            data.forEach {
                                listOfStanok.add(
                                    DataItems(
                                        it.articul,
                                        it.initial_details,
                                        it.life_time,
                                        it.remained_details,
                                        it.remained_hours,
                                        it.saw,
                                        it.type
                                    )
                                )
                            }
                            initRv()
                            mAdapter.submitDataList(listOfStanok)
                        } else {
                        }
                    }
                    Status.ERROR -> {
                        animationView.visible(false)
                        toast(it.message.toString())
                    }
                }.exhaustive
            }
        })
    }

    private fun initRv() {
        mAdapter = ItemsAdapter(this)
        binding!!.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }


    override fun onItemClick(position: Int, data: DataItems) {

    }

}