package org.documentviewer.core.curl;

import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.Page;
import org.documentviewer.core.SinglePageController;

public class SinglePageSlider2 extends AbstractPageSlider {

    public SinglePageSlider2(final SinglePageController singlePageDocumentView) {
        super(PageAnimationType.SLIDER, singlePageDocumentView);
    }

    @Override
    protected void drawInternal(final EventGLDraw event) {
        drawBackground(event);
        if (foreIndex != backIndex) {
            drawForeground(event);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#drawForeground(org.documentviewer.core.EventDraw)
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
        Page page = event.viewState.model.getPageObject(backIndex);
        if (page == null) {
            page = event.viewState.model.getCurrentPageObject();
        }
        if (page != null) {
            event.process(page);
        }
    }

}
