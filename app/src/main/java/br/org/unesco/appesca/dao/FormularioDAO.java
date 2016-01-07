package br.org.unesco.appesca.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcosmagalhaes on 06/01/2015.
 */
public class FormularioDAO {

    private Context context;
    private AppescaHelper appescaHelper;

    public FormularioDAO(Context context){
        this.context = context;
        appescaHelper = new AppescaHelper(this.context);
    }

 /**   public void insertCoordinate(Coordinate coordinate){
        SQLiteDatabase db = bbPlantarHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_POLYGON_ID, coordinate.getmIdPolygon());
        values.put(AppescaHelper.COL_COORDINATE_LATITUDE, coordinate.getmLatitude());
        values.put(AppescaHelper.COL_COORDINATE_LONGITUDE, coordinate.getmLongitude());
        values.put(AppescaHelper.COL_COORDINATE_SEQ, coordinate.getmSequence());
        values.put(AppescaHelper.COL_COORDINATE_TIME_STAMP, coordinate.getmTimeStamp());

        db.insert(AppescaHelper.TABLE_COORDINATE_NAME, null,values);
    }

    public void updateCoordinate(Coordinate coordinate){
        SQLiteDatabase db = bbPlantarHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AppescaHelper.COL_COORDINATE_ID, coordinate.getmId());
        values.put(AppescaHelper.COL_POLYGON_ID, coordinate.getmIdPolygon());
        values.put(AppescaHelper.COL_COORDINATE_LATITUDE, coordinate.getmLatitude());
        values.put(AppescaHelper.COL_COORDINATE_LONGITUDE, coordinate.getmLongitude());
        values.put(AppescaHelper.COL_COORDINATE_SEQ, coordinate.getmSequence());
        values.put(AppescaHelper.COL_COORDINATE_TIME_STAMP, coordinate.getmTimeStamp());

        db.update(AppescaHelper.TABLE_COORDINATE_NAME, values,
                AppescaHelper.COL_COORDINATE_ID + " = ?",
                new String[]{String.valueOf(coordinate.getmId())});
    }

    public void deleteCoordinatesByPolygon(int idPolygon){
        SQLiteDatabase db = bbPlantarHelper.getWritableDatabase();

        db.delete(AppescaHelper.TABLE_COORDINATE_NAME, AppescaHelper.COL_POLYGON_ID + " = ?",
                new String[]{String.valueOf(idPolygon)});
    }

    public List<Coordinate> getCoordinatesByPolygons(int idPolygon) {
        SQLiteDatabase db = bbPlantarHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(
                "SELECT " + AppescaHelper.COL_COORDINATE_ID + " , " +
                        AppescaHelper.COL_POLYGON_ID+ " , " +
                        AppescaHelper.COL_COORDINATE_LATITUDE + " , " +
                        AppescaHelper.COL_COORDINATE_LONGITUDE + " , " +
                        AppescaHelper.COL_COORDINATE_SEQ + " , " +
                        AppescaHelper.COL_COORDINATE_TIME_STAMP +
                        " FROM " + AppescaHelper.TABLE_COORDINATE_NAME+
                        " WHERE "+ AppescaHelper.COL_POLYGON_ID +" = ?", new String[]{String.valueOf(idPolygon)});
        cursor.moveToFirst();

        List<Coordinate> coordinateList = new ArrayList<Coordinate>();
        for (int i = 0; i < cursor.getCount(); i++) {
            Coordinate c = new Coordinate();
            c.setmId(cursor.getInt(0));
            c.setmIdPolygon(cursor.getInt(1));
            c.setmLatitude(cursor.getDouble(2));
            c.setmLongitude(cursor.getDouble(3));
            c.setmSequence(cursor.getInt(4));
            c.setmTimeStamp(cursor.getString(5));

            coordinateList.add(c);
            cursor.moveToNext();
        }

        return coordinateList;

    } **/
}