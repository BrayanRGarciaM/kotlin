package e.bolsadeideas.fanatic.ui.products.adapters.concat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import e.bolsadeideas.fanatic.core.BaseConcatHolder
import e.bolsadeideas.fanatic.databinding.TopRatedProductRowBinding
import e.bolsadeideas.fanatic.ui.products.adapters.ProductAdapter

class TopRatedConcatAdapter(private val moviesAdapter: ProductAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = TopRatedProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }

    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: TopRatedProductRowBinding): BaseConcatHolder<ProductAdapter>(binding.root){
        override fun bind(adapter: ProductAdapter) {
            binding.rvTopRatedProducts.adapter = adapter
        }

    }

}