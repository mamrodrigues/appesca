package br.org.unesco.appesca.control;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.org.unesco.appesca.R;
import br.org.unesco.appesca.dao.FormularioDAO;
import br.org.unesco.appesca.model.Formulario;

public class FormularioListDetailFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private List<Formulario> mFormularioList = new ArrayList<Formulario>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            int situacaoFormulario = getArguments().getInt(ARG_ITEM_ID);

            FormularioDAO formularioDAO = new FormularioDAO(getActivity());
            switch (situacaoFormulario){
                case 0: //TODOS
                    mFormularioList = formularioDAO.getFormulariosByTipoFormulario(0);
                    break;
                case 1: //ENVIADOS
                    mFormularioList = formularioDAO.getFormulariosByTipoFormulario(1);
                    break;
                case 2: //NÃO ENVIADOS
                    mFormularioList = formularioDAO.getFormulariosByTipoFormulario(2);
                    break;
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

        Formulario formulario = new Formulario();
        formulario.setId(1);
        formulario.setNome("Nome");
        formulario.setDataAplicacao(new Date());
        formulario.setIdUsuario(1);

        Formulario formulario1 = new Formulario();
        formulario1.setId(0);
        formulario1.setNome("Nome");
        formulario1.setDataAplicacao(new Date());
        formulario1.setIdUsuario(0);

        mFormularioList.add(formulario);

        mAdapter = new FormularioListAdapter(mFormularioList);
        mRecyclerView.setAdapter(mAdapter);
        return rowView;
    }

}
