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

public class Ece extends AppCompatActivity {

    String [] name={"Sem I","Sem II","Sem III","Sem IV","Sem V","Sem VI","Sem VII","Sem VIII"};
    int [] myimages={R.drawable.ecesem1,R.drawable.ecesem2,R.drawable.ecesem3,R.drawable.ecesem4,R.drawable.ecesem5,R.drawable.ecesem6,
            R.drawable.ecesem7,R.drawable.ecesem8};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece);

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
                    startActivity(new Intent(getApplicationContext(),Ecesem2.class));
                }
                if(position==2){
                    startActivity(new Intent(getApplicationContext(),Ecesem3.class));
                }
                if(position==3){
                    startActivity(new Intent(getApplicationContext(),Ecesem4.class));
                }
                if(position==4){
                    startActivity(new Intent(getApplicationContext(),Ecesem5.class));
                }
                if(position==5){
                    startActivity(new Intent(getApplicationContext(),Ecesem6.class));
                }
                if(position==6){
                    startActivity(new Intent(getApplicationContext(),Ecesem7.class));
                }
                if(position==7){
                    startActivity(new Intent(getApplicationContext(),Ecesem8.class));
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

            Toast.makeText(Ece.this, "Logged out Successfully", Toast.LENGTH_SHORT).show();
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