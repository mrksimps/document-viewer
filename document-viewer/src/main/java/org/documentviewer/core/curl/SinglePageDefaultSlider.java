package org.documentviewer.core.curl;

import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.Page;
import org.documentviewer.core.SinglePageController;
import org.documentviewer.core.ViewState;

public class SinglePageDefaultSlider extends AbstractPageSlider {

    public SinglePageDefaultSlider(final SinglePageController singlePageDocumentView) {
        super(PageAnimationType.NONE, singlePageDocumentView);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#isPageVisible(org.documentviewer.core.Page, org.documentviewer.core.ViewState)
     */
    @Override
    public boolean isPageVisible(final Page page, final ViewState viewState) {
        final int pageIndex = page.index.viewIndex;
        return pageIndex == viewState.model.getCurrentViewPageIndex();
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#drawForeground(org.documentviewer.core.EventGLDraw)
     */
    @Override
    protected void drawForeground(final EventGLDraw event) {
        final ViewState viewState = event.viewState;
        Page page = null;
        if (bFlipping) {
            page = viewState.model.getPageObject(!bFlipRight ? foreIndex : backIndex);
        }
        if (page == null) {
            page = viewState.model.getCurrentPageObject();
        }
        if (page != null) {
            event.process(page);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#drawBackground(org.documentviewer.core.EventGLDraw)
     */
    @Override
    protected void drawBackground(final EventGLDraw event) {
    }

}
