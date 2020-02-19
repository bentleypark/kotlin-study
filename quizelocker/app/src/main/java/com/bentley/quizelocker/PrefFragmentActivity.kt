package com.bentley.quizelocker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class PrefFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pref_fragment)

        supportFragmentManager.beginTransaction().replace(android.R.id.content, MyPrefFragment()).commit()
    }

    class MyPrefFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {

            addPreferencesFromResource(R.xml.ex_pref)
        }
    }
}