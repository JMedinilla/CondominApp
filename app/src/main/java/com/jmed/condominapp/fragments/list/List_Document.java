package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.jmed.condominapp.Activity_Home;
import com.jmed.condominapp.R;
import com.jmed.condominapp.adapters.Adapter_Document;
import com.jmed.condominapp.fragments.form.Form_Document;
import com.jmed.condominapp.interfaces.IDocumentPresenter;
import com.jmed.condominapp.pojos.Pojo_Document;
import com.jmed.condominapp.presenters.DocumentPresenterImpl;
import com.jmed.condominapp.repositories.Repository_Document;


public class List_Document extends Fragment implements IDocumentPresenter.View {
    private FragmentListDocumentListener homeCallback;
    public static final String TAG_FRAGMENT_LIST_DOCUMENT = "fragmentListDocumentTag";

    DocumentPresenterImpl documentPresenter;
    Adapter_Document adapter_document;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public void recieveDocumentFromHome(Pojo_Document document) {
        documentPresenter.insertDocument(document);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public interface FragmentListDocumentListener {
        void onManageDocumentOpen();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        homeCallback = (FragmentListDocumentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        documentPresenter = new DocumentPresenterImpl(this);
        View view = inflater.inflate(R.layout.fragment_list_document, container, false);

        FloatingActionButton btn = (FloatingActionButton) view.findViewById(R.id.fragListDocument_btn);
        ListView listView = (ListView) view.findViewById(R.id.fragListDocument_list);

        adapter_document = new Adapter_Document(getContext(), documentPresenter.selectDocuments());
        listView.setDivider(null);
        listView.setAdapter(adapter_document);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeCallback.onManageDocumentOpen();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        homeCallback = null;
        adapter_document = null;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_fragment_documents, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuDocuments_title:
                adapter_document.sortDocuments(Pojo_Document.COMPARATOR_DOCUMENT_TITLE);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}