package org.documentviewer.opds;

import org.documentviewer.opds.model.Feed;
import org.documentviewer.opds.model.Link;

import java.util.Map;

public class ExtentedEntryBuilder extends BaseEntryBuilder {

    @Override
    protected void createFacets(final Feed facetParent, final Feed feed, final Map<String, Link> facets) {
        if (facets.isEmpty()) {
            return;
        }

        if (feed.link != null) {
            final Feed f = new Feed(feed.parent, feed.id, feed.content.content, null);
            f.link = feed.link;
            feed.facets.add(f);
            feed.link = null;
        }

        super.createFacets(feed.parent, feed, facets);
    }

}
