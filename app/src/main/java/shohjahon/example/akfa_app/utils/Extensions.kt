package com.example.note.ui.utils

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import shohjahon.example.akfa_app.R
import java.util.*


fun Fragment.toast(message: String, isLong: Boolean = false) {
    if (!isLong)
        Toast.makeText(context, message, Toast.LENGTH_SHORT)
            .show()
    else
        Toast.makeText(context, message, Toast.LENGTH_LONG)
            .show()
}

fun mlogging(msg: String) = Log.i("MY_LOG", msg)

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}


fun Fragment.nextPageMain(fragment: Fragment, tag: String, isBack: Boolean, bundle: Bundle) {
    val fragmentManager = requireActivity().supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
    fragment.setArguments(bundle)
    if (isBack)
        transaction.replace(R.id.frameFragment, fragment).addToBackStack(tag).commit()
    else
        transaction.replace(R.id.frameFragment, fragment).commit()
}


fun Fragment.backPageMain(fragment: Fragment) {
    val fragmentManager = requireActivity().supportFragmentManager
    val transaction = fragmentManager.beginTransaction()
    transaction.setCustomAnimations(R.anim.back_in, R.anim.back_out)
        transaction.replace(R.id.frameFragment, fragment).commit()
}



fun Fragment.hideKeyBoard(v: View) {
    val imm = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(v.windowToken, 0)
}

fun Fragment.timePicker(editText: EditText){
    val mcurrentTime = Calendar.getInstance()
    val year = mcurrentTime.get(Calendar.YEAR)
    val month = mcurrentTime.get(Calendar.MONTH)
    val day = mcurrentTime.get(Calendar.DAY_OF_MONTH)

    val datePicker =
        DatePickerDialog(requireContext(), object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                var day = dayOfMonth.toString()
                var month = (month + 1).toString()
                var year = year.toString()
                if (day.length == 1) day = "0$day"
                if (month.length == 1) month = "0$month"

                editText.setText("$day-$month-$year")
            }
        }, year, month, day)
    datePicker.show()
}

