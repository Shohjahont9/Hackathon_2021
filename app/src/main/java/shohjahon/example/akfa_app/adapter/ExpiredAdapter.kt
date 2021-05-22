package shohjahon.example.akfa_app.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import shohjahon.example.akfa_app.databinding.ItemExpiredBinding
import shohjahon.example.akfa_app.network.response.expiredResponse.DataExperid
import kotlin.collections.ArrayList


@SuppressLint("SetTextI18n")
class ExpiredAdapter(
    private val listener: CardAdapterListener
) : ListAdapter<DataExperid, ExpiredAdapter.CardsViewHolder>(
    DIFF_JOB_CALLBACK
) {

    private lateinit var fullDataList: ArrayList<DataExperid>


    companion object {
        val DIFF_JOB_CALLBACK = object : DiffUtil.ItemCallback<DataExperid>() {
            override fun areItemsTheSame(
                oldItem: DataExperid,
                newItem: DataExperid
            ) = newItem.articul == oldItem.articul

            override fun areContentsTheSame(
                oldItem: DataExperid,
                newItem: DataExperid
            ) = newItem.articul == oldItem.articul

        }
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardsViewHolder(
            ItemExpiredBinding.inflate(LayoutInflater.from(parent.context),parent,false),
            listener
        )

    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
        holder.setIsRecyclable(true)
        holder.bind()
    }

    fun submitDataList(list: List<DataExperid>) {
        submitList(list)
        println("list submit")
        fullDataList = ArrayList(list)
    }

    inner class CardsViewHolder
    constructor(
        private val binding: ItemExpiredBinding,
        private val listener: CardAdapterListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val data = getItem(adapterPosition)
            with(binding) {

                tvName.text = data.type

                tvSubName.text = data.saw

                tvArticul.text = data.articul

                tvLifeTime.text = "${data.remained} soat/ ${data.life_time} soat"

                val progress = (data.remained!!/data.life_time!!).toString().substring(0,3)
                tvPercent.text = "$progress%"

                circularProgressBar.progress = progress.toFloat()

                root.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION)
                        listener.onItemClick(adapterPosition, data)
                }
            }
        }
    }


    interface CardAdapterListener {
        fun onItemClick(position: Int, data: DataExperid)
    }
}

