package org.documentviewer.core;

import org.documentviewer.common.settings.books.BookSettings;
import org.documentviewer.common.settings.types.DocumentViewMode;
import org.documentviewer.core.models.DocumentModel.PageIterator;
import org.documentviewer.ui.viewer.IActivityController;
import org.documentviewer.ui.viewer.views.DragMark;

import android.graphics.Rect;
import android.graphics.RectF;

public abstract class AbstractScrollController extends AbstractViewController {

    protected AbstractScrollController(final IActivityController base, final DocumentViewMode mode) {
        super(base, mode);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.ui.viewer.IViewController#goToPage(int)
     */
    @Override
    public final void goToPage(final int toPage) {
        new EventGotoPage(this, toPage).process().release();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.ui.viewer.IViewController#goToPage(int, float, float)
     */
    @Override
    public final void goToPage(final int toPage, final float offsetX, final float offsetY) {
        new EventGotoPage(this, toPage, offsetX, offsetY).process().release();
    }

    @Override
    public final void drawView(final EventGLDraw eventDraw) {
        final ViewState viewState = eventDraw.viewState;
        if (viewState.model == null) {
            return;
        }

        final PageIterator pages = viewState.pages.getVisiblePages();
        try {
            for (final Page page : pages) {
                if (page != null) {
                    eventDraw.process(page);
                }
            }
        } finally {
            pages.release();
        }

        if (eventDraw.viewState.app.showAnimIcon) {
            DragMark.DRAG.draw(eventDraw.canvas, viewState);
        }
        getView().continueScroll();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.AbstractViewController#onLayoutChanged(boolean, boolean, android.graphics.Rect,
     *      android.graphics.Rect)
     */
    @Override
    public final boolean onLayoutChanged(final boolean layoutChanged, final boolean layoutLocked, final Rect oldLaout,
            final Rect newLayout) {
        final BookSettings bs = base.getBookSettings();
        final int page = model != null ? model.getCurrentViewPageIndex() : -1;
        final float offsetX = bs != null ? bs.offsetX : 0;
        final float offsetY = bs != null ? bs.offsetY : 0;

        if (super.onLayoutChanged(layoutChanged, layoutLocked, oldLaout, newLayout)) {
            if (isShown && layoutChanged && page != -1) {
                goToPage(page, offsetX, offsetY);
            }
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.ui.viewer.IViewController#onScrollChanged(int, int)
     */
    @Override
    public final void onScrollChanged(final int dX, final int dY) {
        if (inZoom.get()) {
            return;
        }

       EventPool.newEventScroll(this, mode == DocumentViewMode.VERTICALL_SCROLL ? dY : dX).process().release();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.ui.viewer.IViewController#isPageVisible(org.documentviewer.core.Page,
     *      org.documentviewer.core.ViewState, android.graphics.RectF)
     */
    @Override
    public final boolean isPageVisible(final Page page, final ViewState viewState, final RectF outBounds) {
        viewState.getBounds(page, outBounds);
        return RectF.intersects(viewState.viewRect, outBounds);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.ui.viewer.IViewController#pageUpdated(org.documentviewer.core.ViewState,
     *      org.documentviewer.core.Page)
     */
    @Override
    public void pageUpdated(final ViewState viewState, final Page page) {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.ui.viewer.IViewController#updateAnimationType()
     */
    @Override
    public void updateAnimationType() {
    }
}
