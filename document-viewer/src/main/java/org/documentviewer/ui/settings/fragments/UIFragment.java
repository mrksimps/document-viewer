package org.documentviewer.ui.settings.fragments;

import org.sufficientlysecure.viewer.R;

import android.annotation.TargetApi;

@TargetApi(11)
public class UIFragment extends BasePreferenceFragment {
    public UIFragment() {
        super(R.xml.fragment_ui);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateUISettings();
    }
}
