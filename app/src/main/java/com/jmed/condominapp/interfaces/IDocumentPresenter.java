package com.jmed.condominapp.interfaces;

import com.jmed.condominapp.pojos.Pojo_Document;

import java.util.List;

public interface IDocumentPresenter {
    List<Pojo_Document> selectDocuments();

    Pojo_Document selectDocument(String id);

    int insertDocument(Pojo_Document document);

    int updateDocument(Pojo_Document document);

    int deleteDocument(Pojo_Document document);

    boolean validateDocument(Pojo_Document document);

    interface View {
        void showMessage(int msg, boolean error);
    }
}
