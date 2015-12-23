package br.org.unesco.appesca.control;

import android.app.Activity;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.org.unesco.appesca.R;
import br.org.unesco.appesca.model.ItemMenuLateral;
import br.org.unesco.appesca.model.MenuContent;

public class FormularioListDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private ItemMenuLateral mItem;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public FormularioListDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            mItem = MenuContent.ITEM_MAP.get(getArguments().getInt(ARG_ITEM_ID));

            Activity activity = this.getActivity();
            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(mItem.title);
            }
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rowView = inflater.inflate(R.layout.formulario_list_detail, container, false);

        mRecyclerView = (RecyclerView) getActivity().findViewById(R.id.formulario_list_rv);

        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FormularioDetailAdapter(mItem);
        mRecyclerView.setAdapter(mAdapter);
        return rowView;
    }

}
