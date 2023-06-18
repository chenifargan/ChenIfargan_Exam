package com.example.chenifargan_exam

import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ViewUtils.dpToPx
import kotlin.math.roundToInt

class MyAdapter(private val numbers:MutableList<Numbers>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val VIEW_TYPE_ZERO_SUM =0
    private val VIEW_TYPE_NORMAL_SUM =1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    return when (viewType){
        VIEW_TYPE_ZERO_SUM-> {
            val view =LayoutInflater.from(parent.context).inflate(R.layout.item_number_zero,parent,false)
            ZeroSumViewHolder(view)
        }
        else ->{
            val view =LayoutInflater.from(parent.context).inflate(R.layout.item_number_normal,parent,false)
            NormalSumViewHolder(view)
        }
    }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val number = numbers[position]

        when(holder){
            is ZeroSumViewHolder->{
                holder.bind(number)
            }
            is NormalSumViewHolder->{
                    holder.bind(number)
            }
        }


    }

    override fun getItemCount(): Int {
    return numbers.size
    }

    override fun getItemViewType(position: Int): Int {
        val currentNumber = numbers[position].number
        for (i in 0 until  numbers.size){
            if (i!=position){
                val otherNumber = numbers[i].number
                if (currentNumber + otherNumber==0){
                    return VIEW_TYPE_ZERO_SUM

                }
            }
        }
//        if(position>0&&position<numbers.size-1){
//            val previousNumber = numbers[position-1]
//            val nextNumber = numbers[position+1]
//            if(number.number+previousNumber.number==0||number.number+nextNumber.number==0){
//            }
//        }
        return VIEW_TYPE_NORMAL_SUM
    }


    inner class ZeroSumViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        private val numberTextView:TextView = itemView.findViewById(R.id.numberTextViewZero)
        fun bind(numbers: Numbers){
            numberTextView.text = numbers.number.toString()
           // itemView.layoutParams.height =dpToPx(150)
           // itemView.setBackgroundColor(Color.RED)

        }

    }
    inner class NormalSumViewHolder(itemView : View):RecyclerView.ViewHolder(itemView){
        private val numberTextView:TextView = itemView.findViewById(R.id.numberTextViewNormal)
        fun bind(numbers: Numbers){
            numberTextView.text = numbers.number.toString()
           // itemView.layoutParams.height =dpToPx(100)
            //itemView.setBackgroundColor(Color.BLUE)

        }

    }



    private fun dpToPx(dp:Int): Int{
        val density = Resources.getSystem().displayMetrics.density
        return (dp*density).roundToInt()
    }
    fun submitList(newNumber: List<Numbers>){
        numbers.clear()
        numbers.addAll(newNumber)
        notifyDataSetChanged()
    }


}