package org.documentviewer.core.curl;

import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.SinglePageController;
import org.documentviewer.core.ViewState;
import org.documentviewer.ui.viewer.views.DragMark;

import org.emdev.ui.gl.GLCanvas;

public abstract class AbstractPageSlider extends AbstractPageAnimator {

    public AbstractPageSlider(final PageAnimationType type, final SinglePageController singlePageDocumentView) {
        super(type, singlePageDocumentView);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#init()
     */
    @Override
    public void init() {
        super.init();
        mInitialEdgeOffset = 0;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#onFirstDrawEvent(org.emdev.ui.gl.GLCanvas,
     *      org.documentviewer.core.ViewState)
     */
    @Override
    protected void onFirstDrawEvent(final GLCanvas canvas, final ViewState viewState) {
        lock.writeLock().lock();
        try {
            updateValues();
        } finally {
            lock.writeLock().unlock();
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#resetClipEdge()
     */
    @Override
    protected void resetClipEdge() {
        // Set our base movement
        mMovement.x = mInitialEdgeOffset;
        mMovement.y = mInitialEdgeOffset;
        mOldMovement.x = 0;
        mOldMovement.y = 0;

        // Now set the points
        mA.set(mInitialEdgeOffset, 0);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#updateValues()
     */
    @Override
    protected void updateValues() {
        // Calculate point A
        mA.x = mMovement.x;
        mA.y = 0;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#drawExtraObjects(org.documentviewer.core.EventDraw)
     */
    @Override
    protected final void drawExtraObjects(final EventGLDraw event) {
        if (event.viewState.app.showAnimIcon) {
            DragMark.CURLER.draw(event.canvas, event.viewState);
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.AbstractPageAnimator#fixMovement(org.documentviewer.core.curl.Vector2D, boolean)
     */
    @Override
    protected Vector2D fixMovement(final Vector2D movement, final boolean bMaintainMoveDir) {
        return movement;
    }
}
