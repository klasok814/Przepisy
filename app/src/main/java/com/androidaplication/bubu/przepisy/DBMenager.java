package com.androidaplication.bubu.przepisy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBMenager extends SQLiteOpenHelper {
    private static final String BASE_NAME = "Recipes.db";
    private static final int BASE_VERSION = 1;

    private static final String TABLE_BREAKFAST_NAME = "Breakfast";

    private static final String NAME = "Name";
    private static final String TIME = "Time";
    private static final String SERVES = "Serves";
    private static final String INGRIDIENTS = "Ingridients";
    private static final String DESCRIPTIONS = "Descriptions";

    public DBMenager(Context context) {
        super(context, BASE_NAME, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_BREAKFAST_NAME + "(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT," +
                TIME + " INTEGER," +
                SERVES + " INTEGER," +
                INGRIDIENTS + " TEXT," +
                DESCRIPTIONS + " TEXT);");

        addRecipeToDatabase(db, "Jajecznica z jarmużem", 10, 2, "4-5 liści jarmużu`4 jajka`szczypta soli`1 łyżka masła`1 łyżka mleka", "Jarmuż opłukuje i rwę na małe kawałki, grubsze łodyżki odrywam (o ile w ogóle są)`Na maśle przesmażam jarmuż przez chwilę, dorzucam jajka, doprawiam, dolewam odrobinę mleka i mieszam. Podaję, gdy jajka się zetną");
        addRecipeToDatabase(db, "Omlet śniadaniowy", 10, 2, "3 jajka`1-2 plasterki żółtego sera`2 plasterki wędliny`kawałek cukinii, papryki`sól, pieprz do smaku`łyżeczka oliwy", "Rozkłócam jajka razem z oliwą i przyprawami`Kroję cukinią, wędlinę, paprykę i ser. Wrzucam całość na patelnię i podsmażam (bez dodatkowego tłuszczu) aż się zetnie, ostrożnie odwracam na drugą stronę i chwilę podgrzewam.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecipeToDatabase(SQLiteDatabase db, String name, int time, int serves, String ingredients, String description){
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(TIME, time);
        values.put(SERVES, serves);
        values.put(INGRIDIENTS, ingredients);
        values.put(DESCRIPTIONS, description);
        db.insert(TABLE_BREAKFAST_NAME, null, values);
    }

    public Cursor readRecipeForDatabase(){
        String[] columns = {NAME, TIME, SERVES, INGRIDIENTS, DESCRIPTIONS};
        Recipe recipe = new Recipe();
        SQLiteDatabase db = getReadableDatabase();
        return db.query(TABLE_BREAKFAST_NAME, columns, null, null, null, null, null);
    }

}
