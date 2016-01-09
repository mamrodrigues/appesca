package br.org.unesco.appesca.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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

        mValues.add(new ItemMenuLateral(1, "Identificação do entrevistado", R.layout.questao_identificacao));
        int[] questoesFormulario = ConstantesIdsFormularios.arrayIdsFragmentCamaraoRegional4Piores;
        for(int i=1; i<=9; i++){
            int idFormulario = getResources().getIdentifier("fcmr_reg_b1_q"+i, "layout", getPackageName());
            mValues.add(new ItemMenuLateral(i, "Questão "+i, idFormulario));
        }

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
                questao.setId(ultQuestPos);
                questao.setPerguntas(buildPerguntaList(questao.getId()));

                openFragment(++ultQuestPos, v);
            }
        });

        btnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ultQuestPos == 0){
                    return;
                }

                Questao questao = new Questao();
                questao.setId(ultQuestPos);
                questao.setPerguntas(buildPerguntaList(questao.getId()));

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

    private List<Pergunta> buildPerguntaList(int idQuestao){

        List<Pergunta> perguntas = new ArrayList<Pergunta>();

        /** PERGUNTAS **/
        for(int seqPergunta=1; seqPergunta<10; seqPergunta++){

            String currentPergunta = ConstantesIdsFormularios.PERGUNTA.concat(String.valueOf(seqPergunta));
            TextView perguntaTextView = (TextView) findViewById(getResources().getIdentifier(currentPergunta ,"id", getPackageName()));

            if(perguntaTextView != null) {
                List<Resposta> respostas = new ArrayList<Resposta>();

                Pergunta pergunta = new Pergunta();
                pergunta.setOrdem(seqPergunta);
                pergunta.setId(seqPergunta);
                pergunta.setIdQuestao(idQuestao);

                /** RADIOBUTTON **/
                for (int rb = 1; rb <= 10; rb++) {
                    String currentRadioButton = currentPergunta.concat(ConstantesIdsFormularios.TYPE_RADIO_BUTTON + rb);
                    RadioButton radioButton = (RadioButton) findViewById(getResources().getIdentifier(currentRadioButton, "id", getPackageName()));

                    if (radioButton != null && radioButton.isChecked()) {
                        Resposta resp = new Resposta();
                        resp.setOpcao(rb);
                        resp.setIdPergunta(pergunta.getId());
                        respostas.add(resp);
                        break;
                    }
                }

                /** CHECKBOX **/
                for (int cb = 1; cb <= 10; cb++) {
                    String currentCheckBox = currentPergunta.concat(ConstantesIdsFormularios.TYPE_CHECK_BOX + cb);
                    CheckBox checkBox = (CheckBox) findViewById(getResources().getIdentifier(currentCheckBox, "id", getPackageName()));

                    if (checkBox != null && checkBox.isChecked()) {
                        Resposta resp = new Resposta();
                        resp.setOpcao(cb);
                        resp.setIdPergunta(pergunta.getId());
                        respostas.add(resp);
                    }
                }

                /** EDITTEXT **/
                for (int et = 1; et <= 10; et++) {
                    String currentEditText = currentPergunta.concat(ConstantesIdsFormularios.TYPE_EDIT_TEXT + et);
                    EditText editText = (EditText) findViewById(getResources().getIdentifier(currentEditText, "id", getPackageName()));

                    if (editText != null && !editText.getText().toString().isEmpty()) {
                        Resposta resp = new Resposta();
                        resp.setTexto(editText.getText().toString());
                        resp.setIdPergunta(pergunta.getId());
                        respostas.add(resp);
                    }
                }
                pergunta.setRespostas(respostas);
                perguntas.add(pergunta);
            }
        }
        return perguntas;
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