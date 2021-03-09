 package com.example.swapnil.eleghart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

 public class RegisterScreen extends AppCompatActivity {
    EditText New_UserName_1, New_Email_1,New_Phonenumber_1,NewPassword_1,ReEnteredPassword_1;
    TextView nuser,nemail,nphone,npass,nrepass;
    ImageView image1,image2;
    Button regbutton;
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        New_UserName_1 = (EditText)findViewById(R.id.New_UserName);
        New_Email_1 = (EditText)findViewById(R.id.New_Email);
        New_Phonenumber_1 = (EditText)findViewById(R.id.New_Phonenumber);
        NewPassword_1 = (EditText)findViewById(R.id.NewPassword);
        ReEnteredPassword_1= (EditText)findViewById(R.id.ReEnteredPassword);

        regbutton=(Button)findViewById(R.id.registerbutton);

        image1 = (ImageView)findViewById(R.id.pass);
        image2 = (ImageView)findViewById(R.id.repassimg);

        nuser=(TextView)findViewById(R.id.nouser);
        nuser.setVisibility(View.INVISIBLE);
        nemail =(TextView)findViewById(R.id.noemail);
        nemail.setVisibility(View.INVISIBLE);
        nphone =(TextView)findViewById(R.id.nophone);
        nphone.setVisibility(View.INVISIBLE);
        npass =(TextView)findViewById(R.id.nopassword);
        npass.setVisibility(View.INVISIBLE);
        nrepass=(TextView)findViewById(R.id.norepass);
        nrepass.setVisibility(View.INVISIBLE);

    }


     public void passshoworhide(View v)
     {
         int position =NewPassword_1.length();
         if ( flag == true)
         {
             image1.setImageResource(R.drawable.user_final_3);
             flag= false;
             NewPassword_1.setTransformationMethod(PasswordTransformationMethod.getInstance());
             NewPassword_1.setSelection(position);

         }
         else
         {
             image1.setImageResource(R.drawable.user_final_4);
             flag= true;
             NewPassword_1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
             NewPassword_1.setSelection(position);

         }

     }

     public void repassshoworhide(View v)
     {
         int position =ReEnteredPassword_1.length();
         if ( flag == true)
         {
             image2.setImageResource(R.drawable.user_final_3);
             flag= false;
             ReEnteredPassword_1.setTransformationMethod(PasswordTransformationMethod.getInstance());
             ReEnteredPassword_1.setSelection(position);

         }
         else
         {
             image2.setImageResource(R.drawable.user_final_4);
             flag= true;
             ReEnteredPassword_1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
             ReEnteredPassword_1.setSelection(position);

         }

     }

    public void submitregister(View v)
    {
        String user= New_UserName_1.getText().toString();
        String email= New_Email_1.getText().toString();
        String phone= New_Phonenumber_1.getText().toString();
        String password=NewPassword_1.getText().toString();
        String repass= ReEnteredPassword_1.getText().toString();

        if (password.equals(repass))
        {
            Toast.makeText(this.getApplicationContext(),"Password Matched!!",Toast.LENGTH_LONG).show();
        }
//  UserName
            if(user.isEmpty())
            {
                nuser.setVisibility(View.VISIBLE);
            }
            else
            {
                nuser.setVisibility(View.INVISIBLE);
            }
//  Email
        if(email.isEmpty())
        {
            nemail.setVisibility(View.VISIBLE);
        }
        else
        {
            nemail.setVisibility(View.INVISIBLE);
        }

//  Phone Number
        if(phone.isEmpty())
        {
            nphone.setVisibility(View.VISIBLE);
        }
        else
        {
            nphone.setVisibility(View.INVISIBLE);
        }

//  Password
        if(password.isEmpty())
        {
            npass.setVisibility(View.VISIBLE);
        }
        else
        {
            npass.setVisibility(View.INVISIBLE);
        }

//  Re-Passowrd
        if(repass.isEmpty())
        {
            nrepass.setVisibility(View.VISIBLE);
        }
        else
        {
            nrepass.setVisibility(View.INVISIBLE);
        }


    }
}
