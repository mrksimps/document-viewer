package org.documentviewer.common.settings.listeners;

import org.documentviewer.common.settings.OpdsSettings;

public interface IOpdsSettingsChangeListener {

    void onOpdsSettingsChanged(OpdsSettings oldSettings, OpdsSettings newSettings, OpdsSettings.Diff diff);

}
