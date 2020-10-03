package com.example.karkapazhagu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Eee extends AppCompatActivity {

    String [] name={"Sem I","Sem II","Sem III","Sem IV","Sem V","Sem VI","Sem VII","Sem VIII"};
    int [] myimages={R.drawable.eeesem1,R.drawable.eeesem2,R.drawable.eeesem3,R.drawable.eeesem4,R.drawable.eeesem5,R.drawable.eeesem6,
            R.drawable.eeesem7,R.drawable.eeesem8};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);

        listView=(findViewById(R.id.listview));
        CustomAdapter c=new CustomAdapter();
        listView.setAdapter(c);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getApplicationContext(),Csesem1.class));

                }
                if(position==1){
                    startActivity(new Intent(getApplicationContext(),Eeesem2.class));
                }
                if(position==2){
                    startActivity(new Intent(getApplicationContext(),Eeesem3.class));
                }
                if(position==3){
                    startActivity(new Intent(getApplicationContext(),Eeesem4.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(),Eeesem5.class));
                }
                if(position==5){
                    startActivity(new Intent(getApplicationContext(),Eeesem6.class));
                }
                if(position==6){
                    startActivity(new Intent(getApplicationContext(),Eeesem7.class));
                }
                if(position==7){
                    startActivity(new Intent(getApplicationContext(),Eeesem8.class));
                }

            }
        });





    }
    class  CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myimages.length;
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
            View v=getLayoutInflater().inflate(R.layout.mylayout,null);
            ImageView ima=v.findViewById(R.id.imageview);
            TextView t=v.findViewById(R.id.textview);
            ima.setImageResource(myimages[position]);
            t.setText(name[position]);
            return  v;
        }
    }



}