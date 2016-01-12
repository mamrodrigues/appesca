package br.org.unesco.appesca.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.org.unesco.appesca.enums.PerfilEnum;
import br.org.unesco.appesca.model.Usuario;

/**
 * Created by marcosmagalhaes on 08/01/16.
 */
public class UsuarioDAO {

    private Context context;
    private AppescaHelper appescaHelper;

    public UsuarioDAO(Context context){
        this.context = context;
        appescaHelper = new AppescaHelper(this.context);
    }

    public void insertUsuario(Usuario usuario){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_USUARIO_NOME, usuario.getNome());
        values.put(AppescaHelper.COL_USUARIO_ENDERECO, usuario.getEndereco());
        values.put(AppescaHelper.COL_USUARIO_LOGIN, usuario.getLogin());
        values.put(AppescaHelper.COL_USUARIO_SENHA, usuario.getSenha());
        values.put(AppescaHelper.COL_USUARIO_PERFIL, usuario.getPerfil().getValor());

        db.insert(AppescaHelper.TABLE_USUARIO, null, values);
    }

    public void updateUsuario(Usuario usuario){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_USUARIO_ID, usuario.getId());
        values.put(AppescaHelper.COL_USUARIO_NOME, usuario.getNome());
        values.put(AppescaHelper.COL_USUARIO_ENDERECO, usuario.getEndereco());
        values.put(AppescaHelper.COL_USUARIO_LOGIN, usuario.getLogin());
        values.put(AppescaHelper.COL_USUARIO_SENHA, usuario.getSenha());
        values.put(AppescaHelper.COL_USUARIO_PERFIL, usuario.getPerfil().getValor());

        db.update(AppescaHelper.TABLE_USUARIO, values,
                AppescaHelper.COL_USUARIO_ID + " = ?",
                new String[]{String.valueOf(usuario.getId())});
    }

    public void deleteUsuarioById(int idUsuario){
        SQLiteDatabase db = appescaHelper.getWritableDatabase();

        db.delete(AppescaHelper.TABLE_USUARIO, AppescaHelper.COL_USUARIO_ID + " = ?",
                new String[]{String.valueOf(idUsuario)});
    }

    public List<Usuario> getAllUsuario() {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_USUARIO_ID + " , " +
                        AppescaHelper.COL_USUARIO_NOME + " , " +
                        AppescaHelper.COL_USUARIO_ENDERECO + " , " +
                        AppescaHelper.COL_USUARIO_LOGIN + " , " +
                        AppescaHelper.COL_USUARIO_SENHA + " , " +
                        AppescaHelper.COL_USUARIO_PERFIL +
                        " FROM " + AppescaHelper.TABLE_USUARIO, null);
        cursor.moveToFirst();

        List<Usuario> usuarioList = new ArrayList<Usuario>();

        for (int i = 0; i < cursor.getCount(); i++) {
            Usuario u = new Usuario();
            u.setId(cursor.getInt(0));
            u.setNome(cursor.getString(1));
            u.setEndereco(cursor.getString(2));
            u.setLogin(cursor.getString(3));
            u.setSenha(cursor.getString(4));

            switch (cursor.getInt(5)){
                case 1 : u.setPerfil(PerfilEnum.ADMINISTRADOR); break;
                case 2 : u.setPerfil(PerfilEnum.COORDENADOR); break;
                case 3 : u.setPerfil(PerfilEnum.DEGRAVADOR); break;
                case 4 : u.setPerfil(PerfilEnum.PESQUISADOR); break;
            }

            usuarioList.add(u);
            cursor.moveToNext();
        }
        return usuarioList;
    }

    public Usuario getUsuarioByLogin(String login) {
        SQLiteDatabase db = appescaHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_USUARIO_ID + " , " +
                        AppescaHelper.COL_USUARIO_NOME + " , " +
                        AppescaHelper.COL_USUARIO_ENDERECO + " , " +
                        AppescaHelper.COL_USUARIO_LOGIN+ " , " +
                        AppescaHelper.COL_USUARIO_SENHA + " , " +
                        AppescaHelper.COL_USUARIO_PERFIL +
                        " FROM " + AppescaHelper.TABLE_USUARIO +
                        " WHERE " + AppescaHelper.COL_USUARIO_LOGIN + " = ?", new String[]{login});
        cursor.moveToFirst();

        Usuario u = new Usuario();
        u.setId(cursor.getInt(0));
        u.setNome(cursor.getString(1));
        u.setEndereco(cursor.getString(2));
        u.setLogin(cursor.getString(3));
        u.setSenha(cursor.getString(4));
        switch (cursor.getInt(5)){
            case 1 : u.setPerfil(PerfilEnum.ADMINISTRADOR); break;
            case 2 : u.setPerfil(PerfilEnum.COORDENADOR); break;
            case 3 : u.setPerfil(PerfilEnum.DEGRAVADOR); break;
            case 4 : u.setPerfil(PerfilEnum.PESQUISADOR); break;
        }

        return u;
    }
}
