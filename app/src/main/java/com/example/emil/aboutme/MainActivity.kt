package com.example.emil.aboutme

import android.content.Context
import android.inputmethodservice.InputMethodService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.emil.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        initailComponent()
    }

    private fun addNickname(view: View) {
        /* replace by binding
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
*/
        binding.nicknameText.text = binding.nicknameEdit.text
        binding.nicknameEdit.visibility = View.GONE
        view.visibility = View.GONE
        binding.nicknameText.visibility = View.VISIBLE

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private val doneButtom_click = View.OnClickListener {
        addNickname(it)
    }

    private fun initailComponent() {
//        editText = findViewById(R.id.nickname_edit)
//        nicknameTextView = findViewById(R.id.nickname_text)
//        doneButtom = findViewById(R.id.done_button)
//        doneButtom.setOnClickListener(doneButtom_click)
        binding.doneButton.setOnClickListener(doneButtom_click)

    }

//    lateinit var editText: EditText
//    lateinit var nicknameTextView: TextView
//    lateinit var doneButtom: Button
    private lateinit var binding: ActivityMainBinding



}