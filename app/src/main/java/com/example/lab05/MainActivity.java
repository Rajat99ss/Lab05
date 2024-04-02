package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    TextView pswd= null;
    /** this holds the password enteres*/
    EditText editText=null;
    /** this holds the button*/
    Button login=null;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pswd =findViewById(R.id.textView);
        editText = findViewById(R.id.passwordEditText);
        login = findViewById(R.id.checkButton);

        login.setOnClickListener(clk -> {
            String password = editText.getText().toString();
            boolean isPasswordComplex = checkpassword(password);
            if (isPasswordComplex) {
                pswd.setText("Your password meets the requirements");
            } else {
                pswd.setText("You shall not pass!");
            }

        });


    }

    /**
     * This function check the complexity of the password
     *
     * @param pw the String object that we are checking
     * @return Return True if password fulfill all requirements
     */
    boolean checkpassword(String pw) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)) {
                foundUpperCase = true;
            } else if (Character.isLowerCase(c)) {
                foundLowerCase = true;
            } else if (Character.isDigit(c)) {
                foundNumber = true;
            }
            switch (c) {
                case '#':
                case '$':
                case '%':
                case '^':
                case '&':
                case '*':
                case '!':
                case '@':
                case '?':
                    foundSpecial = true;
            }
        }

        if (!foundUpperCase) {
            Toast.makeText(MainActivity.this, "Missing uppercase", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundLowerCase) {
            Toast.makeText(MainActivity.this, "Missing Lowercase", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundNumber) {
            Toast.makeText(MainActivity.this, "Missing Number", Toast.LENGTH_SHORT).show();
            return false;
        } else if (!foundSpecial) {
            Toast.makeText(MainActivity.this, "Missing Special character", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
       }
    }

}
