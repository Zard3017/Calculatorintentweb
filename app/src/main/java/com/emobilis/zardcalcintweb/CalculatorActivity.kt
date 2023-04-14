package com.emobilis.zardcalcintweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class CalculatorActivity : AppCompatActivity() {
    lateinit var Tv_answer:TextView
    lateinit var Edt_firstnumber:EditText
    lateinit var Edt_secondnumber:EditText
    lateinit var Buttonadd:Button
    lateinit var Buttonsubtract:Button
    lateinit var Buttonmultiply:Button
    lateinit var Buttondivide:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        Tv_answer=findViewById(R.id.Txt_answer)
        Edt_firstnumber=findViewById(R.id.Edt_Fnum)
        Edt_secondnumber=findViewById(R.id.Edt_Snum)
        Buttonadd=findViewById(R.id.Btn_add)
        Buttonsubtract=findViewById(R.id.Btn_subtract)
        Buttonmultiply=findViewById(R.id.Btn_multiply)
        Buttondivide=findViewById(R.id.Btn_divide)

        Buttonadd.setOnClickListener {
            var myfirstnumber=Edt_firstnumber.text.toString()
            var mysecondnumber=Edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Fill in all inputs"
            }else{
                // lets calculate
                var answer=myfirstnumber.toDouble()+mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
        Buttonsubtract.setOnClickListener {
            var myfirstnumber=Edt_firstnumber.text.toString()
            var mysecondnumber=Edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text=" Fill in all inputs"
            }else{
                // lets calculate
                var answer=myfirstnumber.toDouble()-mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
        Buttonmultiply.setOnClickListener {
            var myfirstnumber=Edt_firstnumber.text.toString()
            var mysecondnumber=Edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Fill in all inputs"
            }else{
                //lets calculate
                var answer=myfirstnumber.toDouble()*mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }
        Buttondivide.setOnClickListener {
            var myfirstnumber=Edt_firstnumber.text.toString()
            var mysecondnumber=Edt_secondnumber.text.toString()
            if (myfirstnumber.isEmpty() && mysecondnumber.isEmpty()){
                Tv_answer.text="Fill in all inputs"
            }else{
                // lets calculate
                var answer=myfirstnumber.toDouble() / mysecondnumber.toDouble()
                Tv_answer.text=answer.toString()
            }
        }

    }
}