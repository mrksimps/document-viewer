package org.documentviewer.common.touch;

import android.view.MotionEvent;


public class DummyGestureDetector implements IGestureDetector {

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
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

}
