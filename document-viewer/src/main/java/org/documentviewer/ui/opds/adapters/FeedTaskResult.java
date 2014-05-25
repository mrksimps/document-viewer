package org.documentviewer.ui.opds.adapters;

import org.documentviewer.opds.exceptions.OPDSException;
import org.documentviewer.opds.model.Feed;

public class FeedTaskResult {

    public Feed feed;
    public OPDSException error;

    public FeedTaskResult(final Feed feed) {
        this.feed = feed;
    }

    public FeedTaskResult(final Feed feed, final OPDSException error) {
        this.feed = feed;
        this.error = error;
    }
}