package mvi.mvistudy.view.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ConfirmationDialog(private val onConfirmCallback : ConfirmationDialogCallback): DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        builder.setMessage("Confirm please")
            .setPositiveButton("Confirm") { _: DialogInterface?, _: Int -> onConfirmCallback.onConfirm() }
            .setNegativeButton("Cancel") { dialog: DialogInterface, _: Int -> dialog.dismiss() }
        return builder.create()
    }
}