package org.documentviewer.core.events;

import org.documentviewer.core.PageIndex;

public interface CurrentPageListener {

    void currentPageChanged(PageIndex oldIndex, PageIndex newIndex);
}
