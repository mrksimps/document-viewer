package org.documentviewer.core.curl;

import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.Page;
import org.documentviewer.core.SinglePageController;

public class SinglePageSlider extends AbstractPageSlider {

    public SinglePageSlider(final SinglePageController singlePageDocumentView) {
        super(PageAnimationType.SLIDER, singlePageDocumentView);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#drawForeground(org.documentviewer.core.EventGLDraw)
     */
    @Override
    protected void drawForeground(final EventGLDraw event) {
        Page page = event.viewState.model.getPageObject(foreIndex);
        if (page == null) {
            page = event.viewState.model.getCurrentPageObject();
        }
        if (page != null) {
            event.canvas.save();
            event.canvas.translate(-mA.x, 0);
            event.process(page);
            event.canvas.restore();
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#drawBackground(org.documentviewer.core.EventDraw)
     */
    @Override
    protected void drawBackground(final EventGLDraw event) {
        final Page page = event.viewState.model.getPageObject(backIndex);
        if (page != null) {
            event.canvas.save();
            event.canvas.translate(- mA.x + event.viewState.viewRect.width(), 0);
            event.process(page);
            event.canvas.restore();
        }
    }

}
