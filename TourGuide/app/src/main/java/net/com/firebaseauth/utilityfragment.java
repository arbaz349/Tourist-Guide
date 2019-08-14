package net.com.firebaseauth;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.TextView;
import android.widget.Toast;

public class utilityfragment extends Fragment {
    ListView listview;
    int[] images = {R.drawable.checklist,R.drawable.weather,R.drawable.compass};
    String[]names ={"Check List","Weather Forecast","Compass"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_utility,container,false);
        listview = (ListView) view.findViewById(R.id.listViewutil);
        destadapter adpt = new destadapter();
        listview.setAdapter(adpt);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0) {
                    Toast.makeText(getContext(), "Check List", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),activity_checklist.class);
                    startActivity(intent);
                }
                if(position==1) {
                    Toast.makeText(getContext(), "Weather Forecast", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),activity_city.class);
                    startActivity(intent);
                }
                if(position==2) {
                    Toast.makeText(getContext(), "Compass", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getContext(),activity_compass.class);
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
            View view = getLayoutInflater().inflate(R.layout.list_utilities,null);
            ImageView imageview = view.findViewById(R.id.checklist);
            TextView txtview = view.findViewById(R.id.textView);
            imageview.setImageResource(images[position]);
            txtview.setText(names[position]);
            return view;
        }
    }
}
