package com.defasta.aplikasiku.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.defasta.aplikasiku.R
import com.defasta.aplikasiku.ui.model.ModelSepeda
import com.defasta.aplikasiku.ui.screen.RecyclerViewClickListener

internal class SepedaAdapter(private var sepedaList: List<ModelSepeda>): RecyclerView.Adapter<SepedaAdapter.MyViewHolder>() {

    var listener: RecyclerViewClickListener? = null

    internal class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        var nama: TextView = view.findViewById(R.id.title)
        var tahun: TextView = view.findViewById(R.id.year)
        var jenis: TextView = view.findViewById(R.id.genre)
        var itemList: ConstraintLayout = view.findViewById(R.id.itemList)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val sepeda = sepedaList[position]
        holder.nama.text = sepeda.getNama()
        holder.jenis.text = sepeda.getJenis()
        holder.tahun.text = sepeda.getTahun()

        holder.itemList.setOnClickListener {
            listener?.onItemClicked(it, sepedaList[position])
        }
    }

    override fun getItemCount(): Int {
        return sepedaList.size
    }

}