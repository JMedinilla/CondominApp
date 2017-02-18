package com.jmed.condominapp.fragments.list;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jmed.condominapp.Activity_Home;
import com.jmed.condominapp.R;
import com.jmed.condominapp.adapters.Adapter_Document;
import com.jmed.condominapp.interfaces.IDocumentPresenter;
import com.jmed.condominapp.pojos.Pojo_Document;
import com.jmed.condominapp.presenters.DocumentPresenterImpl;


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

    public boolean recieveDocumentFromHome(Pojo_Document document, boolean update) {
        boolean result = false;
        if (documentPresenter.validateDocument(document)) {
            if (update) {
                result = documentPresenter.updateDocument(document) == 0;
            } else {
                result = documentPresenter.insertDocument(document) == 0;
            }
        }
        return result;
    }

    @Override
    public void showMessage(int msg, boolean error) {
        ((Activity_Home) getActivity()).showSnackbar(getString(msg), error);
    }

    public interface FragmentListDocumentListener {
        void onManageDocumentOpen();

        void onManageDocumentOpenEdit(Pojo_Document document);
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

        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Dialog
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getActivity().getMenuInflater();
        inflater.inflate(R.menu.menu_context_list, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;
        Pojo_Document document = adapter_document.getItem(index);

        switch (item.getItemId()) {
            case R.id.menuContext_update:
                homeCallback.onManageDocumentOpenEdit(document);
                return true;
            case R.id.menuContext_delete:
                if (documentPresenter.deleteDocument(document) == 0) {
                    showMessage(R.string.deleted, false);
                    adapter_document.notifyDataSetChanged();
                } else {
                    showMessage(R.string.no_deleted, true);
                }
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}