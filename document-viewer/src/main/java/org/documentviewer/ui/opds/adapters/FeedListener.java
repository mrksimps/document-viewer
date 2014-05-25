package org.documentviewer.ui.opds.adapters;

import org.documentviewer.opds.model.Feed;

public interface FeedListener {

    void feedLoaded(Feed feed);
}