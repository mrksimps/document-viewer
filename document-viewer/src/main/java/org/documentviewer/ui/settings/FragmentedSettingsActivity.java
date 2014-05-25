
package org.documentviewer.ui.settings;

import org.documentviewer.ui.settings.fragments.BackupFragment;
import org.documentviewer.ui.settings.fragments.BasePreferenceFragment;
import org.documentviewer.ui.settings.fragments.BrowserFragment;
import org.documentviewer.ui.settings.fragments.NavFragment;
import org.documentviewer.ui.settings.fragments.OpdsFragment;
import org.documentviewer.ui.settings.fragments.PerformanceFragment;
import org.documentviewer.ui.settings.fragments.RenderFragment;
import org.documentviewer.ui.settings.fragments.ScrollFragment;
import org.documentviewer.ui.settings.fragments.TypeSpecificFragment;
import org.documentviewer.ui.settings.fragments.UIFragment;
import org.sufficientlysecure.viewer.R;

import android.annotation.TargetApi;
import android.content.res.Configuration;

import java.util.List;

@TargetApi(11)
public class FragmentedSettingsActivity extends SettingsActivity {

    @Override
    protected void onCreate() {
    }

    @Override
    public void onBuildHeaders(final List<Header> target) {
        loadHeadersFromResource(R.xml.preferences_headers, target);
    }

    @Override
    public boolean onIsMultiPane() {
        final Configuration c = this.getResources().getConfiguration();
        if (0 != (Configuration.SCREENLAYOUT_SIZE_XLARGE & c.screenLayout)) {
            return c.orientation == Configuration.ORIENTATION_LANDSCAPE;
        }
        return false;
    }

    protected boolean isValidFragment(String fragmentName) {
        if (ScrollFragment.class.getName().equals(fragmentName)
                || UIFragment.class.getName().equals(fragmentName)
                || NavFragment.class.getName().equals(fragmentName)
                || PerformanceFragment.class.getName().equals(fragmentName)
                || TypeSpecificFragment.class.getName().equals(fragmentName)
                || BackupFragment.class.getName().equals(fragmentName)
                || BasePreferenceFragment.class.getName().equals(fragmentName)
                || BrowserFragment.class.getName().equals(fragmentName)
                || OpdsFragment.class.getName().equals(fragmentName)
                || RenderFragment.class.getName().equals(fragmentName)) {
            return true;
        }
        return false;
    }
}
