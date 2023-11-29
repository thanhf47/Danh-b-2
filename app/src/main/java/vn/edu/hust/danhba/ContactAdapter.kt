package vn.edu.hust.danhba

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val items: ArrayList<ItemModel>, val listFragment: ListFragment) : RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val icon = view.findViewById<TextView>(R.id.icon)
        val name = view.findViewById<TextView>(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.icon.text = item.name[0].toString()
        holder.name.text = item.name

        holder.itemView.setOnClickListener {
            listFragment.getDetail(item.name, item.email, item.phoneNumber)
        }
    }
}