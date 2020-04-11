package com.example.cesar_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public String typo(String all, String search) {


        String[] words = all.split(", ");
        int verdadeiro = 0;

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() == search.length()) {
                int count = 0;
                for (int j = 0; j < words[i].length(); j++) {

                    if (words[i].charAt(j) == search.charAt(j)) count++;

                }
                if (count == words[i].length() || count == (words[i].length() - 1)) return(words[i]);

            } else {

                if (words[i].length() > search.length()) {
                    int count = 0, k = 0;

                    for (int j = 0; j < words[i].length(); j++) {
                        if (words[i].charAt(j) == search.charAt(k)) {
                            count++;
                            k++;
                            if (k == search.length()) k--;
                        }
                    }

                    if (count == search.length()) {
                        return(words[i]);
                    }
                }

            }

        }
        return invertedString(all,search);
    }

    public String invertedString(String all, String search){
        String[] words = all.split(", ");

        for(int i = 0; i < words.length; i++ ) {
            int falso = 0;
            if (words[i].length() == search.length()) {
                if (words[i].charAt(0) == search.charAt(0)) {

                    for (int j = 1; j < words[i].length() - 1; j++) {
                        if (words[i].charAt(j) == search.charAt(j)) {
                        } else {
                            if (words[i].charAt(j) == search.charAt(j + 1) || words[i].charAt(j) == search.charAt(j - 1)) {

                            } else falso = 1;

                        }
                    }
                } else falso = 1;
            } else falso = 1;

            if(falso == 0) return words[i];

        }
        return ("WE can't find this word " + search + " !!");
    }


    public void pesquisar (View view){

        EditText editText = (EditText) findViewById(R.id.editText5);
        String listWords = editText.getText().toString();

        EditText editText1 = (EditText) findViewById(R.id.editText);
        String search = editText1.getText().toString();


        TextView editText3 = (TextView) findViewById(R.id.textView3);
        String findword = typo(listWords,search);
        editText3.setText(findword);
    }
}
