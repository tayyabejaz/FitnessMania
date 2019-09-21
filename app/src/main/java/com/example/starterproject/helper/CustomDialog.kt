package com.example.starterproject.helper

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.Window
import com.example.starterproject.R
import kotlinx.android.synthetic.main.dialog_custom.view.*


/**
 * Created by Tayyab Ejaz
 */

abstract class CustomDialog(
    private val context: Context,
    private val dialogTitleText: String,
    private val dialogBodyText: String,
    private val dialogBtnNegativeText: String,
    private val dialogBtnPositiveText: String,
    private val isAdEnabled: Boolean
) {

    private var dialog: Dialog? = null
    private var dialogView: View? = null


    val isShowing: Boolean
        get() = dialog!!.isShowing


    fun createDialog() {
        val mInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        dialogView = mInflater.inflate(R.layout.dialog_custom, null)


        dialog = Dialog(context)
        dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        dialog?.window?.decorView?.setBackgroundResource(android.R.color.transparent)
        dialog?.setContentView(dialogView!!)

        dialogView?.dialog_title?.text = dialogTitleText
        dialogView?.dialog_body?.text = dialogBodyText
        dialogView?.dialog_btn_negative?.text = dialogBtnNegativeText
        dialogView?.dialog_btn_positive?.text = dialogBtnPositiveText


        dialogView?.dialog_btn_negative?.setOnClickListener { onNegativeBtnClick(dialog) }
        dialogView?.dialog_btn_positive?.setOnClickListener { onPositiveBtnClick(dialog) }


        if (isAdEnabled) {
            AdsManager.getInstance()?.showBanner(dialogView!!.adView)
        } else {
            dialogView?.adView?.visibility = View.GONE
        }

    }


    fun showDialog() {
        if (dialog != null)
            dialog!!.show()
    }


    fun showNegativeBtn(isVisible: Boolean) {
        dialogView?.dialog_btn_negative?.visibility = if (isVisible) View.VISIBLE else View.GONE
    }

    fun showPositive(isVisible: Boolean) {
        dialogView?.dialog_btn_positive?.visibility = if (isVisible) View.VISIBLE else View.GONE
    }


    fun hideDialog() {
        dialog?.hide()
    }


    fun setCancelable(isCancelable: Boolean) {
        dialog?.setCancelable(isCancelable)
    }


    abstract fun onNegativeBtnClick(dialog: Dialog?)
    abstract fun onPositiveBtnClick(dialog: Dialog?)

}
