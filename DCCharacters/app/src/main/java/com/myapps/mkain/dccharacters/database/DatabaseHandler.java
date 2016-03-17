package com.myapps.mkain.dccharacters.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.myapps.mkain.dccharacters.model.Character;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static DatabaseHandler instance;
    private Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "dcCharacters";
    private static final String TABLE_CHARACTERS = "characters";

    private static final String KEY_NAME = "name";
    private static final String KEY_REAL_NAME = "real_name";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMAGE_ID = "image_id";

    private DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static synchronized DatabaseHandler getInstance(Context context) {
        if (instance == null) {
            return instance = new DatabaseHandler(context.getApplicationContext());
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CHARACTERS + "("
                + KEY_NAME + " TEXT PRIMARY KEY,"
                + KEY_REAL_NAME + " TEXT,"
                + KEY_TITLE + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_IMAGE_ID + " INTEGER"
                + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARACTERS);
        onCreate(db);
    }

    public void addCharacter(Character character) {
        if (character == null) {
            throw new IllegalArgumentException();
        }

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, character.getName());
        values.put(KEY_REAL_NAME, character.getRealName());
        values.put(KEY_TITLE, character.getTitle());
        values.put(KEY_DESCRIPTION, character.getDescription());
        values.put(KEY_IMAGE_ID, character.getImageID());

        db.insert(TABLE_CHARACTERS, null, values);
        db.close();
    }

    public List<Character> getAllCharacters() {
        List<Character> CharacterList = new ArrayList<Character>();
        String selectQuery = "SELECT  * FROM " + TABLE_CHARACTERS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Character character = new Character();
                character.setName(cursor.getString(0));
                character.setRealName(cursor.getString(1));
                character.setTitle(cursor.getString(2));
                character.setDescription(cursor.getString(3));
                character.setImageID(Integer.parseInt(cursor.getString(4)));
                CharacterList.add(character);
            } while (cursor.moveToNext());
        }
        return CharacterList;
    }
}
