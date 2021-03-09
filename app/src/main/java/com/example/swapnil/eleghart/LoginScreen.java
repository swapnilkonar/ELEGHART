package com.example.swapnil.eleghart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginScreen extends AppCompatActivity {
    EditText username_1,pasword_1;
    TextView view_1,view_2,view_3, npass,nuser;
    ImageView image;
    boolean flag = false;
    ProgressBar progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        view_1 = (TextView)findViewById(R.id.new2);
        view_2 = (TextView)findViewById(R.id.textView2);
        username_1 = (EditText)findViewById(R.id.UserName);
        pasword_1 = (EditText)findViewById(R.id.Password);
        image = (ImageView)findViewById(R.id.showpassword);
        npass=(TextView)findViewById(R.id.nopassword);
        npass.setVisibility(View.INVISIBLE);
        nuser=(TextView)findViewById(R.id.nousername);
        nuser.setVisibility(View.INVISIBLE);
        progressbar=(ProgressBar)findViewById(R.id.progressBar) ;
        progressbar.setVisibility(View.INVISIBLE);


    }

    public void showorhide(View v)
    {
        int position =pasword_1.length();
        if ( flag == true)
        {
            image.setImageResource(R.drawable.user_final_3);
            flag= false;
            pasword_1.setTransformationMethod(PasswordTransformationMethod.getInstance() )  ;
            pasword_1.setSelection(position);
        }
        else
        {
            image.setImageResource(R.drawable.user_final_4);
            flag= true;
            pasword_1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            pasword_1.setSelection(position);
        }

    }

    public void Login(View v)
    {
        String username= username_1.getText().toString();
        String password= pasword_1.getText().toString();

        //-------------- WHEN USERNAME AND PASSWORD ENTERED FOR LOGIN ------------------
        if(username.equals("swapnilkonar45@gmail.com") && password.equals("Swapnil756"))
        {
            // PROGRESS_BAR VISIBILITY
            progressbar.setVisibility(View.VISIBLE);
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {

                @Override

                public void run() {

                    Intent homeIntent = new Intent(LoginScreen.this, HomePageUser.class);
                    startActivity(homeIntent);
                    progressbar.setVisibility(View.INVISIBLE);

                }

            }, 1000);

        }

        //-----------------------------WHEN ENTERED USERNAME OR PASSWORD IS WRONG -------------------------------------
        else if(username!=("swapnilkonar45@gmail.com") || password!=("Swapnil756") && username!=null && password!=null)
        {
            Toast.makeText(this.getApplicationContext(),"Your Username Or Password is Wrong!!",Toast.LENGTH_LONG).show();
        }

        // -----------------------------WHEN USERNAME OR PASSWORD IS NOT ENTERED ------------------------------------
        //  Username
        if(username.isEmpty())
        {
            nuser.setVisibility(View.VISIBLE);
        }
        else
        {
            nuser.setVisibility(View.INVISIBLE);
        }

        // Password
        if(password.isEmpty())
        {
            npass.setVisibility(View.VISIBLE);
        }
        else
        {
            npass.setVisibility(View.INVISIBLE);
        }
//---------- WHEN PASSWORD ENTERED IS MORE THAN 10 CHARACTERS
        if(pasword_1.getText().length()>10)
        {
            Toast.makeText(this.getApplicationContext(),"You Can only enter password of length 10, kindly click on Forgot password if needed!!!",Toast.LENGTH_LONG).show();
        }
    }

    // --- WHEN REGISTER BUTTON IS CLICKED
    public void register (View v)
    {
        Intent homeIntent = new Intent(LoginScreen.this, RegisterScreen.class);
        startActivity(homeIntent);

    }


//    public void forgot(View v)
//    {
//        Intent homeIntent = new Intent(LoginScreen.this, ForgotScreen.class);
//        startActivity(homeIntent);
//        finish();
//    }


}
