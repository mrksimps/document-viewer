package org.documentviewer.common.settings.listeners;

import org.documentviewer.common.settings.books.BookSettings;

public interface IBookSettingsChangeListener {

    void onBookSettingsChanged(BookSettings oldSettings, BookSettings newSettings, BookSettings.Diff diff);

}
