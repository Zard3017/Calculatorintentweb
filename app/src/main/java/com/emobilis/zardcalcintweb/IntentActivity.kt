package com.emobilis.zardcalcintweb

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class IntentActivity : AppCompatActivity() {
    lateinit var Buttoncall:Button
    lateinit var Buttondial:Button
    lateinit var Buttonsms:Button
    lateinit var Buttoncamera:Button
    lateinit var Buttonshare:Button
    lateinit var Buttonmpesa:Button
    lateinit var Buttonemail:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        Buttoncall=findViewById(R.id.Btn_Call)
        Buttondial=findViewById(R.id.Btn_dial)
        Buttonsms=findViewById(R.id.Btn_Sms)
        Buttoncamera=findViewById(R.id.Btn_Camera)
        Buttonshare=findViewById(R.id.Btn_Share)
        Buttonmpesa=findViewById(R.id.Btn_Mpesa)
        Buttonemail=findViewById(R.id.Btn_email)

        Buttondial.setOnClickListener {
            val num= "+254786985267"
            val intent=Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",num, null))
            startActivity(intent)
        }
        Buttoncall.setOnClickListener {
            val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "0715645654"))

            if (ContextCompat.checkSelfPermission(this@IntentActivity,
                    android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this@IntentActivity,
                    arrayOf(android.Manifest.permission.CALL_PHONE), 1)
            } else {
                startActivity(intent)
            }


        }
        Buttonsms.setOnClickListener {
            val uri=Uri.parse("smsto:0718790446")
            val intent=Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Body", "how are you")
            startActivity(intent)
        }
        Buttoncamera.setOnClickListener {
            val takePictureIntent=Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent,1)
        }
        Buttonshare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)

            shareIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

            shareIntent.type = "text/plain"

            shareIntent.putExtra(Intent.EXTRA_TEXT, "Hey, download this app!")

            startActivity(shareIntent)

        }
        Buttonmpesa.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")

            simToolKitLaunchIntent?.let { startActivity(it) }


        }
        Buttonemail.setOnClickListener {
            val emailIntent=Intent(Intent.ACTION_SENDTO,Uri.fromParts("Mailto","ianbradley3017@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(Intent.createChooser(emailIntent, "Send email..."))

        }
    }
}