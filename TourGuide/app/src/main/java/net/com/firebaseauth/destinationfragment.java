package net.com.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class destinationfragment extends Fragment {

    ListView listview;
    int[] images = {R.drawable.pune,R.drawable.mumbai,R.drawable.bangalore,
            R.drawable.delhi,R.drawable.hydrabad,R.drawable.jaipur,
            R.drawable.chennai,R.drawable.ahmedabad,R.drawable.kolkata};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_destination,container,false);
        listview = (ListView) view.findViewById(R.id.listView);
        destadapter adpt = new destadapter();
        listview.setAdapter(adpt);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Toast.makeText(getContext(), "Pune", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),pune.class);
                    startActivity(intent);
                }
                if(position==1) {
                    Toast.makeText(getContext(), "Mumbai", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),mumbai.class);
                    startActivity(intent);
                }
                if(position==2) {
                    Toast.makeText(getContext(), "Bangalore", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),bangalore.class);
                    startActivity(intent);
                }
                if(position==3) {
                    Toast.makeText(getContext(), "Delhi", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),delhi.class);
                    startActivity(intent);
                }
                if(position==4) {
                    Toast.makeText(getContext(), "Hyderabad", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),hyderabad.class);
                    startActivity(intent);
                }
                if(position==5) {
                    Toast.makeText(getContext(), "Jaipur", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),jaipur.class);
                    startActivity(intent);
                }
                if(position==6) {
                    Toast.makeText(getContext(), "Chennai", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),chennai.class);
                    startActivity(intent);
                }
                if(position==7) {
                    Toast.makeText(getContext(), "Ahmedabad", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),ahmedabad.class);
                    startActivity(intent);
                }
                if(position==8) {
                    Toast.makeText(getContext(), "Kolkata", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),kolkata.class);
                    startActivity(intent);
                }
            }
        });
        return view;
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
