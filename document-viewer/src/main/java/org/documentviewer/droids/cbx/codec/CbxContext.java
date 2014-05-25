package org.documentviewer.droids.cbx.codec;

import org.documentviewer.DocumentViewerLibraryLoader;
import org.documentviewer.core.codec.AbstractCodecContext;
import org.documentviewer.core.codec.CodecDocument;

import java.io.File;
import java.io.IOException;

import org.emdev.common.archives.ArchiveEntry;
import org.emdev.common.archives.ArchiveFile;

public abstract class CbxContext<ArchiveEntryType extends ArchiveEntry> extends AbstractCodecContext implements
        CbxArchiveFactory<ArchiveEntryType> {

    public static final int CBX_FEATURES = FEATURE_CACHABLE_PAGE_INFO | FEATURE_PARALLEL_PAGE_ACCESS
            | FEATURE_CROP_SUPPORT | FEATURE_SPLIT_SUPPORT;

    static {
        DocumentViewerLibraryLoader.load();
    }

    protected CbxContext() {
        super(CBX_FEATURES);
    }

    /**
     * {@inheritDoc}
     *
     * @see org.documentviewer.core.codec.CodecContext#openDocument(java.lang.String, java.lang.String)
     */
    @Override
    public CodecDocument openDocument(final String fileName, final String password) {
        try {
            final ArchiveFile<ArchiveEntryType> archive = createArchive(new File(fileName), password);
            return new CbxDocument<ArchiveEntryType>(this, archive);
        } catch (final IOException e) {
            if (CbxDocument.LCTX.isDebugEnabled()) {
                CbxDocument.LCTX.d("IO error: " + e.getMessage());
            }
            return new CbxDocument<ArchiveEntryType>(this, null);
        }
    }
}
