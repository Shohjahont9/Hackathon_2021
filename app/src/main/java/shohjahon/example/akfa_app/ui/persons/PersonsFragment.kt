package shohjahon.example.akfa_app.ui.persons

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.note.ui.base.BaseFragment
import com.example.note.ui.utils.nextPageMain
import shohjahon.example.akfa_app.R
import shohjahon.example.akfa_app.adapter.PersonsAdapter
import shohjahon.example.akfa_app.databinding.FragmentPersonsBinding
import shohjahon.example.akfa_app.model.Persons
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

        listOfPersons.clear()

        initList()

    }

    private fun initList() {
        listOfPersons.add(Persons("Saw1", "Asil"))
        listOfPersons.add(Persons("Saw2", "Anvar"))
        listOfPersons.add(Persons("Saw3", "Akbar"))

        initRv()

        mAdapter.submitDataList(listOfPersons)
    }

    private fun initRv() {
        mAdapter = PersonsAdapter(this)
        binding!!.rv.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            setHasFixedSize(true)
            adapter = mAdapter
        }
    }

    override fun onItemClick(position: Int, data: Persons) {
        val bundle = Bundle()
        val fragment = StanokFragment()
        var saw = ""
        when(position){
            0-> saw="SAW1"
            1-> saw="SAW2"
            2-> saw="SAW3"
        }
        bundle.putString("saw", saw)
        val fragmentManager = requireActivity().supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
        fragment.setArguments(bundle)

        transaction.replace(R.id.frameFragment, fragment).addToBackStack(StanokFragment().toString()).commit()
    }


}