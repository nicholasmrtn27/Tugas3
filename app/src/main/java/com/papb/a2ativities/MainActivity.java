package com.papb.a2ativities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG=MainActivity.class.getSimpleName();
    public static final  String EXTRA_MESSAGE="MESSAGE";
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST=1;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_main);
        mReplyTextView=findViewById(R.id.text_message_reply);
    }
    public void launchSecondActivity(View view) {
        String message=mMessageEditText.getText().toString();

        Intent intent=new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==TEXT_REQUEST) {
            if (resultCode==RESULT_OK) {
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyTextView.setText(reply);
            }
        }
    }
}