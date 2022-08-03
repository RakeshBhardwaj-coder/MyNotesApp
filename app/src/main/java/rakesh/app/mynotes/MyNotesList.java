package rakesh.app.mynotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyNotesList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> title,notes;
    DBHelper db;
    MyAdapter myAdapter;
    ImageView addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addBtn = findViewById(R.id.ivAddBtnBar);
        setContentView(R.layout.activity_my_notes_list);
        db = new DBHelper(this);
        title = new ArrayList<>();
        notes = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        myAdapter = new MyAdapter(this,title,notes);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

//        addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////
//
//            }
//        });
    }

    public void displayData() {

        Cursor c = db.GetData();
        if(c.getCount() == 0){
            Toast.makeText(getApplicationContext(),"Data is null",Toast.LENGTH_SHORT).show();
            return;
        }else {
            while (c.moveToNext()){
                title.add(c.getString(0));
                notes.add(c.getString(1));
            }
        }

    }
    public  void AddBtnClick(View view){
        Toast.makeText(getApplicationContext(),"AddBtn Clicked",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
       startActivity(i);
    }
}