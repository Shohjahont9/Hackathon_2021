package shohjahon.example.akfa_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import shohjahon.example.akfa_app.databinding.ItemExpiredBinding
import shohjahon.example.akfa_app.databinding.ItemPesonsBinding
import shohjahon.example.akfa_app.model.Persons
import shohjahon.example.akfa_app.network.response.expiredResponse.DataExperid
import kotlin.collections.ArrayList


@SuppressLint("SetTextI18n")
class PersonsAdapter(
    private val listener: CardAdapterListener
) : ListAdapter<Persons, PersonsAdapter.CardsViewHolder>(
    DIFF_JOB_CALLBACK
) {

    private lateinit var fullDataList: ArrayList<Persons>


    companion object {
        val DIFF_JOB_CALLBACK = object : DiffUtil.ItemCallback<Persons>() {
            override fun areItemsTheSame(
                oldItem: Persons,
                newItem: Persons
            ) = newItem.name== oldItem.name

            override fun areContentsTheSame(
                oldItem: Persons,
                newItem: Persons
            ) = newItem.name == oldItem.name

        }
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsViewHolder(ItemPesonsBinding.inflate(LayoutInflater.from(parent.context),parent,false), listener)

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.setIsRecyclable(true)
        holder.bind()
    }

    fun submitDataList(list: List<Persons>) {
        submitList(list)
        println("list submit")
        fullDataList = ArrayList(list)
    }

    inner class CardsViewHolder
    constructor(
        private val binding: ItemPesonsBinding,
        private val listener: CardAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val data = getItem(adapterPosition)
            with(binding) {

                tvName.text = data.name

                tvDescription.text = data.description

                llLl.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION)
                        listener.onItemClick(adapterPosition, data)
                }
            }
        }
    }


    interface CardAdapterListener {
        fun onItemClick(position: Int, data: Persons)
    }
}

