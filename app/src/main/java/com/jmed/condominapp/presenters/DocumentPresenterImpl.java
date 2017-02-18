package com.jmed.condominapp.presenters;

import com.jmed.condominapp.R;
import com.jmed.condominapp.interfaces.IDocumentPresenter;
import com.jmed.condominapp.pojos.Pojo_Document;
import com.jmed.condominapp.repositories.Repository_Document;

import java.util.List;

public class DocumentPresenterImpl implements IDocumentPresenter {
    private IDocumentPresenter.View view;

    public DocumentPresenterImpl(IDocumentPresenter.View view) {
        this.view = view;
    }

    @Override
    public List<Pojo_Document> selectDocuments() {
        return Repository_Document.getInstance().getDocuments();
    }

    @Override
    public Pojo_Document selectDocument(String id) {
        return null;
    }

    @Override
    public int insertDocument(Pojo_Document document) {
        int result = -1;
        if (!Repository_Document.getInstance().contains(document)) {
            Repository_Document.getInstance().add(document);
            result = 0;
            view.showMessage(R.string.inserted, false);
        } else {
            view.showMessage(R.string.exists, false);
        }
        return result;
    }

    @Override
    public int updateDocument(Pojo_Document document) {
        return 0;
    }

    @Override
    public int deleteDocument(Pojo_Document document) {
        int result = -1;
        if (Repository_Document.getInstance().getDocuments().remove(document)) {
            result = 0;
        }
        return result;
    }

    @Override
    public boolean validateDocument(Pojo_Document document) {
        boolean result;
        if (document.getDo_title().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Title, true);
        } else if (document.getDo_description().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Description, true);
        } else if (document.getDo_link().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Link, true);
        } else {
            result = true;
        }
        return result;
    }
}
