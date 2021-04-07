package mvi.mvistudy.view.fragments

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import mvi.mvistudy.R

open class BaseFragment : Fragment() {

    fun dismissFragment(){
        activity?.supportFragmentManager?.popBackStack()
    }

    fun showFragment(fragment: Fragment) {
        val transaction : FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
        transaction?.replace(R.id.fragmentPlaceHolder, fragment)
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    fun showDialog(dialog: DialogFragment) {
        dialog.show(parentFragmentManager, "anyTag")
    }
}