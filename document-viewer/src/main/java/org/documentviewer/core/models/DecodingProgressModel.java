package org.documentviewer.core.models;

import org.documentviewer.core.events.DecodingProgressListener;

import java.util.concurrent.atomic.AtomicInteger;

import org.emdev.utils.listeners.ListenerProxy;

public class DecodingProgressModel extends ListenerProxy {

    private AtomicInteger currentlyDecoding = new AtomicInteger();

    public DecodingProgressModel() {
        super(DecodingProgressListener.class);
    }

    public void increase() {
        this.<DecodingProgressListener> getListener().decodingProgressChanged(currentlyDecoding.incrementAndGet());
    }

    public void increase(int increment) {
        this.<DecodingProgressListener> getListener().decodingProgressChanged(currentlyDecoding.addAndGet(increment));
    }

    public void decrease() {
        this.<DecodingProgressListener> getListener().decodingProgressChanged(currentlyDecoding.decrementAndGet());
    }
}
