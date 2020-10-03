package com.example.karkapazhagu;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {
    EditText mEmail,mPassword;
    Button mLoginBtn;
    TextView mCreateBtn;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final AutoCompleteTextView spinner=findViewById(R.id.spinner);

        mEmail = findViewById(R.id.emailId);
        mPassword=findViewById(R.id.password1);
        fAuth=FirebaseAuth.getInstance();
        mLoginBtn=findViewById(R.id.button1);
        mCreateBtn=findViewById(R.id.already1);
        ImageView imageView =findViewById(R.id.imagevieww);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Departments);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.showDropDown();
            }
        });


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=mEmail.getText().toString().trim();
                String password=mPassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password is Required.");
                    return;
                }

                if(password.length()<6){
                    mPassword.setError("Password Must be >=6");
                    return;
                }


                //authenticate the user

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Login.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                            String s=spinner.getText().toString();
                            if(s.equals("CSE")){
                                startActivity(new Intent(getApplicationContext(),Cse_layout.class));
                            }
                            if(s.equals("ECE")){
                                startActivity(new Intent(getApplicationContext(),Ece_layout.class));
                            }
                            if(s.equals("IT")){
                                startActivity(new Intent(getApplicationContext(),It_layout.class));
                            }
                            if(s.equals("EEE")){
                                startActivity(new Intent(getApplicationContext(),Eee_layout.class));
                            }
                            if(s.equals("MECH")){
                                startActivity(new Intent(getApplicationContext(),Mech_layout.class));
                            }
                            if(s.equals("CIVIL")){
                                startActivity(new Intent(getApplicationContext(),Civil_layout.class));
                            }
                        }
                        else {
                            Toast.makeText(Login.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        mCreateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });
    }
    private static final String[] Departments=new String[]{"CSE","IT","ECE","EEE","MECH","CIVIL"};
}