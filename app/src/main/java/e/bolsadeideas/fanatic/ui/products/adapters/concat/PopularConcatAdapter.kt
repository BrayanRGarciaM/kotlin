package e.bolsadeideas.fanatic.ui.products.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import e.bolsadeideas.fanatic.core.BaseConcatHolder
import e.bolsadeideas.fanatic.databinding.PopularProductRowBinding

class PopularConcatAdapter(private val moviesAdapter: ProductAdapter): RecyclerView.Adapter<BaseConcatHolder<*>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {
        val itemBinding = PopularProductRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ConcatViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when(holder){
            is ConcatViewHolder -> holder.bind(moviesAdapter)
        }
    }
    // The size is 1 because is just 1 adapter
    override fun getItemCount(): Int = 1

    private inner class ConcatViewHolder(val binding: PopularProductRowBinding): BaseConcatHolder<ProductAdapter>(binding.root) {
        override fun bind(adapter: ProductAdapter) {
            binding.rvPopularProducts.adapter = adapter
        }
    }
}