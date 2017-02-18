package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Document;

import java.util.List;

public interface IDocumentPresenter {
    List<Pojo_Document> selectDocuments();
    int insertDocument(Pojo_Document document);

    interface View {
        void showMessage(String msg);
    }
}
