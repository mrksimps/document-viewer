package org.documentviewer.core;

import org.documentviewer.common.bitmaps.ByteBufferBitmap;
import org.documentviewer.common.bitmaps.IBitmapRef;
import org.documentviewer.core.codec.CodecPageInfo;
import org.documentviewer.core.codec.OutlineLink;

import android.graphics.RectF;

import java.util.List;

public class DecodeServiceStub implements DecodeService {

    private static final CodecPageInfo DEFAULT = new CodecPageInfo(0, 0);

    @Override
    public boolean isFeatureSupported(final int feature) {
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#open(java.lang.String, java.lang.String)
     */
    @Override
    public void open(final String fileName, final String password) {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#decodePage(org.documentviewer.core.ViewState,
     *      org.documentviewer.core.PageTreeNode)
     */
    @Override
    public void decodePage(final ViewState viewState, final PageTreeNode node) {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#stopDecoding(org.documentviewer.core.PageTreeNode, java.lang.String)
     */
    @Override
    public void stopDecoding(final PageTreeNode node, final String reason) {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#getPageCount()
     */
    @Override
    public int getPageCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#getOutline()
     */
    @Override
    public List<OutlineLink> getOutline() {
        return null;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#getUnifiedPageInfo()
     */
    @Override
    public CodecPageInfo getUnifiedPageInfo() {
        return DEFAULT;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#getPageInfo(int)
     */
    @Override
    public CodecPageInfo getPageInfo(final int pageIndex) {
        return DEFAULT;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#recycle()
     */
    @Override
    public void recycle() {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#updateViewState(org.documentviewer.core.ViewState)
     */
    @Override
    public void updateViewState(final ViewState viewState) {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.DecodeService#createThumbnail(booleam int, int, int, android.graphics.RectF)
     */
    @Override
    public IBitmapRef createThumbnail(boolean useEmbeddedIfAvailable, final int width, final int height, final int pageNo, final RectF region) {
        return null;
    }

    @Override
    public void searchText(final Page page, final String pattern, final SearchCallback callback) {
    }

    @Override
    public void stopSearch(final String pattern) {
    }

    @Override
    public ByteBufferBitmap createPageThumbnail(int width, int height, int pageNo, RectF region) {
        return null;
    }

}
