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

public class It extends AppCompatActivity {

    String [] name={"Sem I","Sem II","Sem III","Sem IV","Sem V","Sem VI","Sem VII","Sem VIII"};
    int [] myimages={R.drawable.itsem1,R.drawable.itsem2,R.drawable.itsem3,R.drawable.itsem4,R.drawable.itsem5,R.drawable.itsem6,
            R.drawable.itsem7,R.drawable.itsem8};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_it);

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
                    startActivity(new Intent(getApplicationContext(),Itsem2.class));
                }
                if(position==2){
                    startActivity(new Intent(getApplicationContext(),Itsem3.class));
                }
                if(position==3){
                    startActivity(new Intent(getApplicationContext(),Itsem4.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(),Itsem5.class));
                }
                if(position==5){
                    startActivity(new Intent(getApplicationContext(),Itsem6.class));
                }
                if(position==6){
                    startActivity(new Intent(getApplicationContext(),Itsem7.class));
                }
                if(position==7){
                    startActivity(new Intent(getApplicationContext(),Itsem8.class));
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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.logout) {

            Toast.makeText(It.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
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