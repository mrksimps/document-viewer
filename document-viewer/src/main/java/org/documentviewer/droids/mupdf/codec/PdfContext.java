package org.documentviewer.droids.mupdf.codec;

import org.documentviewer.core.codec.CodecDocument;


public class PdfContext extends MuPdfContext {

    @Override
    public CodecDocument openDocument(final String fileName, final String password) {
        setExternalFonts();
        return new MuPdfDocument(this, MuPdfDocument.FORMAT_PDF, fileName, password);
    }
}
