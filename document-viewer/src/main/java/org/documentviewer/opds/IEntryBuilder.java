package org.documentviewer.opds;

import org.documentviewer.opds.model.Book;
import org.documentviewer.opds.model.BookDownloadLink;
import org.documentviewer.opds.model.Content;
import org.documentviewer.opds.model.Feed;
import org.documentviewer.opds.model.Link;

import java.util.List;
import java.util.Map;

public interface IEntryBuilder {

    Feed newFeed(Feed parent, String id, String title, Content content, Link link, Map<String, Link> facets);

    Book newBook(Feed parent, String id, String title, Content content, Link thumbnail, List<BookDownloadLink> downloads);
}
