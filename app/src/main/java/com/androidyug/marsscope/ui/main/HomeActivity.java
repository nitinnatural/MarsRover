package com.androidyug.marsscope.ui.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.androidyug.marsscope.R;
import com.androidyug.marsscope.common.Constant;
import com.androidyug.marsscope.ui.intro.IntroActivity;
import com.androidyug.marsscope.ui.selectrover.SelectRoverActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Nitin Anand (nitinnatural@gmail.com)
 */

public class HomeActivity extends AppCompatActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isFirstTime = pref.getBoolean(Constant.PREFKEY_FIRST_TIME, true); // default:firstTime true
        if (isFirstTime){
            Intent i = new Intent(this, IntroActivity.class);
            startActivity(i);
            finish();
        }
        fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null){
            fragment = new HomeFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.main_menu, menu);

        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }

}
