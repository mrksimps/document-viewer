package org.documentviewer.core.curl;

import org.documentviewer.common.settings.AppSettings;
import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.Page;
import org.documentviewer.core.SinglePageController;
import org.documentviewer.core.ViewState;
import org.documentviewer.ui.viewer.views.DragMark;

import android.view.MotionEvent;

import org.emdev.common.log.LogContext;
import org.emdev.common.log.LogManager;

public class SinglePageView implements PageAnimator {

    protected static final LogContext LCTX = LogManager.root().lctx("View", false);

    protected final PageAnimationType type;

    protected final SinglePageController view;

    protected boolean bViewDrawn;

    protected int foreIndex = -1;

    protected int backIndex = -1;

    public SinglePageView(final SinglePageController view) {
        this(PageAnimationType.NONE, view);
    }

    protected SinglePageView(final PageAnimationType type, final SinglePageController view) {
        this.type = type;
        this.view = view;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#init()
     */
    @Override
    public void init() {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#getType()
     */
    @Override
    public final PageAnimationType getType() {
        return type;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.common.touch.IGestureDetector#enabled()
     */
    @Override
    public boolean enabled() {
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.common.touch.IGestureDetector#onTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onTouchEvent(final MotionEvent event) {
        return false;
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
     * @see org.documentviewer.core.curl.PageAnimator#draw(org.documentviewer.core.EventGLDraw)
     */
    @Override
    public void draw(final EventGLDraw event) {
        final Page page = event.viewState.model.getCurrentPageObject();
        if (page != null) {
            event.process(page);
            if (AppSettings.current().showAnimIcon) {
                DragMark.DRAG.draw(event.canvas, event.viewState);
            }
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#resetPageIndexes(int)
     */
    @Override
    public final void resetPageIndexes(final int currentIndex) {
        if (foreIndex != currentIndex) {
            foreIndex = backIndex = currentIndex;
        }
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#flipAnimationStep()
     */
    @Override
    public void flipAnimationStep() {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#setViewDrawn(boolean)
     */
    @Override
    public final void setViewDrawn(final boolean bViewDrawn) {
        this.bViewDrawn = bViewDrawn;
    }

    public boolean isViewDrawn() {
        return bViewDrawn;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#pageUpdated(org.documentviewer.core.ViewState, org.documentviewer.core.Page)
     */
    @Override
    public void pageUpdated(final ViewState viewState, final Page page) {
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.curl.PageAnimator#animate(int)
     */
    @Override
    public void animate(final int direction) {
        view.goToPage(view.model.getCurrentViewPageIndex() + direction);
    }

}
