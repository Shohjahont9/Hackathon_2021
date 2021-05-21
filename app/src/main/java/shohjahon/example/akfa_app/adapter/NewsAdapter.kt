//package shohjahon.example.akfa_app.adapter
//
//import android.annotation.SuppressLint
//import android.graphics.Color
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.uiexample.databinding.CardItemBinding
//import com.example.uiexample.models.Card
//import kotlin.collections.ArrayList
//
//
//@SuppressLint("SetTextI18n")
//class NewsAdapter(
//    private val listener: CardAdapterListener
//) : ListAdapter<Card, NewsAdapter.CardsViewHolder>(
//    DIFF_JOB_CALLBACK
//) {
//
//    private lateinit var fullDataList: ArrayList<Card>
//
//
//    companion object {
//        val DIFF_JOB_CALLBACK = object : DiffUtil.ItemCallback<Card>() {
//            override fun areItemsTheSame(
//                oldItem: Card,
//                newItem: Card
//            ) = newItem.name == oldItem.name
//
//            override fun areContentsTheSame(
//                oldItem: Card,
//                newItem: Card
//            ) = newItem.name == oldItem.name
//
//        }
//    }
//
//    override fun getItemId(position: Int) = position.toLong()
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        CardsViewHolder(
//            CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false),
//            listener
//        )
//
//    override fun onBindViewHolder(holder: CardsViewHolder, position: Int) {
//        holder.setIsRecyclable(true)
//        holder.bind()
//    }
//
//    fun submitDataList(list: List<Card>) {
//        submitList(list)
//        println("list submit")
//        fullDataList = ArrayList(list)
//    }
//
//    inner class CardsViewHolder
//    constructor(
//        private val binding: CardItemBinding,
//        private val listener: CardAdapterListener
//    ) : RecyclerView.ViewHolder(binding.root) {
//        fun bind() {
//            val data = getItem(adapterPosition)
//            with(binding) {
//                if (adapterPosition%2==0) cardBack.setBackgroundColor(Color.parseColor("#494CF8"))
//                else cardBack.setBackgroundColor(Color.parseColor("#DFE7F5"))
//
//                tvCardCode.text = "•••• •••• •••• " + data.code.substring(12)
//                tvCardName.text = data.name
//                tvCardValidation.text = data.validDate
//
//                root.setOnClickListener {
//                    if (adapterPosition != RecyclerView.NO_POSITION)
//                        listener.onItemClick(adapterPosition, data)
//                }
//            }
//        }
//    }
//
//
//    interface CardAdapterListener {
//        fun onItemClick(position: Int, data: Card)
//    }
//}
//
