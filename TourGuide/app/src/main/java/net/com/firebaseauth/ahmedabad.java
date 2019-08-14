package net.com.firebaseauth;

import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

public class ahmedabad extends AppCompatActivity implements View.OnClickListener , GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private double currentLatitude;
    private double currentLongitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahmedabad);

        mGoogleApiClient = new GoogleApiClient.Builder(this).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(LocationServices.API).build();

        // Create the LocationRequest object
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds


        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        TextView name = (TextView) findViewById(R.id.name);
        name.setOnClickListener(this);

        TextView infp = (TextView) findViewById(R.id.infp);
        infp.setOnClickListener(this);

        TextView mon = (TextView) findViewById(R.id.mon);
        mon.setOnClickListener(this);

        TextView hang = (TextView) findViewById(R.id.hang);
        hang.setOnClickListener(this);

        TextView shop = (TextView) findViewById(R.id.shop);
        shop.setOnClickListener(this);

        TextView rest = (TextView) findViewById(R.id.rest);
        rest.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.name:
                // do your code
                Intent i = new Intent(this, ahmedabadloc.class);
                startActivity(i);
                break;

            case R.id.infp:
                Intent in = new Intent(this, ahminfo.class);
                startActivity(in);
                // do your code
                break;

            case R.id.mon:
                Intent intent=new Intent(this,ahmmon.class);
                startActivity(intent);
                // do your code
                break;

            case R.id.hang:
                Intent intm =new Intent(this,ahmhang.class);
                startActivity(intm);
                // do your code
                break;

            case R.id.shop:
                Intent inte=new Intent(this,ahmshop.class);
                startActivity(inte);
                // do your code
                break;

            case R.id.rest:
                Intent inten=new Intent(this,ahmrest.class);
                startActivity(inten);
                // do your code
                break;

        }
    }

        @Override
        public boolean onOptionsItemSelected(MenuItem item){

            if(item.getItemId()==android.R.id.home)
            {
                finish();
            }
            return super.onOptionsItemSelected(item);
        }
    @Override
    protected void onResume() {
        super.onResume();
        //Now lets connect to the API
        mGoogleApiClient.connect();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(this.getClass().getSimpleName(), "onPause()");

        //Disconnect from API onPause()
        if (mGoogleApiClient.isConnected()) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, (LocationListener) this);
            mGoogleApiClient.disconnect();
        }


    }

    /**
     * If connected get lat and long
     */
    @Override
    public void onConnected(Bundle bundle) {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

        if (location == null) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, (LocationListener) this);

        } else {
            //If everything went fine lets get latitude and longitude
            currentLatitude = location.getLatitude();
            currentLongitude = location.getLongitude();

            float result ;
            Location lc = new Location("Ahmedabad");
            lc.setLatitude(23.0225);
            lc.setLongitude(72.5714);
            result=location.distanceTo(lc);
            result = result/1000;
            // location.distanceBetween(currentLatitude, currentLongitude, 18.5104, 73.8567, result);
            TextView tv = (TextView) findViewById(R.id.dist);
            String str = String.valueOf("Distance - "+result+" KM");
            tv.setText(str);
        }
    }


    @Override
    public void onConnectionSuspended(int i) {
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        /*
         * Google Play services can resolve some errors it detects.
         * If the error has a resolution, try sending an Intent to
         * start a Google Play services activity that can resolve
         * error.
         */
        if (connectionResult.hasResolution()) {
            try {
                // Start an Activity that tries to resolve the error
                connectionResult.startResolutionForResult(this, CONNECTION_FAILURE_RESOLUTION_REQUEST);
                /*
                 * Thrown if Google Play services canceled the original
                 * PendingIntent
                 */
            } catch (IntentSender.SendIntentException e) {
                // Log the error
                e.printStackTrace();
            }
        } else {
            /*
             * If no resolution is available, display a dialog to the
             * user with the error.
             */
            Log.e("Error", "Location services connection failed with code " + connectionResult.getErrorCode());
        }
    }

    /**
     * If locationChanges change lat and long
     *
     *
     * @param location
     */
    @Override
    public void onLocationChanged(Location location) {
        currentLatitude = location.getLatitude();
        currentLongitude = location.getLongitude();

        float result ;
        Location lc = new Location("Ahmedabad");
        lc.setLatitude(18.5104);
        lc.setLongitude(73.8567);
        result=location.distanceTo(lc);
        result = result/1000;
        // location.distanceBetween(currentLatitude, currentLongitude, 18.5104, 73.8567, result);
        TextView tv = (TextView) findViewById(R.id.dist);
        String str = String.valueOf("Distance - "+result+" KM");
        tv.setText(str);
    }

}