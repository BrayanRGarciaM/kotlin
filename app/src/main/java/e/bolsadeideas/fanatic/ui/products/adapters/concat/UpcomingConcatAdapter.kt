package e.bolsadeideas.fanatic.ui.products.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import e.bolsadeideas.fanatic.core.BaseConcatHolder
import e.bolsadeideas.fanatic.databinding.UpcomingProductRowBinding
import e.bolsadeideas.fanatic.ui.products.adapters.ProductAdapter

class UpcomingConcatAdapter(private val moviesAdapter: ProductAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = UpcomingProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: UpcomingProductRowBinding): BaseConcatHolder<ProductAdapter>(binding.root){
        override fun bind(adapter: ProductAdapter) {
            binding.rvUpcomingProducts.adapter = adapter
        }

    }
}