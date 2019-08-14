package net.com.firebaseauth;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class activity_whether extends AppCompatActivity {

    TextView t1_temp, t2_city, t3_description, t4_date;
    ImageView imageView;
    String city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whether);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        city=getIntent().getStringExtra("key");
        ab.setTitle(city+" City Weather");
        t1_temp = (TextView) findViewById(R.id.textView);
        t2_city = (TextView) findViewById(R.id.textView3);
        t3_description = (TextView) findViewById(R.id.textView4);
        t4_date = (TextView) findViewById(R.id.textView2);
        imageView = (ImageView) findViewById(R.id.imageView);

        find_weather(city);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        if(item.getItemId()==android.R.id.home)
        {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void find_weather(String city) {
      /*  LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        String provider = lm.getBestProvider(new Criteria(), false);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location lc = lm.getLastKnownLocation(provider);
        Double lat = lc.getLatitude();
        Double lon = lc.getLongitude();
        String url ="https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=e8074c11d494be4cfdae854ea09e9b89&units=Imperial";*/
        String url ="https://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e8074c11d494be4cfdae854ea09e9b89&units=Imperial";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject object = array.getJSONObject(0);
                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");


                    t2_city.setText(city);
                    t3_description.setText(description.toUpperCase());

                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                    String formatted_date = sdf.format(calendar.getTime());

                    t4_date.setText(formatted_date);

                    double temp_int = Double.parseDouble(temp);
                    double centi = (temp_int - 32) /1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;
                    t1_temp.setText(String.valueOf(i));

                    if(description.contains("broken clouds"))
                        imageView.setImageResource(R.drawable.icon_brokenclouds);

                    if(description.contains("sunny"))
                        imageView.setImageResource(R.drawable.icon_clearsky);

                    if(description.contains("rain"))
                        imageView.setImageResource(R.drawable.icon_rain);

                    if(description.contains("mist"))
                        imageView.setImageResource(R.drawable.icon_mist);

                    if(description.contains("few cloud"))
                        imageView.setImageResource(R.drawable.icon_fewclouds);

                    if(description.contains("scattered clouds")||description.contains("haze"))
                        imageView.setImageResource(R.drawable.icon_scatteredclouds);

                    if(description.contains("shower rain"))
                        imageView.setImageResource(R.drawable.icon_showerrain);

                    if(description.contains("snow"))
                        imageView.setImageResource(R.drawable.icon_snow);

                    if(description.contains("thunderstorm"))
                        imageView.setImageResource(R.drawable.icon_thunderstorm);


                }catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);


    }



}
