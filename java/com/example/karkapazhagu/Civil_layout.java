package com.example.karkapazhagu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Civil_layout extends AppCompatActivity {

    CardView notes;
    CardView extra_activity;
    CardView internship;
    CardView course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil_layout);
        notes=findViewById(R.id.notes);
        extra_activity=findViewById(R.id.extra_activity);
        internship=findViewById(R.id.internship);
        course=findViewById(R.id.course);

        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil_layout.this,Civil.class));

            }
        });

        extra_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil_layout.this,Extra_activities.class));

            }
        });

        internship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil_layout.this,Internships.class));

            }
        });

        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil_layout.this,Courses.class));

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.logout) {

            Toast.makeText(Civil_layout.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();

        }
        if(id==R.id.chatbot){
            Intent b = new Intent(Intent.ACTION_VIEW, Uri.parse("https://web-chat.global.assistant.watson.cloud.ibm.com/preview.html?region=eu-gb&integrationID=6fca1f90-dcf7-4da0-ab01-cee80554056e&serviceInstanceID=faf5e2da-0250-446a-8ac6-31e40d6d49a6"));
            startActivity(b);
        }


        return super.onOptionsItemSelected(item);
    }


}