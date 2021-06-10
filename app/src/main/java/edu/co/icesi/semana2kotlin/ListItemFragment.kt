package edu.co.icesi.semana2kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class ListItemFragment : Fragment(), NewItemFragment.OnNewTaskListener {


    var tasks: ArrayList<String> = ArrayList()

    //UI
    lateinit var taskslist: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list_item, container, false)
        taskslist = root.findViewById(R.id.taskslist)

        taskslist.setText("")
        for (task in tasks){
            taskslist.append("${task}\n\n")
        }

        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListItemFragment()
    }

    override fun onNewTask(task: String) {
        tasks.add(task)
    }
}