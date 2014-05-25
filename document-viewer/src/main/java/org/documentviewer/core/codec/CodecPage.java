package org.documentviewer.core.codec;

import org.documentviewer.common.bitmaps.ByteBufferBitmap;
import org.documentviewer.core.ViewState;

import android.graphics.RectF;

import java.util.List;

public interface CodecPage {

    int getWidth();

    int getHeight();

    ByteBufferBitmap renderBitmap(ViewState viewState, int width, int height, RectF pageSliceBounds);

    List<PageLink> getPageLinks();

    List<PageTextBox> getPageText();

    List<? extends RectF> searchText(final String pattern);

    void recycle();

    boolean isRecycled();
}
