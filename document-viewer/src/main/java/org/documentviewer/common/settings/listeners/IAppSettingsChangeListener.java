package org.documentviewer.common.settings.listeners;

import org.documentviewer.common.settings.AppSettings;

public interface IAppSettingsChangeListener {

    void onAppSettingsChanged(AppSettings oldSettings, AppSettings newSettings, AppSettings.Diff diff);

}
