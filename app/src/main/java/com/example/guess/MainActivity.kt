package com.example.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    val secretnumber = SecretNumber();
    // Main PageLoad 進入點
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 兩種不同版面配置...
        // Constraint Lay Out
         setContentView(R.layout.activity_main)
        // Linear Lay Out
        // setContentView(R.layout.linear_main)

        // Log.d >> Debug 專用
        // this　參數
        // secretnumber secret >> 屬性
        Log.d("MainActivity", "Secret:" + secretnumber.secret);


        /* R.id.hello_main
        R.drawable.pig
        R.string.ok
        R.color.messageColor
        */
    }

    // 自訂 OK_Button 事件
    // import android.view.View
    // view (小寫) 變數 ; View(大寫) 類別
    fun check(view : View) {
        val n : Int = number.text.toString().toInt() // 傳入值 數字
        println("number: $n");
        Log.d("MainActivity", "number:" + n);
        // 輸入值減去隨機值 結果 => 進入判斷
         val diff : Int = secretnumber.validate(n);
         var message : String = "Yes, you get it";
       if (diff < 0) {
            // MainActivity ＞> 放入 this (Context)
            //Toast.makeText(this, "Bigger", Toast.LENGTH_LONG).show();
           message = "Bigger";
        } else if (diff > 0 ) {
            //Toast.makeText( this, "Smaller", Toast.LENGTH_LONG).show();
           message = "Smaller";
        }
        // 要等於0
           //Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        AlertDialog.Builder(this).
            setTitle("Message").
            setMessage(message).
            setPositiveButton("OK", null)
            .show();
    }
}
