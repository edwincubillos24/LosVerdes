package com.edwinacubillos.losverdes;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

 /*   FragmentManager fm;
    FragmentTransaction ft;*/

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(pagerAdapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {
            }
        };

        ActionBar.Tab tab = actionBar.newTab().setIcon(R.drawable.burguer).setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setIcon(R.drawable.perros).setTabListener(tabListener);
        actionBar.addTab(tab);

        tab = actionBar.newTab().setIcon(R.drawable.chuzos).setTabListener(tabListener);
        actionBar.addTab(tab);

        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            @Override
            public void onPageSelected(int position) {
               getSupportActionBar().setSelectedNavigationItem(position);
            }
        });

    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new HamburguesaFragment();
                case 1: return new PerrosFragment();
                case 2: return new ChuzosFragment();
                default: return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

       // ft = fm.beginTransaction();

        switch (id){
            case R.id.mMiperfil:

                Intent intent = new Intent(this, PerfilActivity.class);
                startActivity(intent);

              /*  Para abrir otro fragment con este menú

                HamburguesaFragment hf = new HamburguesaFragment();
                ft.replace(android.R.id.content, hf).commit();*/

                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
