package mvi.mvistudy.view.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class InputNotValidDialog : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Indicated data is not valid")
            .setNegativeButton("Try again") { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        return builder.create()
    }
}