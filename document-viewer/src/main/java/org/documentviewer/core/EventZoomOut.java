package org.documentviewer.core;

import android.graphics.RectF;

import java.util.Queue;

public class EventZoomOut extends AbstractEventZoom<EventZoomOut> {

    EventZoomOut(final Queue<EventZoomOut> eventQueue) {
        super(eventQueue);
    }

    /**
     * {@inheritDoc}
     * 
     * @see org.documentviewer.core.IEvent#process(org.documentviewer.core.ViewState, org.documentviewer.core.PageTreeNode)
     */
    @Override
    public boolean process(final PageTreeNode node) {

        final RectF pageBounds = viewState.getBounds(node.page);

        if (!viewState.isNodeKeptInMemory(node, pageBounds)) {
            node.recycle(bitmapsToRecycle);
            return false;
        }

        if (!node.holder.hasBitmaps() || committed) {
            node.decodePageTreeNode(nodesToDecode, viewState);
        }

        return true;
    }
}
