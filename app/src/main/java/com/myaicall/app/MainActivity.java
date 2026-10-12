package com.myaicall.app;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button startCallButton;
    private TextView statusText;
    private TextView appTitleText;
    private Button bnButton, hiButton, enButton;

    private static final String PREF_NAME = "app_settings";
    private static final String PREF_LANGUAGE = "selected_language";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        startCallButton = findViewById(R.id.startCallButton);
        statusText = findViewById(R.id.statusText);
        appTitleText = findViewById(R.id.appTitleText);
        bnButton = findViewById(R.id.bnButton);
        hiButton = findViewById(R.id.hiButton);
        enButton = findViewById(R.id.enButton);

        // Load saved language
        String savedLanguage = getSavedLanguage();
        applyLanguage(savedLanguage);

        // Start Call button listener
        startCallButton.setOnClickListener(v -> handleStartCallClick());

        // Language buttons
        enButton.setOnClickListener(v -> switchLanguage("en"));
        bnButton.setOnClickListener(v -> switchLanguage("bn"));
        hiButton.setOnClickListener(v -> switchLanguage("hi"));
    }

    private void handleStartCallClick() {
        String language = getSavedLanguage();
        switch (language) {
            case "bn":
                statusText.setText("ডেমো মোড: কল শুরু করার জন্য প্রস্তুত।\nপূর্ণ ফিচার শীঘ্রই আসবে।");
                break;
            case "hi":
                statusText.setText("डेमो मोड: कॉल शुरू करने के लिए तैयार।\nपूर्ण फीचर जल्द आएगी।");
                break;
            default:
                statusText.setText("Demo Mode: Ready to start call.\nFull features coming soon.");
        }
    }

    private void switchLanguage(String languageCode) {
        saveLanguage(languageCode);
        applyLanguage(languageCode);
        updateUITexts(languageCode);
    }

    private void applyLanguage(String languageCode) {
        Locale locale;
        switch (languageCode) {
            case "bn":
                locale = new Locale("bn", "BD");
                break;
            case "hi":
                locale = new Locale("hi", "IN");
                break;
            default:
                locale = new Locale("en", "US");
        }

        Locale.setDefault(locale);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            LocaleListCompat localeList = LocaleListCompat.forLanguageTags(locale.toLanguageTag());
            AppCompatDelegate.setApplicationLocales(localeList);
        }
    }

    private void updateUITexts(String languageCode) {
        switch (languageCode) {
            case "bn":
                appTitleText.setText("আমার AI কল");
                startCallButton.setText("কল শুরু করুন");
                statusText.setText("বাংলা ভাষা নির্বাচন করা হয়েছে।");
                break;
            case "hi":
                appTitleText.setText("मेरा AI कॉल");
                startCallButton.setText("कॉल शुरू करें");
                statusText.setText("हिंदी भाषा चुनी गई है।");
                break;
            default:
                appTitleText.setText("My AI Call");
                startCallButton.setText("Start Call");
                statusText.setText("English language selected.");
        }
    }

    private void saveLanguage(String languageCode) {
        SharedPreferences pref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        pref.edit().putString(PREF_LANGUAGE, languageCode).apply();
    }

    private String getSavedLanguage() {
        SharedPreferences pref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        return pref.getString(PREF_LANGUAGE, "en");
    }
}
