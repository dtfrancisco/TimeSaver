package com.example.timesaver;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        ArrayList<Drawable> icons = new ArrayList<Drawable>();
        listView = (ListView) findViewById(R.id.listView);
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List<PackageInfo> apps = getApplicationContext().getPackageManager().getInstalledPackages(0);
        ArrayList<ItemList> appItems = new ArrayList<ItemList>();
        for(int i=0; i<apps.size(); i++) {
            //if ((apps.get(i).applicationInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) == 0 &&
                    //(apps.get(i).applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
            if (addProcesses(apps.get(i).applicationInfo.processName)) {
                Drawable icon = getPackageManager().getApplicationIcon(apps.get(i).applicationInfo);
                String label = apps.get(i).applicationInfo.loadLabel(getPackageManager()).toString();

                // here
                appItems.add(new ItemList(icon, label, apps.get(i).applicationInfo.processName));
            }
        }
        ListAdapter adapter = new ListAdapter(this, appItems);
        listView.setAdapter(adapter);
    }

    private boolean addProcesses(String processName) {
        List <String> pNames = listOfProcesses(processName);
        if (pNames.contains(processName)) {
            return true;
        }
        return false;
    }

    private List <String> listOfProcesses(String processName) {
        List<String> validPNames = new ArrayList<String>();
        validPNames.add("com.facebook.orca");
        validPNames.add("com.google.android.youtube");
    //    validPNames.add("com.google.android.chrome");

        return validPNames;
    }

    public void onClick(View view) {
        TextView textView = findViewById(R.id.appNameLabel);
        startActivity(new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + "com.google.android.youtube")));
        System.out.println("hi" + (String)view.getTag());
        Toast.makeText(getApplicationContext(), (String)view.getTag(), Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
