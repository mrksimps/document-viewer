package org.documentviewer.common.settings.listeners;

import org.documentviewer.common.settings.LibSettings;

public interface ILibSettingsChangeListener {

    void onLibSettingsChanged(LibSettings oldSettings, LibSettings newSettings, LibSettings.Diff diff);

}
