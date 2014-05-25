package org.documentviewer.ui.viewer.stubs;

import org.documentviewer.DocumentViewerApp;
import org.documentviewer.common.settings.books.BookSettings;
import org.documentviewer.core.DecodeService;
import org.documentviewer.core.models.DecodingProgressModel;
import org.documentviewer.core.models.DocumentModel;
import org.documentviewer.core.models.SearchModel;
import org.documentviewer.core.models.ZoomModel;
import org.documentviewer.ui.viewer.IActivityController;
import org.documentviewer.ui.viewer.IView;
import org.documentviewer.ui.viewer.IViewController;
import org.documentviewer.ui.viewer.ViewerActivity;

import android.app.Activity;
import android.content.Context;

import org.emdev.ui.actions.ActionController;
import org.emdev.ui.actions.IActionController;

public class ActivityControllerStub extends ActionController<ViewerActivity> implements IActivityController {

    public static final ActivityControllerStub STUB = new ActivityControllerStub();

    public static final DocumentModel DM_STUB = new DocumentModel(null);

    public static final ZoomModel ZM_STUB = new ZoomModel();

    private SearchModel SEARCH_STUB = new SearchModel(this);

    private ActivityControllerStub() {
        super(null, null);
    }

    @Override
    public Context getContext() {
        return DocumentViewerApp.context;
    }

    @Override
    public Activity getActivity() {
        return null;
    }

    @Override
    public DecodeService getDecodeService() {
        return null;
    }

    @Override
    public BookSettings getBookSettings() {
        return null;
    }

    @Override
    public DocumentModel getDocumentModel() {
        return DM_STUB;
    }

    @Override
    public IView getView() {
        return ViewStub.STUB;
    }

    @Override
    public IViewController getDocumentController() {
        return ViewContollerStub.STUB;
    }

    @Override
    public IActionController<?> getActionController() {
        return null;
    }

    @Override
    public ZoomModel getZoomModel() {
        return ZM_STUB;
    }

    @Override
    public DecodingProgressModel getDecodingProgressModel() {
        return null;
    }

    @Override
    public void jumpToPage(final int viewIndex, final float offsetX, final float offsetY, final boolean addToHistory) {
    }

    @Override
    public SearchModel getSearchModel() {
        return SEARCH_STUB;
    }

    @Override
    public void runOnUiThread(final Runnable r) {
    }
}
