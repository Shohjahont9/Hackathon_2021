package shohjahon.example.akfa_app.ui.persons

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.note.ui.base.BaseFragment
import com.example.note.ui.utils.backPageMain
import com.example.note.ui.utils.nextPageMain
import com.example.note.ui.utils.toast
import shohjahon.example.akfa_app.adapter.ExpiredAdapter
import shohjahon.example.akfa_app.adapter.PersonsAdapter
import shohjahon.example.akfa_app.databinding.FragmentPersonsBinding
import shohjahon.example.akfa_app.model.Persons
import shohjahon.example.akfa_app.ui.home.HomeFragment
import shohjahon.example.akfa_app.ui.stanok.StanokFragment


class PersonsFragment : BaseFragment<FragmentPersonsBinding>(), PersonsAdapter.CardAdapterListener {

    private val listOfPersons = ArrayList<Persons>()
    private lateinit var mAdapter: PersonsAdapter

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPersonsBinding = FragmentPersonsBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initList()

    }

    private fun initList() {
        listOfPersons.add(Persons("Shohjahon", "4-stanokchi"))
        listOfPersons.add(Persons("Sarvar", "3-stanokchi"))
        listOfPersons.add(Persons("Axmadullo", "1-stanokchi"))
        listOfPersons.add(Persons("Bekzod", "1-stanokchi"))
        listOfPersons.add(Persons("Komil", "2-stanokchi"))
        initRv()
        mAdapter.submitDataList(listOfPersons)
    }

    private fun initRv() {
        mAdapter = PersonsAdapter(this)
        binding!!.rv.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    override fun onItemClick(position: Int, data: Persons) {
        nextPageMain(StanokFragment(), StanokFragment().toString())
    }


}