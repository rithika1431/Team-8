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

public class Mech extends AppCompatActivity {

    String [] name={"Sem I","Sem II","Sem III","Sem IV","Sem V","Sem VI","Sem VII","Sem VIII"};
    int [] myimages={R.drawable.mechsem1,R.drawable.mechsem2,R.drawable.mechsem3,R.drawable.mechsem4,R.drawable.mechsem5,R.drawable.mechsem6,
            R.drawable.mechsem7,R.drawable.mechsem8};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech);

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
                    startActivity(new Intent(getApplicationContext(),Mechsem2.class));
                }
                if(position==2){
                    startActivity(new Intent(getApplicationContext(),Mechsem3.class));
                }
                if(position==3){
                    startActivity(new Intent(getApplicationContext(),Mechsem4.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(),Mechsem5.class));
                }
                if(position==5){
                    startActivity(new Intent(getApplicationContext(),Mechsem6.class));
                }
                if(position==6){
                    startActivity(new Intent(getApplicationContext(),Mechsem7.class));
                }
                if(position==7){
                    startActivity(new Intent(getApplicationContext(),Mechsem8.class));
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