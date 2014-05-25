package org.documentviewer.common.settings.types;

import org.documentviewer.DocumentViewerApp;
import org.sufficientlysecure.viewer.R;

import org.emdev.utils.enums.ResourceConstant;

public enum CacheLocation implements ResourceConstant {

    /**
     *
     */
    System(R.string.pref_cachelocation_system),
    /**
     *
     */
    Custom(R.string.pref_cachelocation_custom);

    private final String resValue;

    private CacheLocation(final int resId) {
        this.resValue = DocumentViewerApp.context.getString(resId);
    }

    public String getResValue() {
        return resValue;
    }

}
