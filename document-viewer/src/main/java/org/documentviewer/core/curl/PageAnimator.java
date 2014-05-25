package org.documentviewer.core.curl;

import org.documentviewer.common.touch.IGestureDetector;
import org.documentviewer.core.EventGLDraw;
import org.documentviewer.core.Page;
import org.documentviewer.core.ViewState;

public interface PageAnimator extends IGestureDetector {

    PageAnimationType getType();

    void init();

    void resetPageIndexes(final int currentIndex);

    void draw(EventGLDraw event);

    void setViewDrawn(boolean b);

    void flipAnimationStep();

    boolean isPageVisible(final Page page, final ViewState viewState);

    void pageUpdated(ViewState viewState, Page page);

    void animate(int direction);
}
