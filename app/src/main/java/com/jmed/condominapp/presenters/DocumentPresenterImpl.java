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
    public int insertDocument(Pojo_Document document) {
        int result = -1;
        if (!Repository_Document.getInstance().contains(document)) {
            Repository_Document.getInstance().add(document);
            result = 0;
            view.showMessage(R.string.inserted);
        } else {
            view.showMessage(R.string.exists);
        }
        return result;
    }

    @Override
    public boolean validateDocument(Pojo_Document document) {
        boolean result;
        if (document.getDo_title().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Title);
        } else if (document.getDo_description().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Description);
        } else if (document.getDo_link().length() == 0) {
            result = false;
            view.showMessage(R.string.error_Link);
        } else {
            result = true;
        }
        return result;
    }
}
