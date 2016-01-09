package br.org.unesco.appesca.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.org.unesco.appesca.R;
import br.org.unesco.appesca.control.QuestaoDetailFragment;
import br.org.unesco.appesca.model.Formulario;
import br.org.unesco.appesca.model.ItemMenuLateral;
import br.org.unesco.appesca.model.Pergunta;
import br.org.unesco.appesca.model.Questao;
import br.org.unesco.appesca.model.Resposta;
import br.org.unesco.appesca.util.ConstantesIdsFormularios;


public class FormularioCamaraoActivity extends AppCompatActivity {

    private boolean mTwoPane;

    private static Formulario formulario = new Formulario();

    private static int ultQuestPos = 0;

    private Button btnProx;
    private Button btnAnt;

   static List<ItemMenuLateral> mValues = new ArrayList<ItemMenuLateral>();

    static {
        mValues.add(new ItemMenuLateral(1, "Identificação do entrevistado", R.layout.questao_identificacao));
//        int[] questoesFormulario = ConstantesIdsFormularios.arrayIdsFragmentCamaraoRegional4Piores;
        for(int i=1; i<=9; i++){
            //int idFormulario = Resources.getSystem().getIdentifier("fcrj_b1_q" + i + ".xml", "layout", FormularioCamaraoActivity.getPackageName());
           // mValues.add(new ItemMenuLateral(i, "Questão "+i, idFormulario));
        }
    }

    public void openFragment(int position, View v){
        if (mTwoPane) {
            Bundle arguments = new Bundle();
            arguments.putString(QuestaoDetailFragment.ARG_ITEM_ID, String.valueOf(mValues.get(position).id_layout_inflate));
            QuestaoDetailFragment fragment = new QuestaoDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.questao_detail_container, fragment)
                    .commit();
        } else {
            Context context = v.getContext();
            Intent intent = new Intent(context, QuestaoDetailActivity.class);
            intent.putExtra(QuestaoDetailFragment.ARG_ITEM_ID, mValues.get(position).id);

            context.startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questao_list);

        formulario = new Formulario();

        btnProx = (Button) findViewById(R.id.btnQuestProx) ;
        btnAnt = (Button) findViewById(R.id.btnQuestAnterior) ;

        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ultQuestPos == mValues.size()-1){
                    return;
                }

                Questao questao = new Questao();


                //PEGANDO AS RESPOSTAS
                for(int i=1; i<10; i++){
                    Pergunta perg = new Pergunta();

                    //PEGANDO RESPOSTA DA PERGUNTA CORRENTE
                    //TODO CONSTRUIR ARRAY?

                    //POSIBILIDADE 1 -> RADIOBUTTONS
                    for(int radI=1; radI<=10; radI++) {
                        try {
                            //RadioButton radioButton = new RadioButton();

                            Resposta resp = new Resposta();

                            //perg.addResposta(resp);
                            break;
                        } catch (Exception e) {

                            break;
                        }
                    }


                    //POSSIBILIDADE 2 -> CHECKBOX
                    for(int radI=1; radI<=10; radI++) {
                        try {
//                            CHECKBOX check =

                            Resposta resp = new Resposta();

                            //perg.addResposta(resp);
                            break;
                        } catch (Exception e) {

                            break;
                        }
                    }

                    //questao.addPergunta(perg);

                }

                openFragment(++ultQuestPos, v);
            }
        });

        btnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ultQuestPos == 0){
                    return;
                }

                openFragment(--ultQuestPos, v);

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        View recyclerView = findViewById(R.id.questao_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

        if (findViewById(R.id.questao_detail_container) != null) {
            mTwoPane = true;
        }
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView){

        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(mValues));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {


        public SimpleItemRecyclerViewAdapter(List<ItemMenuLateral> items) {


        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.questao_list_title, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mItem = mValues.get(position);
            holder.mTitleView.setText(mValues.get(position).title);

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openFragment(FormularioCamaraoActivity.ultQuestPos = position, v);
                }
            });
        }


        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mTitleView;

            public RadioGroup mRadioGroup;
            public ItemMenuLateral mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mTitleView = (TextView) view.findViewById(R.id.title);
//                mRadioGroup =  (RadioGroup) view.findViewById()
            }

        }
    }
}