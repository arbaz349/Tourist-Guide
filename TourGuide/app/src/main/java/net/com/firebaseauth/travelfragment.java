package net.com.firebaseauth;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class travelfragment extends Fragment {
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_travel,container,false);
        imageView=view.findViewById(R.id.imageView);
        Intent intent = new Intent(getContext(),MapsActivity.class);
        startActivity(intent);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Current Location", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),MapsActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
