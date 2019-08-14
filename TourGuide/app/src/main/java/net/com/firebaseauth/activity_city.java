package net.com.firebaseauth;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class activity_city extends AppCompatActivity {

    ListView listview;
    int[] images = {R.drawable.pune,R.drawable.mumbai,R.drawable.bangalore,
            R.drawable.delhi,R.drawable.hydrabad,R.drawable.jaipur,
            R.drawable.chennai,R.drawable.ahmedabad,R.drawable.kolkata};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        listview = (ListView) findViewById(R.id.listView);
        destadapter adpt = new destadapter();
        listview.setAdapter(adpt);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Toast.makeText(activity_city.this, "Pune", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Pune");
                    startActivity(intent);
                }
                if(position==1) {
                    Toast.makeText(activity_city.this, "Mumbai", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Mumbai");
                    startActivity(intent);
                }
                if(position==2) {
                    Toast.makeText(activity_city.this, "Bangalore", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Bangalore");
                    startActivity(intent);
                }
                if(position==3) {
                    Toast.makeText(activity_city.this, "Delhi", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Delhi");
                    startActivity(intent);
                }
                if(position==4) {
                    Toast.makeText(activity_city.this, "Hyderabad", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Hyderabad");
                    startActivity(intent);
                }
                if(position==5) {
                    Toast.makeText(activity_city.this, "Jaipur", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Jaipur");
                    startActivity(intent);
                }
                if(position==6) {
                    Toast.makeText(activity_city.this, "Chennai", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Chennai");
                    startActivity(intent);
                }
                if(position==7) {
                    Toast.makeText(activity_city.this, "Ahmedabad", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Ahmedabad");
                    startActivity(intent);
                }
                if(position==8) {
                    Toast.makeText(activity_city.this, "Kolkata", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(activity_city.this,activity_whether.class);
                    intent.putExtra("key","Kolkata");
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
    class destadapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
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
            View view = getLayoutInflater().inflate(R.layout.list_destination,null);
            ImageView imageview = view.findViewById(R.id.banglore);
            imageview.setImageResource(images[position]);
            return view;
        }
    }
}

