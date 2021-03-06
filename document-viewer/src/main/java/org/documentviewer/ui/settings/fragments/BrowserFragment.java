package org.documentviewer.ui.settings.fragments;

import org.sufficientlysecure.viewer.R;

import android.annotation.TargetApi;

@TargetApi(11)
public class BrowserFragment extends BasePreferenceFragment {

    public BrowserFragment() {
        super(R.xml.fragment_browser);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateBrowserSettings();
    }

}
