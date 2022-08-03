package rakesh.app.mynotes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "MyNotes.db", null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table MyAllNotes(id primary key autoincrement,title TEXT , notes TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists MyAllNotes");
        onCreate(db);
    }

    public boolean InsertData(String title, String notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title",title);
        cv.put("notes",notes);

        long result =  db.insert("MyAllNotes", null,cv );
        if (result==-1){
            return false;
        }
        else {return true;
        }
    }
    public Cursor GetData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("Select * from MyAllNotes",null);
        return  c;

    }
    public boolean UpdateData(String title,String notes) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", title);
        cv.put("notes", notes);
        Cursor c = db.rawQuery("select * from MyAllNotes where title = ?", new String[]{title});
        if (c.getCount() > 0) {
            long result = db.update("MyAllNotes", cv, "title=?", new String[]{title});
            if (result == -1) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }

    public Boolean DeleteData(String title) {

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from MyAllNotes where title = ?", new String[]{title});
        if (c.getCount() > 0) {
            long result = db.delete("MyAllNotes","title=?", new String[]{title});
            if (result == -1) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }

    }
}
