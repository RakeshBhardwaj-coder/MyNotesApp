package rakesh.app.mynotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    EditText etTitle, etNotes;
    Button saveData;

    String title,notes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.etText);
        etNotes = findViewById(R.id.etNote);
        saveData = findViewById(R.id.btnFillData);



        dbHelper = new DBHelper(this);



        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = etTitle.getText().toString();
                notes = etNotes.getText().toString();

                if(!title.isEmpty() && !notes.isEmpty()){
                boolean checkInsetData = dbHelper.InsertData(title,notes);
                if(checkInsetData){
                    Toast.makeText(getApplicationContext(),"data insert",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MyNotesList.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"data not insert",Toast.LENGTH_SHORT).show();

                }}
                else{
                    Toast.makeText(getApplicationContext(),"Please Insert Data!!!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void BackBtn(View view){
        Intent i = new Intent(getApplicationContext(),MyNotesList.class);
        startActivity(i);
    }

}