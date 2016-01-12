package br.org.unesco.appesca.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.org.unesco.appesca.model.Questao;
import br.org.unesco.appesca.model.Resposta;

/**
 * Created by marcosmagalhaes on 09/01/16.
 */
public class RespostaDAO {

    private Context context;
    private AppescaHelper appescaHelper;

    public RespostaDAO(Context context){
        this.context = context;
        appescaHelper = new AppescaHelper(this.context);
    }

    public Resposta insertResposta(Resposta resposta){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_RESPOSTA_OPCAO, resposta.getOpcao());
        values.put(AppescaHelper.COL_RESPOSTA_TEXTO, resposta.getTexto());
        values.put(AppescaHelper.COL_RESPOSTA_AUDIO, resposta.getAudio());
        values.put(AppescaHelper.COL_RESPOSTA_ORDEM, resposta.getOrdem());
        values.put(AppescaHelper.COL_RESPOSTA_ID_PERGUNTA, resposta.getIdPergunta());

        long id = db.insert(AppescaHelper.TABLE_RESPOSTA, null,values);
        return findRespostaById((int)id);
    }

    public void updateResposta(Resposta resposta){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_RESPOSTA_ID, resposta.getId());
        values.put(AppescaHelper.COL_RESPOSTA_OPCAO, resposta.getOpcao());
        values.put(AppescaHelper.COL_RESPOSTA_TEXTO, resposta.getTexto());
        values.put(AppescaHelper.COL_RESPOSTA_AUDIO, resposta.getAudio());
        values.put(AppescaHelper.COL_RESPOSTA_ORDEM, resposta.getOrdem());
        values.put(AppescaHelper.COL_RESPOSTA_ID_PERGUNTA, resposta.getIdPergunta());

        db.update(AppescaHelper.TABLE_RESPOSTA, values,
                AppescaHelper.COL_RESPOSTA_ID + " = ?",
                new String[]{String.valueOf(resposta.getId())});
    }

    public void deleteRespostaById(int idResposta){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        db.delete(AppescaHelper.TABLE_RESPOSTA, AppescaHelper.COL_RESPOSTA_ID + " = ?",
                new String[]{String.valueOf(idResposta)});
    }

    public List<Resposta> findAllRespostas() {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_RESPOSTA_ID + " , " +
                        AppescaHelper.COL_RESPOSTA_OPCAO + " , " +
                        AppescaHelper.COL_RESPOSTA_TEXTO + " , " +
                        AppescaHelper.COL_RESPOSTA_AUDIO + " , " +
                        AppescaHelper.COL_RESPOSTA_ORDEM + " , " +
                        AppescaHelper.COL_RESPOSTA_ID_PERGUNTA +
                        " FROM " + AppescaHelper.TABLE_RESPOSTA, null);
        cursor.moveToFirst();

        List<Resposta> respostaList = new ArrayList<Resposta>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Resposta resposta = new Resposta();
            resposta.setId(cursor.getInt(0));
            resposta.setOpcao(cursor.getInt(1));
            resposta.setTexto(cursor.getString(2));
            resposta.setAudio(cursor.getBlob(3));
            resposta.setOrdem(cursor.getInt(4));
            resposta.setIdPergunta(cursor.getInt(5));

            respostaList.add(resposta);
            cursor.moveToNext();
        }
        return respostaList;
    }
    public Resposta findRespostaById(int idResposta) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_RESPOSTA_ID + " , " +
                        AppescaHelper.COL_RESPOSTA_OPCAO + " , " +
                        AppescaHelper.COL_RESPOSTA_TEXTO + " , " +
                        AppescaHelper.COL_RESPOSTA_AUDIO + " , " +
                        AppescaHelper.COL_RESPOSTA_ORDEM + " , " +
                        AppescaHelper.COL_RESPOSTA_ID_PERGUNTA +
                        " FROM " + AppescaHelper.TABLE_RESPOSTA +
                        " WHERE " + AppescaHelper.COL_RESPOSTA_ID + " = ?", new String[]{String.valueOf(idResposta)});

        Resposta resposta = null;
        if(cursor.moveToFirst()){
            resposta = new Resposta();
            resposta.setId(cursor.getInt(0));
            resposta.setOpcao(cursor.getInt(1));
            resposta.setTexto(cursor.getString(2));
            resposta.setAudio(cursor.getBlob(3));
            resposta.setOrdem(cursor.getInt(4));
            resposta.setIdPergunta(cursor.getInt(5));
        }
        return resposta;
    }

    public List<Resposta> findRespostasByPergunta(int idPergunta) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_RESPOSTA_ID + " , " +
                        AppescaHelper.COL_RESPOSTA_OPCAO + " , " +
                        AppescaHelper.COL_RESPOSTA_TEXTO + " , " +
                        AppescaHelper.COL_RESPOSTA_AUDIO + " , " +
                        AppescaHelper.COL_RESPOSTA_ORDEM + " , " +
                        AppescaHelper.COL_RESPOSTA_ID_PERGUNTA +
                        " FROM " + AppescaHelper.TABLE_RESPOSTA +
                        " WHERE " + AppescaHelper.COL_RESPOSTA_ID_PERGUNTA + " = ?", new String[]{String.valueOf(idPergunta)});
        cursor.moveToFirst();

        List<Resposta> respostaList = new ArrayList<Resposta>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Resposta resposta = new Resposta();
            resposta.setId(cursor.getInt(0));
            resposta.setOpcao(cursor.getInt(1));
            resposta.setTexto(cursor.getString(2));
            resposta.setAudio(cursor.getBlob(3));
            resposta.setOrdem(cursor.getInt(4));
            resposta.setIdPergunta(cursor.getInt(5));

            respostaList.add(resposta);
            cursor.moveToNext();
        }
        return respostaList;
    }

    public Resposta findRespostaByOrdemIdPergunta(int ordem, int idPergunta) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_RESPOSTA_ID + " , " +
                        AppescaHelper.COL_RESPOSTA_OPCAO + " , " +
                        AppescaHelper.COL_RESPOSTA_TEXTO + " , " +
                        AppescaHelper.COL_RESPOSTA_AUDIO + " , " +
                        AppescaHelper.COL_RESPOSTA_ORDEM + " , " +
                        AppescaHelper.COL_RESPOSTA_ID_PERGUNTA +
                        " FROM " + AppescaHelper.TABLE_RESPOSTA +
                        " WHERE " + AppescaHelper.COL_RESPOSTA_ORDEM + " = ?"+
                        " AND " + AppescaHelper.COL_RESPOSTA_ID_PERGUNTA + " = ?", new String[]{String.valueOf(ordem), String.valueOf(idPergunta)});

        Resposta resposta = null;
        if(cursor.moveToFirst()){
            resposta = new Resposta();
            resposta.setId(cursor.getInt(0));
            resposta.setOpcao(cursor.getInt(1));
            resposta.setTexto(cursor.getString(2));
            resposta.setAudio(cursor.getBlob(3));
            resposta.setOrdem(cursor.getInt(4));
            resposta.setIdPergunta(cursor.getInt(5));
        }
        return resposta;
    }
}
