package org.documentviewer.core.curl;

import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.Page;
import org.documentviewer.core.SinglePageController;

import android.graphics.RectF;

public class SinglePageSqueezer extends AbstractPageSlider {

    public SinglePageSqueezer(final SinglePageController singlePageDocumentView) {
        super(PageAnimationType.SQUEEZER, singlePageDocumentView);
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
            final RectF viewRect = event.viewState.viewRect;
            event.canvas.save();
            event.canvas.translate(-mA.x, 0);
            event.canvas.scale((viewRect.width() - mA.x) / viewRect.width(), 1, 1);
            event.process(page);
            event.canvas.restore();
        }
    }

    @Override
    protected void drawBackground(final EventGLDraw event) {
        Page page = event.viewState.model.getPageObject(backIndex);
        if (page == null) {
            page = event.viewState.model.getCurrentPageObject();
        }
        if (page != null) {
            final RectF viewRect = event.viewState.viewRect;
            event.canvas.save();
            event.canvas.translate(-mA.x + event.viewState.viewRect.width(), 0);
            event.canvas.scale((mA.x) / viewRect.width(), 1, 1);
            event.process(page);
            event.canvas.restore();
        }
    }

}
