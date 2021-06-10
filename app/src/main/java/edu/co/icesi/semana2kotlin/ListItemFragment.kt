package edu.co.icesi.semana2kotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class ListItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_list_item, container, false)
        return root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListItemFragment()
    }
}