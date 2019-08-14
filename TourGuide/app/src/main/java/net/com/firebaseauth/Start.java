package net.com.firebaseauth;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Start extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_bar_open, R.string.navigation_bar_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new destinationfragment()).commit();
            navigationView.setCheckedItem(R.id.nav_city);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_city:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new destinationfragment()).commit();
                break;
            case R.id.nav_travel:
                Intent intent = new Intent(this,MapsActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_utility:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new utilityfragment()).commit();
                break;
            case R.id.nav_journey:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Journey()).commit();
                break;
            case R.id.nav_about_us:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new aboutusfragment()).commit();
                break;
            case R.id.nav_signout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this,MainActivity.class));
                Toast.makeText(this, "You have now logged out", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_settings:
                //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                // new settingsfragment()).commit();
                Intent intent1 = new Intent(getBaseContext(),ProfileSettings.class);
                startActivity(intent1);
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}