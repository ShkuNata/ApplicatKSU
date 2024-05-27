package com.example.applicatksu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.text.SpannableString;

import com.example.applicatksu.zayavlenie.MyViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;

import com.example.applicatksu.databinding.ActivityZayavlenieBinding;

public class ZayavlenieActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    MyViewPagerAdapter myViewPagerAdapter;

    private ActivityZayavlenieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zayavlenie);

        tabLayout=findViewById(R.id.main_zayavlenie_layuot);
        viewPager2=findViewById(R.id.viewpager);
        myViewPagerAdapter = new MyViewPagerAdapter(this);
        viewPager2.setAdapter(myViewPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }


    private class MainAdapter extends FragmentPagerAdapter {
        // Initialize arrayList
        ArrayList<Fragment> fragmentArrayList= new ArrayList<>();
        ArrayList<String> stringArrayList=new ArrayList<>();

        // Create constructor
        public void addFragment(Fragment fragment,String s)
        {
            // Add fragment
            fragmentArrayList.add(fragment);
            // Add title
            stringArrayList.add(s);
        }

        public MainAdapter(FragmentManager supportFragmentManager) {
            super(supportFragmentManager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            // return fragment position
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            // Return fragment array list size
            return fragmentArrayList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            // Initialize spannable image
            SpannableString spannableString=new SpannableString(""+stringArrayList.get(position));

            // return spannable string
            return spannableString;
        }
    }
}