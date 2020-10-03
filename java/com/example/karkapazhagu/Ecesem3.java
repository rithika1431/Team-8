package com.example.karkapazhagu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Ecesem3 extends AppCompatActivity {

    String [] subject={"MA8352 - Linear Algebra and Partial Differential Equations","EC8393 - Fundamentals of Data Structures in C","EC8351 - Electronic Circuits - I",
            "EC8352 - Signals and Systems","EC8392 - Digital Electronics",
            "EC8391 - Control Systems Engineering"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecesem3);
        listView = (findViewById(R.id.listview1));
        CustomAdapter c = new CustomAdapter();
        listView.setAdapter(c);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    startActivity(new Intent(getApplicationContext(), Csesem1sub1.class));

                }
                if (position == 1) {
                    startActivity(new Intent(getApplicationContext(), csesem1sub2.class));

                }
                if (position == 2) {
                    startActivity(new Intent(getApplicationContext(), Csesem1sub3.class));

                }
                if (position == 3) {
                    startActivity(new Intent(getApplicationContext(), Csesem1sub4.class));

                }
                if (position == 4) {
                    startActivity(new Intent(getApplicationContext(), Csesem1sub5.class));

                }
                if (position == 5) {
                    startActivity(new Intent(getApplicationContext(), Csesem1sub6.class));

                }

            }
        });
    }





    class  CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return subject.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v=getLayoutInflater().inflate(R.layout.mylayout1,null);
            TextView t=v.findViewById(R.id.subject);
            t.setText(subject[position]);
            return  v;
        }
    }

}