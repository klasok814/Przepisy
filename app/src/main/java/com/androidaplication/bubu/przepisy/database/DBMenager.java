package com.androidaplication.bubu.przepisy.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.androidaplication.bubu.przepisy.recipes.Recipe;

public class DBMenager extends SQLiteOpenHelper {
    private static final String BASE_NAME = "Recipes.db";
    private static final int BASE_VERSION = 1;

    public static final String TABLE_BREAKFAST_NAME = "Breakfast";
    public static final String TABLE_SNACKS_NAME = "Snacks";
    public static final String TABLE_SALADS_NAME = "Salads";
    public static final String TABLE_SOUPS_NAME = "Soups";
    public static final String TABLE_CAKES_NAME = "Cakes";
    public static final String TABLE_DRINKS_NAME = "Drinks";

    private static final String NAME = "Name";
    private static final String TIME = "Time";
    private static final String SERVES = "Serves";
    private static final String INGRIDIENTS = "Ingridients";
    private static final String DESCRIPTIONS = "Descriptions";

    private static final String CREATE_TABLE = "CREATE TABLE %s (" +
            "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            NAME + " TEXT," +
            TIME + " INTEGER," +
            SERVES + " INTEGER," +
            INGRIDIENTS + " TEXT," +
            DESCRIPTIONS + " TEXT);";

    public DBMenager(Context context) {
        super(context, BASE_NAME, null, BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format(CREATE_TABLE, TABLE_BREAKFAST_NAME));
        db.execSQL(String.format(CREATE_TABLE, TABLE_SNACKS_NAME));
        db.execSQL(String.format(CREATE_TABLE, TABLE_SALADS_NAME));
        db.execSQL(String.format(CREATE_TABLE, TABLE_SOUPS_NAME));
        db.execSQL(String.format(CREATE_TABLE, TABLE_CAKES_NAME));
        db.execSQL(String.format(CREATE_TABLE, TABLE_DRINKS_NAME));


        addRecipeToDatabase(db, TABLE_BREAKFAST_NAME, "Jajecznica z jarmużem", 10, 2, "4-5 liści jarmużu`4 jajka`szczypta soli`1 łyżka masła`1 łyżka mleka", "Jarmuż opłukuje i rwę na małe kawałki, grubsze łodyżki odrywam (o ile w ogóle są)`Na maśle przesmażam jarmuż przez chwilę, dorzucam jajka, doprawiam, dolewam odrobinę mleka i mieszam. Podaję, gdy jajka się zetną");
        addRecipeToDatabase(db, TABLE_BREAKFAST_NAME, "Omlet śniadaniowy", 10, 2, "3 jajka`1-2 plasterki żółtego sera`2 plasterki wędliny`kawałek cukinii, papryki`sól, pieprz do smaku`łyżeczka oliwy", "Rozkłócam jajka razem z oliwą i przyprawami`Kroję cukinią, wędlinę, paprykę i ser. Wrzucam całość na patelnię i podsmażam (bez dodatkowego tłuszczu) aż się zetnie, ostrożnie odwracam na drugą stronę i chwilę podgrzewam.");
        addRecipeToDatabase(db, TABLE_BREAKFAST_NAME, "Śniadaniowe babeczki warzywne", 20, 10, "3 jajka`100 g ricotty (może być twaróg)`kilka plasterków żółtego sera np. mimolette`kawałek cukinii`garść świeżego szpinaku`kawałek papryk`łyżka siemienia lnianego`sól, pieprz do smaku", "Jajka i ricottę mieszam dokładnie, dodaję pokrojoną cukinię, przyprawy`Dorzucam siemię lniane, szpinak, ser mimolette (lub inny), doprawiam. Mieszam.`Nakładam do foremek. Uwaga! Najlepsze będą takie sztywniejsze foremki na muffiny lub ewentualnie silikonowe.`Wstawiamy do nagrzanego do 180C piekarnika i piekę ok. 15 minut.");

        addRecipeToDatabase(db, TABLE_SNACKS_NAME, "Pankejki bez mleka", 15, 8, "200 g mąki pszennej`ok. 250 ml wody`3 jajka`20-30g oleju`2 łyżki cukru lub przecieru owocowego`1/2 łyżeczki proszku do pieczenia", "Do miski wsypuję mąkę, dodaję wodę, proszek, przecier owocowy (może być cukier), olej, jajka i mieszam.`Ma być gęste i gładkie.`Nakładam pół łyżki na rozgrzaną patelnię (bez tłuszczu!). I smażę aż się zetnie, a potem odwracam na drugą stronę.");

        addRecipeToDatabase(db, TABLE_SALADS_NAME, "Letnia sałatka z arbuzem", 10, 4, "pół arbuza`180 g sera sałatkowego Turek Islos`1 szklanka rukoli świeżej`1,5 łyżki miodu`1 łyżka octu winnego`4–5 łyżek oliwy`sól, pieprz do smaku`1,5 łyżki sezamu", "Przygotowanie zaczynam od sosu. Wlewam ocet, dodaję miód, trochę soli i pieprzu do smaku i mieszam. Teraz stopniowo, cały czas mieszając, wlewam oliwę i mieszam, aż sos będzie gładki i taki świecący.`Arbuza kroję w kostkę, ser sałatkowy również w kostkę, do tego dokładam rukolę.`Polewam sosem, mieszam i z wierzchu posypuję całość uprażonym sezamem.");

        addRecipeToDatabase(db, TABLE_SOUPS_NAME, "Zupa dyniowa z imbirem", 20, 4, "mała dynia hokkaido ok. 1 kg`2 szklanki (mleko/śmietanka 18%)`2-3 cm imbiru świeżego`1/2 łyżeczki chili (lub 1/3)`szczypta cynamonu`szczypta soli`szczypta cukru`pół ząbka czosnku", "Dynię dzielę na pół, wyjmuję petki i owijam folią aluminiową. Piekę w 180C przez 30 minut, ja zazwyczaj robię to dzień wcześniej, więc nie wliczyłam tego czasu w przygotowanie zupy.`Obieram ze skórki, dodaję śmietankę, mleko, wciskam imbir (polecam przez praskę do czosnku - świetny efekt, a jeśli nie to na tarce o małych oczakach). Wciskam czosnek i blenduję całość.`Podgrzewam na małym ogniu, dodaję przyprawy. Ponieważ u mnie zupę jedzą dzieci to chili dodaję w dwóch partiach, szczyptę do smaku, a potem dla nas dorosłych więcej. Zagrzewam na małym ogniu mieszając, bo zupa jest gęsta. Podaję w kubku lub w misce, w razie potrzeby z grzankami.");

        addRecipeToDatabase(db, TABLE_CAKES_NAME, "Kulki kokosowe bez cukru", 10, 10, "100 g kokosa`ok. 40-50 g oleju kokosowego`1 łyżeczka miodu`truskawki lifilizowane", "Kokosowe wiórki mielę na mąkę w młynku, tak samo truskawki.`Do kokosa dodaję miód i roztopiony olej kokosowy i mieszam.`Formuję (ugniatając) kulki, obtaczam w truskawkach i wkładam do papierków. Chłodzę! Podaję po schłodzeniu.");

        addRecipeToDatabase(db, TABLE_DRINKS_NAME, "Koktajl ze szpinaku, pomarańczy i bananów", 5, 1, "dwie garści młodych liści szpinaku`jedna duża lub dwie małe pomarańcze`jeden banan`pół szklanki wody`opcjonalnie: dla lubiących słodsze napoje łyżka miodu (lub syropu klonowego)`jako nadprogramowy extra składnik możesz dodać np. dojrzałe mango`do udekorowania gotowego koktajlu warto użyć listków mięty i dowolnego rodzaju drobnych pestek (np. słonecznik, chia, siemię lniane), suszonych jagód goji czy naszych poczciwych czarnych jagód", "Przygotowanie koktajlu to żadna filozofia – owoce obierz ze skóry i podziel na mniejsze kawałki.`Następnie wszystkie składniki wrzuć do blendera i zmiksuj na najwyższym biegu, aż do uzyskania konsystencji gładkiego shake’a. Ważne, aby w trakcie picia nie były wyczuwalne większe drobiny owoców, czy liści szpinaku.`Taki koktajl owocowy polecam wszystkim jako odwyk od świątecznej diety i na co dzień dla osób trzymających dietę / dbających o linię. Jest to świetna propozycja zarówno na śniadanie jak i kolację.");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addRecipeToDatabase(SQLiteDatabase db, String tableName, String name, int time, int serves, String ingredients, String description){
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(TIME, time);
        values.put(SERVES, serves);
        values.put(INGRIDIENTS, ingredients);
        values.put(DESCRIPTIONS, description);
        db.insert(tableName, null, values);
    }

    public Cursor readRecipeForDatabase(String tableName){
        String[] columns = {NAME, TIME, SERVES, INGRIDIENTS, DESCRIPTIONS};
        Recipe recipe = new Recipe();
        SQLiteDatabase db = getReadableDatabase();
        return db.query(tableName, columns, null, null, null, null, null);
    }

}
