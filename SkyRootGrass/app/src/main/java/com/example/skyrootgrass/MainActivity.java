package com.example.skyrootgrass;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView letter;
    private TextView result;
    private Button getLetter;
    private Button skyButton;
    private Button rootButton;
    private Button grassButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        letter = findViewById(R.id.letter);
        result = findViewById(R.id.result);
        getLetter = findViewById(R.id.getLetter);
        skyButton = findViewById(R.id.sky);
        rootButton = findViewById(R.id.root);
        grassButton = findViewById(R.id.grass);


//        Creating arrays of alphabets, sky, root and grass letters
        char alphabets[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char sky[] = {'b', 'd', 'f', 'h', 'k', 'l', 't'};
        char root[] = {'g', 'j', 'p', 'q', 'y'};
        char grass[] = {'a', 'c', 'e', 'i', 'm', 'n', 'o', 'r', 's', 'u', 'v', 'w', 'x', 'z'};
        final int[] randomLetterIdx = new int[1];
        final String[] s = new String[1];

        getLetter.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                randomLetterIdx[0] = (int) (Math.random() * 26);
                s[0] = Character.toString(alphabets[randomLetterIdx[0]]);
                letter.setText(s[0]);
                result.setText("Answer");
                skyButton.setClickable(TRUE);
                rootButton.setClickable(TRUE);
                grassButton.setClickable(TRUE);
                getLetter.setClickable(FALSE);
            }
        });

        skyButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                getLetter.setClickable(TRUE);
                boolean letterBool = IsSky(sky, s[0]);
                if(letterBool){
                    result.setText("CORRECT!");
                }
                else{
                    result.setText("WRONG");
                }
            }
        });

        rootButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                getLetter.setClickable(TRUE);
                boolean letterBool = IsRoot(root, s[0]);
                if(letterBool){
                    result.setText("CORRECT!");
                }
                else{
                    result.setText("WRONG");
                }

            }
        });

        grassButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                getLetter.setClickable(TRUE);
                boolean letterBool = IsGrass(grass, s[0]);
                if(letterBool){
                    result.setText("CORRECT!");
                }
                else{
                    result.setText("WRONG");
                }
            }
        });

    }

    @SuppressLint("SetTextI18n")
    public boolean IsSky(char[] sky, String letter){
        for (int i = 0; i < sky.length; i++) {
            if (letter.equals(Character.toString(sky[i]))) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint("SetTextI18n")
    public boolean IsRoot(char[] root, String letter){
        for (int i = 0; i < root.length; i++) {
            if (letter.equals(Character.toString(root[i]))) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint("SetTextI18n")
    public boolean IsGrass(char[] grass, String letter){
        for (int i = 0; i < grass.length; i++) {
            if (letter.equals(Character.toString(grass[i]))) {
                return true;
            }
        }
        return false;
    }
}