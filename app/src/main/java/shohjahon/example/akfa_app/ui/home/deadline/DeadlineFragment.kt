package shohjahon.example.akfa_app.ui.home.deadline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.ui.base.BaseFragment
import com.example.note.ui.utils.toast
import com.example.note.ui.utils.visible
import dagger.hilt.android.AndroidEntryPoint
import shohjahon.example.akfa_app.adapter.ExpiredAdapter
import shohjahon.example.akfa_app.databinding.FragmentDeadlineBinding
import shohjahon.example.akfa_app.network.response.expiredResponse.DataExperid
import shohjahon.example.akfa_app.utils.exhaustive
import uz.fizmasoft.xatlov.db.preferences.PreferencesManager
import uz.fizmasoft.xatlov.utils.Status.*
import javax.inject.Inject

@AndroidEntryPoint
class DeadlineFragment(fragment: Fragment) : BaseFragment<FragmentDeadlineBinding>(),
    ExpiredAdapter.CardAdapterListener {

    lateinit var mAdapter: ExpiredAdapter
    val listOfDeadline = ArrayList<DataExperid>()
    private val viewModel: DeadlineViewModel by viewModels()

    @Inject
    lateinit var preferences: PreferencesManager

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDeadlineBinding = FragmentDeadlineBinding.inflate(layoutInflater)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
    }

    private fun loadData() {
        viewModel.expired(preferences.userToken)
        viewModel.expiredData.observe(viewLifecycleOwner, Observer {
            with(binding!!) {
                when (it.status) {
                    LOADING -> animationView.visible(true)
                    SUCCESS -> {
                        animationView.visible(false)
                        val data = it.data!!.data
                        if (data != null) {
                            data.forEach {
                                listOfDeadline.add(
                                    DataExperid(
                                        it.articul,
                                        it.life_time,
                                        it.remained,
                                        it.saw,
                                        it.type
                                    )
                                )
                            }
                            initRv()
                            mAdapter.submitDataList(listOfDeadline)
                        } else {
                        }
                    }
                    ERROR -> {
                        animationView.visible(false)
                        toast(it.message.toString())
                    }
                }.exhaustive
            }
        })
    }

    private fun initRv() {
        mAdapter = ExpiredAdapter(this)
        binding!!.rv.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    override fun onItemClick(position: Int, data: DataExperid) {

    }


}