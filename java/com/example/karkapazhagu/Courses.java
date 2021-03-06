package com.example.karkapazhagu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {
    
    private RecyclerView recyclerView;

   
    private RecyclerView.Adapter adapter;
 
    private DatabaseReference mDatabase;

    private ProgressDialog progressDialog;

   
    private List<upload_intern> uploads;

    public class Constantsc {

        public static final String STORAGE_PATH_UPLOADS = "course/";
        public static final String DATABASE_PATH_UPLOADS = "course";
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        progressDialog = new ProgressDialog(this);

        uploads = new ArrayList<>();

       
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference(Constantsc.DATABASE_PATH_UPLOADS);

        
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                
                progressDialog.dismiss();

               
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    upload_intern upload = postSnapshot.getValue(upload_intern.class);
                    uploads.add(upload);
                }
               
                adapter = new My_intern(getApplicationContext(), uploads);

               
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                progressDialog.dismiss();
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Upload_course.class));
            }
        });

    }

}
