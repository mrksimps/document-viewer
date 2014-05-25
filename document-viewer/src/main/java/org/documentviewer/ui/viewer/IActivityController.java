package org.documentviewer.ui.viewer;

import org.documentviewer.common.settings.books.BookSettings;
import org.documentviewer.core.DecodeService;
import org.documentviewer.core.models.DecodingProgressModel;
import org.documentviewer.core.models.DocumentModel;
import org.documentviewer.core.models.SearchModel;
import org.documentviewer.core.models.ZoomModel;

import android.app.Activity;
import android.content.Context;

import org.emdev.ui.actions.IActionController;

public interface IActivityController extends IActionController<ViewerActivity> {

    Context getContext();

    Activity getActivity();

    BookSettings getBookSettings();

    DecodeService getDecodeService();

    DocumentModel getDocumentModel();

    SearchModel getSearchModel();

    IView getView();

    IViewController getDocumentController();

    IActionController<?> getActionController();

    ZoomModel getZoomModel();

    DecodingProgressModel getDecodingProgressModel();

    void jumpToPage(int viewIndex, float offsetX, float offsetY, boolean addToHistory);

    void runOnUiThread(Runnable r);

}
