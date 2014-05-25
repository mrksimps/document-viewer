//package org.documentviewer.droids.cbx;
//
//import org.documentviewer.droids.cbx.codec.CbxContext;
//
//import java.io.File;
//import java.io.IOException;
//
//import org.emdev.common.archives.ArchiveFile;
//import org.emdev.common.archives.rar.RarArchive;
//import org.emdev.common.archives.rar.RarArchiveEntry;
//
//public class CbrContext extends CbxContext<RarArchiveEntry> {
//
//    public CbrContext(){
//        super();
//    }
//
//    /**
//     * {@inheritDoc}
//     *
//     * @see org.documentviewer.droids.cbx.codec.CbxArchiveFactory#createArchive(java.io.File, java.lang.String)
//     */
//    @Override
//    public ArchiveFile<RarArchiveEntry> createArchive(final File file, final String password) throws IOException {
//        return new RarArchive(file, false);
//    }
//
//}
