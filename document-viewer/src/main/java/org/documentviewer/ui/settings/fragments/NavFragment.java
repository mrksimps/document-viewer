package org.documentviewer.ui.settings.fragments;

import org.sufficientlysecure.viewer.R;

import android.annotation.TargetApi;

@TargetApi(11)
public class NavFragment extends BasePreferenceFragment {
    public NavFragment() {
        super(R.xml.fragment_navigation);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateUISettings();
    }
}
