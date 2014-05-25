package org.documentviewer.ui.settings.fragments;

import org.sufficientlysecure.viewer.R;

import android.annotation.TargetApi;

@TargetApi(11)
public class TypeSpecificFragment extends BasePreferenceFragment {

    public TypeSpecificFragment() {
        super(R.xml.fragment_typespec);
    }

    @Override
    public void decorate() {
        super.decorate();
        decorator.decorateTypeSpecificSettings();
    }
}
