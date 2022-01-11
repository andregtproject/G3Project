package com.andregt.g3project.Settings;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andregt.g3project.MainActivity;
import com.andregt.g3project.MainActivity2;
import com.andregt.g3project.R;

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preference_setting,rootKey);

        Preference uiModeSwipe = (Preference) findPreference("mode1_preference");
        uiModeSwipe.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getContext(), MainActivity.class));
                return true;
            }
        });

        Preference uiModeScroll = (Preference) findPreference("mode2_preference");
        uiModeScroll.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getContext(), MainActivity2.class));
                return true;
            }
        });

        Preference about = (Preference)findPreference("about_preference");
        about.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getContext(), about_us.class));
                return true;
            }
        });
        Preference privacy = (Preference)findPreference("privacy_preference");
        privacy.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getContext(), PrivacyPolicy.class));
                return true;
            }
        });
        Preference terms = (Preference)findPreference("terms_preference");
        terms.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getContext(), TermsConditions.class));
                return true;
            }
        });
        Preference help = (Preference)findPreference("help_preference");
        help.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(getContext(), Help.class));
                return true;
            }
        });
    }
}