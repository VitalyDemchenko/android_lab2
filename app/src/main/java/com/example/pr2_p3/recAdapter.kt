package com.example.pr2_p3
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pr2_p3.R
import com.example.pr2_p3.databinding.FragmentMainBinding
import com.example.pr2_p3.databinding.RecyclerRowBinding

class recAdapter (
    private val itemList: List<Pair<String, String?>>,
    private val onItemClick: (position: Int) -> Unit
):

    RecyclerView.Adapter<recAdapter.recHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recHolder {
// inflates the view
// that is used to hold list item

        val itemBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context))
        return recHolder(itemBinding, onItemClick)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: recHolder, position: Int) {
        val recData = itemList[position]
// sets the image to the imageview from our itemHolder class // holder.imageView.setImageResource(Items ViewModel.image)
// sets the text to the textview from our itemHolder class holder.bind(animalData.first, animalData.second)
        holder.bind(recData.first, recData.second)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {

        return itemList.size
    }

    // Holds the views for adding it to image and text
    class recHolder(
        private val itemBinding: RecyclerRowBinding,
        private val onItemClick: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        fun bind(animalName: String, animalPhotoUrl: String?) {
            Glide.with(itemView) //2
                .load(animalPhotoUrl) //3
                .centerCrop() //4
                .placeholder(itemBinding.img1.drawable) //5
                .error(R.drawable.ic_launcher_background) //6 - resource empty
                .fallback(R.drawable.ic_launcher_foreground) //7 URL - null
                .into(itemBinding.img1) //8
            itemBinding.txt1.text = animalName
        }
    }
}

