package org.documentviewer.common.settings.listeners;

import org.documentviewer.common.settings.BackupSettings;

public interface IBackupSettingsChangeListener {

    void onBackupSettingsChanged(BackupSettings oldSettings, BackupSettings newSettings, BackupSettings.Diff diff);

}
