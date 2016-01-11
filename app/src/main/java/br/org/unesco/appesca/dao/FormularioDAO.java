package br.org.unesco.appesca.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.org.unesco.appesca.model.Formulario;

/**
 * Created by marcosmagalhaes on 07/01/2015.
 */
public class FormularioDAO {

    private Context context;
    private AppescaHelper appescaHelper;

    public FormularioDAO(Context context){
        this.context = context;
        appescaHelper = new AppescaHelper(this.context);
    }

    public Formulario insertFormulario(Formulario formulario){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_FORMULARIO_NOME, formulario.getNome());
        String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm a").format(formulario.getDataAplicacao());
        values.put(AppescaHelper.COL_FORMULARIO_DATA_APLICACAO, dateFormat);
        values.put(AppescaHelper.COL_FORMULARIO_ID_USUARIO, formulario.getIdUsuario());
        values.put(AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO, formulario.getIdTipoFormulario());
        values.put(AppescaHelper.COL_FORMULARIO_SITUACAO, formulario.isEnviado());

        long id = db.insert(AppescaHelper.TABLE_FORMULARIO, null, values);
        return getFormularioById((int)id);
    }

    public void updateFormulario(Formulario formulario){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_FORMULARIO_ID, formulario.getId());
        values.put(AppescaHelper.COL_FORMULARIO_NOME, formulario.getNome());
        String dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm a").format(formulario.getDataAplicacao());
        values.put(AppescaHelper.COL_FORMULARIO_DATA_APLICACAO, dateFormat);
        values.put(AppescaHelper.COL_FORMULARIO_ID_USUARIO, formulario.getIdUsuario());
        values.put(AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO, formulario.getIdTipoFormulario());

        db.update(AppescaHelper.TABLE_FORMULARIO, values,
                AppescaHelper.COL_FORMULARIO_ID + " = ?",
                new String[]{String.valueOf(formulario.getId())});
    }

    public void deleteFormularioById(int idFormulario){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        db.delete(AppescaHelper.TABLE_FORMULARIO, AppescaHelper.COL_FORMULARIO_ID + " = ?",
                new String[]{String.valueOf(idFormulario)});
    }

    public List<Formulario> getAllFormularios() {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_FORMULARIO_ID + " , " +
                        AppescaHelper.COL_FORMULARIO_NOME + " , " +
                        AppescaHelper.COL_FORMULARIO_DATA_APLICACAO + " , " +
                        AppescaHelper.COL_FORMULARIO_ID_USUARIO+ " , " +
                        AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO+
                        " FROM " + AppescaHelper.TABLE_FORMULARIO, null);
        cursor.moveToFirst();

        List<Formulario> formularioList = new ArrayList<Formulario>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Formulario formulario = new Formulario();
            formulario.setId(cursor.getInt(0));
            formulario.setNome(cursor.getString(1));
            try {
                formulario.setDataAplicacao(new SimpleDateFormat("dd-MM-yyyy HH:mm a").parse(cursor.getString(2)));
            } catch (ParseException e) {
                Log.e("FormularioDAO", "Erro ao efetuar o parse da data.");
            }
            formulario.setIdUsuario(cursor.getInt(3));
            formulario.setIdTipoFormulario(cursor.getInt(4));

            formularioList.add(formulario);
            cursor.moveToNext();
        }
        return formularioList;
    }
    public Formulario getFormularioById(int idFormulario) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_FORMULARIO_ID + " , " +
                        AppescaHelper.COL_FORMULARIO_NOME + " , " +
                        AppescaHelper.COL_FORMULARIO_DATA_APLICACAO + " , " +
                        AppescaHelper.COL_FORMULARIO_ID_USUARIO+ " , " +
                        AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO+
                        " FROM " + AppescaHelper.TABLE_FORMULARIO +
                        " WHERE " + AppescaHelper.COL_FORMULARIO_ID + " = ?", new String[]{String.valueOf(idFormulario)});
        cursor.moveToFirst();

        Formulario formulario = new Formulario();
        formulario.setId(cursor.getInt(0));
        formulario.setNome(cursor.getString(1));
        try {
            formulario.setDataAplicacao(new SimpleDateFormat("dd-MM-yyyy HH:mm a").parse(cursor.getString(2)));
        } catch (ParseException e) {
            Log.e("FormularioDAO", "Erro ao efetuar o parse da data.");
        }
        formulario.setIdUsuario(cursor.getInt(3));
        formulario.setIdTipoFormulario(cursor.getInt(4));

        return formulario;
    }


    public List<Formulario> getFormulariosByUsuario(int idUsuario) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_FORMULARIO_ID + " , " +
                        AppescaHelper.COL_FORMULARIO_NOME + " , " +
                        AppescaHelper.COL_FORMULARIO_DATA_APLICACAO + " , " +
                        AppescaHelper.COL_FORMULARIO_ID_USUARIO+ " , " +
                        AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO+
                        " FROM " + AppescaHelper.TABLE_FORMULARIO +
                        " WHERE " + AppescaHelper.COL_FORMULARIO_ID_USUARIO + " = ?", new String[]{String.valueOf(idUsuario)});
        cursor.moveToFirst();

        List<Formulario> formularioList = new ArrayList<Formulario>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Formulario formulario = new Formulario();
            formulario.setId(cursor.getInt(0));
            formulario.setNome(cursor.getString(1));
            try {
                formulario.setDataAplicacao(new SimpleDateFormat("dd-MM-yyyy HH:mm a").parse(cursor.getString(2)));
            } catch (ParseException e) {
                Log.e("FormularioDAO", "Erro ao efetuar o parse da data.");
            }
            formulario.setIdUsuario(cursor.getInt(3));
            formulario.setIdTipoFormulario(cursor.getInt(4));

            formularioList.add(formulario);
            cursor.moveToNext();
        }
        return formularioList;
    }

    public List<Formulario> getFormulariosByTipoFormulario(int idTipoFormulariosuario) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_FORMULARIO_ID + " , " +
                        AppescaHelper.COL_FORMULARIO_NOME + " , " +
                        AppescaHelper.COL_FORMULARIO_DATA_APLICACAO + " , " +
                        AppescaHelper.COL_FORMULARIO_ID_USUARIO+ " , " +
                        AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO+
                        " FROM " + AppescaHelper.TABLE_FORMULARIO +
                        " WHERE " + AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO + " = ?", new String[]{String.valueOf(idTipoFormulariosuario)});
        cursor.moveToFirst();

        List<Formulario> formularioList = new ArrayList<Formulario>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Formulario formulario = new Formulario();
            formulario.setId(cursor.getInt(0));
            formulario.setNome(cursor.getString(1));
            try {
                formulario.setDataAplicacao(new SimpleDateFormat("dd-MM-yyyy HH:mm a").parse(cursor.getString(2)));
            } catch (ParseException e) {
                Log.e("FormularioDAO", "Erro ao efetuar o parse da data.");
            }
            formulario.setIdUsuario(cursor.getInt(3));
            formulario.setIdTipoFormulario(cursor.getInt(4));

            formularioList.add(formulario);
            cursor.moveToNext();
        }
        return formularioList;
    }

    public List<Formulario> getFormulariosByUsuarioAndTipoFormulario(int idUsuario, int idTipoFormulario) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_FORMULARIO_ID + " , " +
                        AppescaHelper.COL_FORMULARIO_NOME + " , " +
                        AppescaHelper.COL_FORMULARIO_DATA_APLICACAO + " , " +
                        AppescaHelper.COL_FORMULARIO_ID_USUARIO+ " , " +
                        AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO+
                        " FROM " + AppescaHelper.TABLE_FORMULARIO +
                        " WHERE " + AppescaHelper.COL_FORMULARIO_ID_USUARIO + " = ?"+
                        " AND "+ AppescaHelper.COL_FORMULARIO_ID_TIPO_FORMULARIO + " = ?", new String[]{String.valueOf(idUsuario), String.valueOf(idTipoFormulario)});
        cursor.moveToFirst();

        List<Formulario> formularioList = new ArrayList<Formulario>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Formulario formulario = new Formulario();
            formulario.setId(cursor.getInt(0));
            formulario.setNome(cursor.getString(1));
            try {
                formulario.setDataAplicacao(new SimpleDateFormat("dd-MM-yyyy HH:mm a").parse(cursor.getString(2)));
            } catch (ParseException e) {
                Log.e("FormularioDAO", "Erro ao efetuar o parse da data.");
            }
            formulario.setIdUsuario(cursor.getInt(3));
            formulario.setIdTipoFormulario(cursor.getInt(4));

            formularioList.add(formulario);
            cursor.moveToNext();
        }
        return formularioList;
    }
}