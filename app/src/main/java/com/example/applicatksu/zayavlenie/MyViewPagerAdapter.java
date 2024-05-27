package com.example.applicatksu.zayavlenie;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.applicatksu.zayavlenie.DokumentsFragment;
import com.example.applicatksu.zayavlenie.DostizheniyFragment;
import com.example.applicatksu.zayavlenie.EkzamenFragment;
import com.example.applicatksu.zayavlenie.Napravlenie_podgotovkiFragment;
import com.example.applicatksu.zayavlenie.ObrazovanieFragment;
import com.example.applicatksu.zayavlenie.Obshchaya_infoFragment;
import com.example.applicatksu.zayavlenie.Personal_infoFragment;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new Obshchaya_infoFragment();
            case 1:
                return new Personal_infoFragment();
            case 2:
                return new ObrazovanieFragment();
            case 3:
                return new Napravlenie_podgotovkiFragment();
            case 4:
                return new EkzamenFragment();
            case 5:
                return new DostizheniyFragment();
            case 6:
                return new DokumentsFragment();
            default:
                return new Obshchaya_infoFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
