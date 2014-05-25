package org.documentviewer.ui.settings;

import org.documentviewer.DocumentViewerApp;
import org.sufficientlysecure.viewer.R;
import org.documentviewer.common.settings.AppSettings;
import org.documentviewer.common.settings.SettingsManager;
import org.documentviewer.common.settings.books.BookSettings;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;

import org.emdev.common.filesystem.PathFromUri;

public class SettingsActivity extends BaseSettingsActivity {

    @Override
    protected final void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DocumentViewerApp.initFonts();

        final Uri uri = getIntent().getData();
        if (uri != null) {
            final String fileName = PathFromUri.retrieve(getContentResolver(), uri);
            BookSettings current = SettingsManager.getBookSettings(fileName);
            if (current != null) {
                setRequestedOrientation(current.getOrientation(AppSettings.current()));
            }
        }

        onCreate();
    }

    @Override
    protected void onPause() {
        SettingsManager.onSettingsChanged();
        super.onPause();
    }

    @SuppressWarnings("deprecation")
    protected void onCreate() {
        try {
            setPreferenceScreen(createPreferences());
        } catch (final ClassCastException e) {
            LCTX.e("Shared preferences are corrupt! Resetting to default values.");

            final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            final SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.commit();

            setPreferenceScreen(createPreferences());
        }

        decorator.decorateSettings();
    }

    @SuppressWarnings("deprecation")
    PreferenceScreen createPreferences() {
        final PreferenceScreen root = getPreferenceManager().createPreferenceScreen(this);

        root.setTitle(R.string.menu_settings);

        loadPreferences(root, R.xml.fragment_ui);
        loadPreferences(root, R.xml.fragment_scroll);
        loadPreferences(root, R.xml.fragment_navigation);
        loadPreferences(root, R.xml.fragment_performance);
        loadPreferences(root, R.xml.fragment_render);
        loadPreferences(root, R.xml.fragment_typespec);
        loadPreferences(root, R.xml.fragment_browser);
        loadPreferences(root, R.xml.fragment_opds);

        loadPreferences(root, R.xml.fragment_backup);

        return root;
    }

    @SuppressWarnings("deprecation")
    void loadPreferences(final PreferenceScreen root, final int... resourceIds) {
        for (final int id : resourceIds) {
            setPreferenceScreen(null);
            addPreferencesFromResource(id);
            root.addPreference(getPreferenceScreen());
            setPreferenceScreen(null);
        }
    }

}
