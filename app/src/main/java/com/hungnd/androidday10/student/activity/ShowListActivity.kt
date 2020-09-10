package com.hungnd.androidday10.student.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.hungnd.androidday10.R
import com.hungnd.androidday10.student.interfaceff.ItemsClick
import com.hungnd.androidday10.student.adapter.ShowListAdapter
import com.hungnd.androidday10.student.model.ShowListModel
import kotlinx.android.synthetic.main.activity_show_list.*
import java.util.ArrayList

class ShowListActivity : AppCompatActivity(), ItemsClick {
    lateinit var viewDialog: View
    lateinit var viewEditDialog: View
    lateinit var alertDialog: AlertDialog
    lateinit var alerEdittDialog: AlertDialog
    private val dataList = ArrayList<ShowListModel>()
    var getPosition: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)
        setRecycleView()
        initData()
    }

    private fun initData() {
        btn_Add.setOnClickListener { alertDialog.show() }
        viewDialog = LayoutInflater.from(this).inflate(R.layout.items_dialog_add_student, null)
        viewEditDialog = LayoutInflater.from(this).inflate(R.layout.items_dialog_edit_student, null)
        createDialog()
    }

    private fun setRecycleView() {
        rcv_Show_List.setHasFixedSize(true)
        val adapter = ShowListAdapter(dataList, this, this)
        rcv_Show_List.adapter = adapter
        adapter.notifyDataSetChanged()
    }


    private fun createDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setView(viewDialog)
        builder.setTitle("ADD STUDENT")
        val btnCancle = viewDialog.findViewById<Button>(R.id.btn_Dialog_Cancle)
        val btnAdd = viewDialog.findViewById<Button>(R.id.btn_Dialog_Add)
        btnCancle.setOnClickListener { alertDialog.dismiss() }
        btnAdd.setOnClickListener {
            var fullName = viewDialog.findViewById<EditText>(R.id.edt_Dialog_Add_Name)
            var getFullName = fullName.text ?: ""
            var subject = viewDialog.findViewById<EditText>(R.id.edt_Dialog_Add_Subject)
            var getSubject = subject.text ?: ""
            var score = viewDialog.findViewById<EditText>(R.id.edt_Dialog_Add_Score)
            var getScore = score.text ?: ""
            if (TextUtils.isEmpty(getFullName.toString())) {
                Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(getSubject.toString())) {
                Toast.makeText(this, "Please Enter your subject", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(getScore.toString())) {
                Toast.makeText(this, "Please Enter your score", Toast.LENGTH_SHORT).show()
            } else {
                val showList = ShowListModel()
                showList.tvShowName = getFullName.toString()
                showList.tvScore = getScore.toString()
                showList.tvSubject = getSubject.toString()
                dataList.add(showList)
                setRecycleView()
                alertDialog.dismiss()
                fullName.text = null
                subject.text = null
                score.text = null
            }
        }
        alertDialog = builder.create()


    }

    private fun createEditDialog(model: ShowListModel, position: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setView(viewEditDialog)
        builder.setTitle("EDIT STUDENT")
        val btnCancle = viewEditDialog.findViewById<Button>(R.id.btn_Dialog_Edit_Cancel)
        val btnUpdate = viewEditDialog.findViewById<Button>(R.id.btn_Dialog_Update)
        var editFullName = viewEditDialog.findViewById<EditText>(R.id.edt_Dialog_Edit_Name)
        var editSubject = viewEditDialog.findViewById<EditText>(R.id.edt_Dialog_Edit_Subject)
        var editScore = viewEditDialog.findViewById<EditText>(R.id.edt_Dialog_Edit_Score)
        editFullName.setText(model.tvShowName)
        editSubject.setText(model.tvSubject)
        editScore.setText(model.tvScore)


        btnCancle.setOnClickListener { builder.setCancelable(true) }
        btnUpdate.setOnClickListener {

            when {
                TextUtils.isEmpty(editFullName.text.toString()) -> {
                    Toast.makeText(this, "Please Enter your name", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(editSubject.text.toString()) -> {
                    Toast.makeText(this, "Please Enter your subject", Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(editScore.text.toString()) -> {
                    Toast.makeText(this, "Please Enter your score", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    val modeUpdate = ShowListModel()
                    modeUpdate.tvShowName = editFullName.text.toString()
                    modeUpdate.tvSubject = editSubject.text.toString()
                    modeUpdate.tvScore = editScore.text.toString()
                    dataList[position] = modeUpdate
                    setRecycleView()
                    builder.setCancelable(true)
                    editFullName.text = null
                    editSubject.text = null
                    editScore.text = null
                }
            }
        }
        builder.create().show()
    }

    override fun onItemsClick(position: Int) {
        Toast.makeText(this, " Click", Toast.LENGTH_SHORT).show()
        val model = dataList[position]
        createEditDialog(model, position)
    }

    override fun onLongClickItems(position: Int) {
        Toast.makeText(this, "Long Click", Toast.LENGTH_SHORT).show()
        dataList.removeAt(position)
        setRecycleView()
    }
}