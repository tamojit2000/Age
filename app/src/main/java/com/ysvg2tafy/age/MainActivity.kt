package com.ysvg2tafy.age


import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast


import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

import java.time.LocalDateTime
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun pick_date(view: View){
        //Snackbar.make(view,"Select DOB",Snackbar.LENGTH_SHORT).show()
        val calendar=Calendar.getInstance()
        val year=calendar.get(Calendar.YEAR)
        val month=calendar.get(Calendar.MONTH)
        val day=calendar.get(Calendar.DAY_OF_YEAR)



        //Toast.makeText(this,current_date.toString(),Toast.LENGTH_LONG).show()
        val dp=DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{view,year,month,dayOfMonth->
                //Toast.makeText(this,year.toString()+" "+month.toString()+" "+dayOfMonth.toString(),Toast.LENGTH_LONG).show()
                val date="${dayOfMonth}/${month+1}/${year}"
                textView.text=date
                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val selected_date_in_min=sdf.parse(date)!!.time/60000
                val current_date_in_min=sdf.parse(sdf.format(System.currentTimeMillis()))!!.time/60000
                val diff_in_min=current_date_in_min-selected_date_in_min

                textView2.text=functions.function(diff_in_min)
                Snackbar.make(view,"Shocking!",Snackbar.LENGTH_SHORT).show()
            }
            ,year
            ,month
            ,day)
        dp.setTitle("Select DOB")
        dp.datePicker.maxDate=Date().time-86400000
        dp.show()

    }
}
