package com.example.jordir.a3listexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> dummyItems;
    private ListView list;
    private ArrayAdapter<String> itemsAdapter;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.todoList);
        editText = (EditText) findViewById(R.id.editTextTodo);
        Button button = (Button) findViewById(R.id.buttonAdd);

        getDummyItems();
        itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dummyItems);
        list.setAdapter(itemsAdapter);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dummyItems.add(editText.getText().toString());
                itemsAdapter.notifyDataSetChanged();
                editText.setText("");
            }
        });

    }

    public ArrayList<String> getDummyItems() {
        dummyItems = new ArrayList<>();
        for (int i=1; i<=5; i++){
            dummyItems.add("List element " + i);
        }
        return dummyItems;
    }
}
