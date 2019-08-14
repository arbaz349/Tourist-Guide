package net.com.firebaseauth;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Journey  extends Fragment implements View.OnClickListener {
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_journey,container,false);
        ImageView flight = (ImageView) view.findViewById(R.id.flight);
        flight.setOnClickListener(this);

        ImageView rail = (ImageView) view.findViewById(R.id.rail);
        rail.setOnClickListener(this);

        ImageView dist = (ImageView) view.findViewById(R.id.dist);
        dist.setOnClickListener(this);

        TextView t = view.findViewById(R.id.textView);
        t.setOnClickListener(this);

        TextView t1 = view.findViewById(R.id.textView1);
        t1.setOnClickListener(this);

        TextView t2 = view.findViewById(R.id.textView2);
        t2.setOnClickListener(this);

        return  view;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.flight:
                Intent in = new Intent(getContext(), flight.class);
                startActivity(in);
                // do your code
                break;

            case R.id.textView:
                Intent in1 = new Intent(getContext(), flight.class);
                startActivity(in1);
                // do your code
                break;

            case R.id.rail:
                Intent ine = new Intent(getContext(), rail.class);
                startActivity(ine);
                // do your code
                break;

            case R.id.textView1:
                Intent ine1 = new Intent(getContext(), rail.class);
                startActivity(ine1);
                // do your code
                break;

            case R.id.dist:
                Intent intent=new Intent(getContext(),dist.class);
                startActivity(intent);
                break;

            case R.id.textView2:
                Intent intent1=new Intent(getContext(),dist.class);
                startActivity(intent1);
                break;
        }
    }
}
