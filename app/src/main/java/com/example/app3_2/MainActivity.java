package com.example.app3_2;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
/*Vytvořte projekt, který bude obsahovat Edit pro zadání textu.
Pod tím budou 2 RadioButtony vedle sebe,
jeden pro zobrazení počtu písmen anglické abecedy a druhý pro zjištění počtu slov
(Slova jsou oddělena jednou nebo více mezerami).
 Napište metody. Pod tím bude TextView, kde budou počty zobrazeny.
 Vedle Editu bude CheckBox, který převede text na velká písmena a zobrazí do Toastu.
  Pod TextView bude tlačítko.Do TextView budeme psát Počet písmen je nebo Počet slov je, což budeme brát z popisku na RadioButtonu.
Obsloužíme událost OnClick tlačítka a událost onCheckedChanged CheckBoxu.
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        TextView textView = findViewById(R.id.textView);
        RadioButton radioButton = findViewById(R.id.radioButton);
        radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = countLetters(editText.getText().toString());
                textView.setText(radioButton.getText() + ": " + count);
            }
        });
        RadioButton radioButton2 = findViewById(R.id.radioButton2);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = countWords(editText.getText().toString());
                textView.setText(radioButton2.getText() + ": " + count);
            }
        });
        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String str = editText.getText().toString();
                str = str.toUpperCase();
                editText.setText(str);
            }
        });
    }

    public int countLetters(String txt) {
        int letters = 0;
        for(char c : txt.toCharArray()) {
            if(Character.isAlphabetic(c)) {letters++;}
        }
        return letters;
    }

    public int countWords(String txt) {
        int words = 0;
        for(String s : txt.split(" ")) {
            if(s.equals("")) {continue;}
            words++;
        }
        return words;
    }
}