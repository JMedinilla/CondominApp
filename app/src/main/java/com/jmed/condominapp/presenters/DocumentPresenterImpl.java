package com.jmed.condominapp.presenters;

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
            view.showMessage("Inserted");
        }
        else {
            view.showMessage("Already exists");
        }
        return result;
    }
}
