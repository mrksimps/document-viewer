package org.documentviewer.opds.model;

import org.documentviewer.opds.OPDSBookType;

public class BookDownloadLink extends Link {

    public final OPDSBookType bookType;
    public final boolean isZipped;

    public BookDownloadLink(final LinkKind kind, final String uri, final String rel, final String type) {
        super(kind, uri, rel, type);
        this.bookType = OPDSBookType.getByMimeType(type);
        this.isZipped = OPDSBookType.isZippedContent(type);
    }
}
