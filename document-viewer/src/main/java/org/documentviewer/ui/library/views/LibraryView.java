package org.documentviewer.ui.library.views;

import org.documentviewer.ui.library.IBrowserActivity;
import org.documentviewer.ui.library.adapters.BookNode;
import org.documentviewer.ui.library.adapters.LibraryAdapter;

import android.net.Uri;
import android.view.View;
import android.widget.ExpandableListView;

import java.io.File;

public class LibraryView extends ExpandableListView implements ExpandableListView.OnChildClickListener {

    private IBrowserActivity base;
    private LibraryAdapter adapter;

    public LibraryView(IBrowserActivity base, LibraryAdapter adapter) {
        super(base.getContext());
        this.base = base;
        this.adapter = adapter;

        setAdapter(adapter);

        setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        setOnChildClickListener(this);
    }

    @Override
    public boolean onChildClick(final ExpandableListView parent, final View v, final int groupPosition,
            final int childPosition, final long id) {
        final BookNode book = adapter.getChild(groupPosition, childPosition);
        final File file = new File(book.path);
        if (!file.isDirectory()) {
            base.showDocument(Uri.fromFile(file), null);
        }
        return false;
    }
}
