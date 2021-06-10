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

    lateinit var newTaskET: EditText
    lateinit var addBtn: Button

    var listener : OnNewTaskListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_new_item, container, false)
        newTaskET = root.findViewById(R.id.newTaskET)
        addBtn = root.findViewById(R.id.addBtn)
        addBtn.setOnClickListener(::addNewTask)

        return root
    }

    fun addNewTask(view:View){
        val str = newTaskET.text.toString()
        Toast.makeText(context, str, Toast.LENGTH_LONG).show()
        listener?.onNewTask(str)
    }

    //Patrón observer
    interface OnNewTaskListener {
        fun onNewTask(task:String)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewItemFragment()
    }
}