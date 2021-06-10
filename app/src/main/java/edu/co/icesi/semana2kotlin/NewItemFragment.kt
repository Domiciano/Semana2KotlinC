package edu.co.icesi.semana2kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class NewItemFragment : Fragment() {

    var newTaskET: EditText? = null
    var addBtn: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_new_item, container, false)
        newTaskET = root.findViewById(R.id.newTaskET)
        addBtn = root.findViewById(R.id.addBtn)
        addBtn?.setOnClickListener(::addNewTask)

        return root
    }

    fun addNewTask(view:View){
        val str = newTaskET?.text.toString()
        Toast.makeText(context, str, Toast.LENGTH_LONG).show()
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewItemFragment()
    }
}