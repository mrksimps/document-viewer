package org.documentviewer.ui.settings.fragments;

import org.sufficientlysecure.viewer.R;

import android.annotation.TargetApi;

@TargetApi(11)
public class RenderFragment extends BasePreferenceFragment {

    public RenderFragment() {
        super(R.xml.fragment_render);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateRenderSettings();
    }
}
