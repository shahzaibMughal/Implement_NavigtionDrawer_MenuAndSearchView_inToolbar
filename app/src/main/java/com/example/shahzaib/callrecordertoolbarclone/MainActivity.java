package com.example.shahzaib.callrecordertoolbarclone;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener
,SearchView.OnQueryTextListener{

    DrawerLayout drawerLayout ;
    NavigationView navigationView;
    TextView searchViewText;
    String userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer_layout);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        searchViewText = findViewById(R.id.searchViewText);


        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        getSupportActionBar().setTitle("Recordings");


        setupNavigationDrawer();

    }


    /*****   Related to navigation Drawer  *****/
    private void setupNavigationDrawer(){
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle
                        (this,
                                drawerLayout,
                                (Toolbar) findViewById(R.id.toolbar),
                                R.string.drawer_open,R.string.drawer_close
                        );
        navigationView.setNavigationItemSelectedListener(this);
        toggle.syncState();
    }
    private void closeDrawer()
    {
        drawerLayout.closeDrawer(GravityCompat.START);
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        closeDrawer();
        Toast.makeText(this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();

        return true;
    }



    /*****   Related to toolbar menu  *****/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("Search...");
        searchView.setOnQueryTextListener(this);

        return true;
    }


    /*****   Related to searchView   *****/
    @Override
    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "User Query:   "+query, Toast.LENGTH_SHORT).show();
        searchViewText.setText("");
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchViewText.setText(newText);
        return false;
    }
}
