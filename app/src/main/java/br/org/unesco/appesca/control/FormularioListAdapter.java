package br.org.unesco.appesca.control;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.org.unesco.appesca.R;
import br.org.unesco.appesca.model.Formulario;

/**
 * Created by marcosmagalhaes on 29/11/15.
 */
public class FormularioListAdapter extends RecyclerView.Adapter<FormularioListAdapter.ViewHolder>{

    private List<Formulario> mListFormulario;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView situacao;
        public TextView nome;
        public TextView ufmunicipio;
        public TextView funcao;

        public ViewHolder(View v) {
            super(v);
            situacao = (ImageView) v.findViewById(R.id.situacao);
            nome = (TextView) v.findViewById(R.id.nome);
            ufmunicipio = (TextView) v.findViewById(R.id.ufmunicipio);
            funcao = (TextView) v.findViewById(R.id.funcao);
        }
    }

    public void add(int position, Formulario item) {
        mListFormulario.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(String item) {
        int position = mListFormulario.indexOf(item);
        mListFormulario.remove(position);
        notifyItemRemoved(position);
    }

    public FormularioListAdapter(List<Formulario> listFormulario) {
        mListFormulario = listFormulario;
    }

    @Override
    public FormularioListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_formulario, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Formulario formulario = mListFormulario.get(position);
        holder.nome.setText(formulario.getNome());
        holder.ufmunicipio.setText("Estado".concat("/").concat("Municipio"));
        holder.funcao.setText("Funcao");

    }

    @Override
    public int getItemCount() {
        return mListFormulario.size();
    }


}
