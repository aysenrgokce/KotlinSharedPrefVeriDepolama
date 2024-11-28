package com.aysenurgokce.kotlinveridepolama

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.aysenurgokce.kotlinveridepolama.databinding.ActivityMainBinding


//Kotlin'de SharedPreferences, uygulama içinde küçük verileri (örneğin kullanıcı tercihleri, oturum bilgileri veya ayarlar) kalıcı olarak depolamak için kullanılır.
//Bu veriler anahtar-değer (key-value) çiftleri olarak saklanır ve uygulama kapatılsa bile cihazda kalmaya devam eder.

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var sharedPref : SharedPreferences
    var kullanıcıYasPref : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //sharedPreferences - XMl - Key-value
       sharedPref = getSharedPreferences("com.aysenurgokce.kotlinveridepolama", Context.MODE_PRIVATE)

        kullanıcıYasPref= sharedPref.getInt("yas",-1)
        if (kullanıcıYasPref == -1){
            binding.textView.text = "Your age: "
        }else{
            binding.textView.text = "Your age: ${kullanıcıYasPref}"
        }
    }
    fun saveButton(view: View){
        val kullanıcıYas = binding.editText.text.toString().toIntOrNull()

        if (kullanıcıYas != null){
            binding.textView.text = "Your age: ${kullanıcıYas}"
            sharedPref.edit().putInt("yas",kullanıcıYas).apply()
        }


        /*kullanıcı uygulamayı kapattığı an verilerim gitti.
        val kullanıcıYas = binding.editText.text.toString()
        binding.textView.text = "Your age: ${kullanıcıYas}"*/
    }
    fun deleteButton(view: View){
        kullanıcıYasPref = sharedPref.getInt("yas",-1)

        if (kullanıcıYasPref != -1){
            sharedPref.edit().remove("age").apply()
            binding.textView.text = "your age : "
        }


    }

}