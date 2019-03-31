package com.elstrider.roomwordsample

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class NewWordActivity : AppCompatActivity() {

    private lateinit var editWordView: EditText
    private lateinit var editTextText: EditText

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        editWordView = findViewById(R.id.edit_word)
        editTextText = findViewById(R.id.edit_text)

        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editWordView.text) && TextUtils.isEmpty(editTextText.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = editWordView.text.toString()
                val text = editTextText.text.toString()
                replyIntent
                    .putExtra(WORD_REPLY, word)
                    .putExtra(TEXT_REPLY, text)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()
        }
    }

    companion object {
        const val WORD_REPLY = "com.example.android.wordlistsql.WORD_REPLY"
        const val TEXT_REPLY = "com.example.android.wordlistsql.TEXT_REPLY"
    }
}
