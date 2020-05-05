package com.lingdtkhe.testapp.common.util

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.annotation.ArrayRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lingdtkhe.testapp.R

/**
 * Extension for building alert dialogs
 * @author Ling Dam Tkhe
 */
fun Context.showAlertDialog(
    @StringRes titleId: Int? = null,
    message: String? = null,
    @StringRes messageId: Int? = null,
    cancelable: Boolean = false,
    cancelableTouchOutside: Boolean = false,
    customView: View? = null,
    builderFunction: MaterialAlertDialogBuilder.() -> Any
): AlertDialog {
    val builder = MaterialAlertDialogBuilder(
        this,
        R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog
    )
    builder.builderFunction()
    titleId?.let { builder.setTitle(titleId) }
    customView?.let { builder.setView(it) }
    message?.let {
        builder.setMessage(message)
    }
    messageId?.let {
        builder.setMessage(messageId)
    }
    builder.setCancelable(cancelableTouchOutside)
    builder.setCancelable(cancelable)
    val dialog = builder.create()
    try {
        dialog.show()
    } catch (e: Exception) {
    }
    return dialog
}

fun MaterialAlertDialogBuilder.positiveButton(
    text: Int = R.string.all_yes,
    handleClick: (dialog: DialogInterface, i: Int) -> Unit = { _, _ -> }
) {
    this.setPositiveButton(text) { d, i -> handleClick(d, i) }
}

fun MaterialAlertDialogBuilder.negativeButton(
    text: Int = R.string.all_no,
    handleClick: (dialog: DialogInterface, i: Int) -> Unit = { _, _ -> }
) {
    this.setNegativeButton(text) { d, i -> handleClick(d, i) }
}

fun MaterialAlertDialogBuilder.neutralButton(
    text: Int = R.string.all_cancel,
    handleClick: (dialog: DialogInterface, i: Int) -> Unit = { _, _ -> }
) {
    this.setNeutralButton(text) { d, i -> handleClick(d, i) }
}

fun MaterialAlertDialogBuilder.singleChoice(
    @ArrayRes array: Int, checkedItem: Int = -1,
    handleClick: (i: Int, dialog: DialogInterface) -> Unit = { _, _ -> }
) {
    this.setSingleChoiceItems(
        array, checkedItem
    ) { dialogInterface, i -> handleClick(i, dialogInterface) }
}

fun MaterialAlertDialogBuilder.singleChoice(
    array: Array<String>, checkedItem: Int = -1,
    handleClick: (i: Int, dialog: DialogInterface) -> Unit = { _, _ -> }
) {
    this.setSingleChoiceItems(
        array, checkedItem
    ) { dialogInterface, i -> handleClick(i, dialogInterface) }
}

fun MaterialAlertDialogBuilder.multipleChoice(
    @ArrayRes array: Int, checkedItem: BooleanArray
) {
    this.setMultiChoiceItems(array, checkedItem) { d, w, b ->
        checkedItem[w] = b
    }
}

fun MaterialAlertDialogBuilder.multipleChoice(
    array: Array<String>, checkedItem: BooleanArray,
    handleSelect: (dialog: DialogInterface, i: Int, b: Boolean) -> Unit = { _, _, _ -> }
) {
    this.setMultiChoiceItems(array, checkedItem) { d, w, b ->
        checkedItem[w] = b
        handleSelect(d, w, b)
    }
}

