package com.example.demo_meet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class shared_preferences extends AppCompatActivity {
    private EditText name, age;
    SharedPreferences sharedpreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        name = findViewById(R.id.edit1);
        age = findViewById(R.id.edit2);


    }

    protected void onResume() {
        super.onResume();
        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sh.getString("name", "");
        int a = sh.getInt("age", 1);
        name.setText(s1);
        age.setText(String.valueOf(a));

    }

    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("name", name.getText().toString());
        myEdit.putInt("age", Integer.parseInt(age.getText().toString()));
        myEdit.commit();
    }

    public void Save(View view) {
        String n = name.getText().toString();
        int e = Integer.parseInt(age.getText().toString());
        SharedPreferences.Editor myEdit = sharedpreferences.edit();
        Toast.makeText(getApplicationContext(),"Saved your data..",Toast.LENGTH_LONG).show();
        myEdit.putString("Name" ,n);
        myEdit.putInt("Email", e);
        myEdit.commit();

    }

}