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

public class Register extends AppCompatActivity {
    EditText mFullName,mEmail,mPassword;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final AutoCompleteTextView spinner=findViewById(R.id.spinner);

        mFullName = findViewById(R.id.name);
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mRegisterBtn = findViewById(R.id.button);
        mLoginBtn = findViewById(R.id.already);
        ImageView imageView =findViewById(R.id.imagevieww);

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Departments);
        spinner.setAdapter(adapter);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.showDropDown();
            }
        });


        fAuth=FirebaseAuth.getInstance();

        if(fAuth.getCurrentUser()!=null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
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



                //register the user in firebase

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "User created", Toast.LENGTH_SHORT).show();
                            String s=spinner.getText().toString();
                            if(s.equals("CSE")){
                                startActivity(new Intent(getApplicationContext(),Cse.class));
                            }
                            if(s.equals("ECE")){
                                startActivity(new Intent(getApplicationContext(),Ece.class));
                            }
                            if(s.equals("IT")){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                            if(s.equals("EEE")){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                            if(s.equals("MECH")){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }
                            if(s.equals("CIVIL")){
                                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            }

                        }
                        else {
                            Toast.makeText(Register.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
    private static final String[] Departments=new String[]{"CSE","IT","ECE","EEE","MECH","CIVIL"};
}