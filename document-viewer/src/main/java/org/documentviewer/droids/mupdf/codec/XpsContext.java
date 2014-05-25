package org.documentviewer.droids.mupdf.codec;

import org.documentviewer.core.codec.CodecDocument;


public class XpsContext extends MuPdfContext {

    @Override
    public CodecDocument openDocument(final String fileName, final String password) {
        setExternalFonts();
        return new MuPdfDocument(this, MuPdfDocument.FORMAT_XPS, fileName, password);
    }
}
