package mvi.mvistudy.view.fragments.listFragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.android.material.floatingactionbutton.FloatingActionButton
import mvi.mvistudy.view.fragments.listFragment.adapter.ListFragmentAdapter
import mvi.mvistudy.view.fragments.listFragment.adapter.ViewCallback
import mvi.mvistudy.view.dialogs.ConfirmationDialog
import mvi.mvistudy.view.dialogs.ConfirmationDialogCallback
import mvi.mvistudy.viewModel.ListFragmentViewModel
import mvi.mvistudy.databinding.ListFragmentBinding
import mvi.mvistudy.view.fragments.BaseFragment
import mvi.mvistudy.view.fragments.creationFragment.CreationFragment
import mvi.mvistudy.view.fragments.DetailsFragment
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : BaseFragment(){

    private val viewModel : ListFragmentViewModel by viewModel()
    private val adapter: ListFragmentAdapter by inject()
    private var binding : ListFragmentBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel.processIntent(ListFragmentIntent.UpdateList)
        viewModel.currentState.observe(viewLifecycleOwner, { state ->
            if(state.isUpdated) adapter.updateList(state.objectsList)
            if(!state.isUpdated) viewModel.processIntent(ListFragmentIntent.UpdateList)}
        )
        binding = ListFragmentBinding.inflate(inflater, container, false)

        val recyclerView : RecyclerView? = binding?.recyclerView
        adapter.viewCallback = object : ViewCallback {
            override fun removePosition(positionID: Long) {
                showDialog(ConfirmationDialog(object : ConfirmationDialogCallback {
                    override fun onConfirm() {
                        viewModel.processIntent(ListFragmentIntent.RemovePosition(positionID))
                    }
                }))
            }
            override fun positionDetails(positionID: Long) {
                showFragment(DetailsFragment.getInstance(positionID))
            }
        }

        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity)
        recyclerView?.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            )
            {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.left = 10
                outRect.right = 10
                outRect.bottom = 15
                outRect.top = 15
            }
        })

        val addPosition: FloatingActionButton? = binding?.fab
        addPosition?.setOnClickListener { showFragment(CreationFragment()) }

        return binding?.root
    }

    override fun onResume() {
        viewModel.processIntent(ListFragmentIntent.UpdateList)
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}