package com.cst2335.ahla0004;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is the first page of the application
 *
 * @author 16139
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    /**
     * Shows the complexity of the password
     */

    private TextView txtvw;

    /**
     * Here you tell the password
     */

    private EditText edtxt;

    /**
     *
     * The button required to log in the password
     */

    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txtvw = findViewById(R.id.textView);
        EditText edtxt = findViewById(R.id.editTextTextPassword);
        Button bt = findViewById(R.id.bt);

        bt.setOnClickListener( clk ->{
            String password = edtxt.getText().toString();


            checkPasswordComplexity( password );
            if (checkPasswordComplexity(password)) {
                txtvw.setText("Password meets the requirements");
            } else {
                checkPasswordComplexity(password);
                if (checkPasswordComplexity(password)) {
                    txtvw.setText("Password meets the requirements");
                } else {
                    txtvw.setText("You shall not pass!");
                }
                ;
            }
        });


    }

    /** This function...
     *The String that is being checked while typing the password
     * @param psd
     *
     * @return Returns true if ...
     */
     boolean checkPasswordComplexity(String psd) {
         boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;

         foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;

         //for loop here

         for (int i = 0; i < psd.length(); i++) {
             char c = psd.charAt(i);
             if (Character.isUpperCase(c)) {
                 foundUpperCase = true;
             } else if (Character.isLowerCase(c)) {
                 foundLowerCase = true;
             } else if (isSpecialCharacter(c)) {
                 foundSpecial = true;
             } else if (Character.isDigit(c)) {
                 foundNumber = true;
             } else if (Character.isDigit(c)) {
                 foundNumber = true;
             }
         }
         if (!foundUpperCase) {
             Context cntxt = getApplicationContext();
             CharSequence test = "Missing uppercase";
             int duration = Toast.LENGTH_LONG;

             Toast tst = Toast.makeText(cntxt, test, duration); //it says that they are missing uppercase
             tst.show();
             return false;
         } else if (!foundLowerCase) {
             Context cntxt = getApplicationContext();
             CharSequence test = "Missing Lowercase";
             int duration = Toast.LENGTH_LONG;

             Toast.makeText(cntxt, test, duration); //it says that they are missing lowercase

             return false;
         } else if (!foundNumber) {
             Context cntxt = getApplicationContext();
             CharSequence test = "Missing Number";
             int duration = Toast.LENGTH_LONG;
             Toast tst = Toast.makeText(cntxt, test, duration); //it says that they are missing number

             tst.show();
             return false;
         } else if (!foundSpecial) {
             Context cntxt = getApplicationContext();
             CharSequence test = "Missing special characters";
             int duration = Toast.LENGTH_LONG;

             Toast tst = Toast.makeText(cntxt, test, duration); //it says that they are missing special characters
             tst.show();
             return false;
         } else
             return true; //if every condition is true

     }
    boolean isSpecialCharacter(char c) {
         switch (c) {
             case '#':
             case '$':
             case '*':
             case '%':
             case '^':
             case '&':
             case '!':
             case '@':
             case '?':
                 return true;
             default:
                 return false;

         }
    }
    }