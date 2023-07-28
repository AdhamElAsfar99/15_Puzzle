package com.example.the15puzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button [] numbers = new Button[16];
    int [] arr = new int[16];
    Button start, back;
    CheckBox test;
    TextView moves;
    int num_moves = 0;
    MediaPlayer buttonClick;
//    Switch switcher;
//    boolean nightMODE;
//    SharedPreferences sharedPreferences;
//    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

        /*getSupportActionBar().hide();
        switcher = findViewById(R.id.switcher);
        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE);
        nightMODE = sharedPreferences.getBoolean("night", false);
        if(nightMODE)
        {
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nightMODE)
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                }
                else
                {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply();
            }
        });*/

        numbers[0] = findViewById(R.id.num0);
        numbers[1] = findViewById(R.id.num1);
        numbers[2] = findViewById(R.id.num2);
        numbers[3] = findViewById(R.id.num3);
        numbers[4] = findViewById(R.id.num4);
        numbers[5] = findViewById(R.id.num5);
        numbers[6] = findViewById(R.id.num6);
        numbers[7] = findViewById(R.id.num7);
        numbers[8] = findViewById(R.id.num8);
        numbers[9] = findViewById(R.id.num9);
        numbers[10] = findViewById(R.id.num10);
        numbers[11] = findViewById(R.id.num11);
        numbers[12] = findViewById(R.id.num12);
        numbers[13] = findViewById(R.id.num13);
        numbers[14] = findViewById(R.id.num14);
        numbers[15] = findViewById(R.id.num15);

        test = findViewById(R.id.test_checkBox);
        start = findViewById(R.id.start_button);
        back = findViewById(R.id.back_button);
        moves = findViewById(R.id.moves_text);
        back.setVisibility(View.INVISIBLE);

        buttonClick = MediaPlayer.create(this, R.raw.button_click);

    }

    public boolean isSorted()
    {
        int x = 0;
        for(int i = 0; i < 16; i++)
        {
            if (x < arr[i])
            {
                x = arr[i];
            }
            else
            {
                if (!(i == 15))
                    return false;
            }
        }
        return true;
    }

    public void clickOnStart(View v)
    {
        start.setVisibility(View.INVISIBLE);
        test.setVisibility(View.INVISIBLE);
        back.setVisibility(View.VISIBLE);
        moves.setVisibility(View.VISIBLE);

        num_moves = 0;
        moves.setText("Moves: "+num_moves);
        arr = new int[16];
        if(!test.isChecked())
        {
            Random rand = new Random();

            //Fill the buttons with numbers from 1 to 15
            for (int i = 0; i < 15; i++) {
                int index;
                do {
                    index = rand.nextInt(16);
                } while (arr[index] != 0);
                arr[index] = i + 1;
            }
        }
        else
        {
            int count = 1;
            for (int i = 0; i < 16; i++)
            {
                arr[i] = count;
                count++;
            }
            arr[15] = 15;
            arr[14] = 0;
        }
        for (int i = 0; i < 16; i++) {
            if (arr[i] != 0)
                numbers[i].setText("" + arr[i]);
            else
                numbers[i].setText("");
        }
    }

    public void clickOnBack(View v)
    {
        start.setVisibility(View.VISIBLE);
        test.setVisibility(View.VISIBLE);
        back.setVisibility(View.INVISIBLE);
        moves.setVisibility(View.INVISIBLE);

        int count = 1;
        arr = new int[16];
        for (int i = 0; i < 16; i++)
        {
            arr[i] = count;
            count++;
        }
        arr[15] = 0;

        for (int i = 0; i < 16; i++) {
            if (arr[i] != 0)
                numbers[i].setText("" + arr[i]);
            else
                numbers[i].setText("");
        }

    }

    public void clickOnButton0(View v)
    {
        buttonClick.start();
        if(numbers[1].getText().toString() == "")
        {
            numbers[1].setText(numbers[0].getText().toString());
            numbers[0].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[1] = arr[0];
            arr[0] = 0;
        }
        else if(numbers[4].getText().toString() == "")
        {
            numbers[4].setText(numbers[0].getText().toString());
            numbers[0].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[4] = arr[0];
            arr[0] = 0;
        }
    }
    public void clickOnButton1(View v)
    {
        buttonClick.start();
        if(numbers[2].getText().toString() == "")
        {
            numbers[2].setText(numbers[1].getText().toString());
            numbers[1].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[2] = arr[1];
            arr[1] = 0;
        }
        else if(numbers[5].getText().toString() == "")
        {
            numbers[5].setText(numbers[1].getText().toString());
            numbers[1].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[5] = arr[1];
            arr[1] = 0;
        }
        else if(numbers[0].getText().toString() == "")
        {
            numbers[0].setText(numbers[1].getText().toString());
            numbers[1].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[0] = arr[1];
            arr[1] = 0;
        }
    }
    public void clickOnButton2(View v)
    {
        buttonClick.start();
        if(numbers[3].getText().toString() == "")
        {
            numbers[3].setText(numbers[2].getText().toString());
            numbers[2].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[3] = arr[2];
            arr[2] = 0;
        }
        else if(numbers[1].getText().toString() == "")
        {
            numbers[1].setText(numbers[2].getText().toString());
            numbers[2].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[1] = arr[2];
            arr[2] = 0;
        }
        else if(numbers[6].getText().toString() == "")
        {
            numbers[6].setText(numbers[2].getText().toString());
            numbers[2].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[6] = arr[2];
            arr[2] = 0;
        }
    }
    public void clickOnButton3(View v)
    {
        buttonClick.start();
        if(numbers[4].getText().toString() == "")
        {
            numbers[4].setText(numbers[3].getText().toString());
            numbers[3].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[4] = arr[3];
            arr[3] = 0;
        }
        else if(numbers[2].getText().toString() == "")
        {
            numbers[2].setText(numbers[3].getText().toString());
            numbers[3].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[2] = arr[3];
            arr[3] = 0;
        }
        else if(numbers[7].getText().toString() == "")
        {
            numbers[7].setText(numbers[3].getText().toString());
            numbers[3].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[7] = arr[3];
            arr[3] = 0;
        }
    }
    public void clickOnButton4(View v)
    {
        buttonClick.start();
        if(numbers[5].getText().toString() == "")
        {
            numbers[5].setText(numbers[4].getText().toString());
            numbers[4].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[5] = arr[4];
            arr[4] = 0;
        }
        else if(numbers[0].getText().toString() == "")
        {
            numbers[0].setText(numbers[4].getText().toString());
            numbers[4].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[0] = arr[4];
            arr[4] = 0;
        }
        else if(numbers[8].getText().toString() == "")
        {
            numbers[8].setText(numbers[4].getText().toString());
            numbers[4].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[8] = arr[4];
            arr[4] = 0;
        }
    }
    public void clickOnButton5(View v)
    {
        buttonClick.start();
        if(numbers[6].getText().toString() == "")
        {
            numbers[6].setText(numbers[5].getText().toString());
            numbers[5].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[6] = arr[5];
            arr[5] = 0;
        }
        else if(numbers[4].getText().toString() == "")
        {
            numbers[4].setText(numbers[5].getText().toString());
            numbers[5].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[4] = arr[5];
            arr[5] = 0;
        }
        else if(numbers[1].getText().toString() == "")
        {
            numbers[1].setText(numbers[5].getText().toString());
            numbers[5].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[1] = arr[5];
            arr[5] = 0;
        }
        else if(numbers[9].getText().toString() == "")
        {
            numbers[9].setText(numbers[5].getText().toString());
            numbers[5].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[9] = arr[5];
            arr[5] = 0;
        }
    }
    public void clickOnButton6(View v)
    {
        buttonClick.start();
        if(numbers[7].getText().toString() == "")
        {
            numbers[7].setText(numbers[6].getText().toString());
            numbers[6].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[7] = arr[6];
            arr[6] = 0;
        }
        else if(numbers[5].getText().toString() == "")
        {
            numbers[5].setText(numbers[6].getText().toString());
            numbers[6].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[5] = arr[6];
            arr[6] = 0;
        }
        else if(numbers[2].getText().toString() == "")
        {
            numbers[2].setText(numbers[6].getText().toString());
            numbers[6].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[2] = arr[6];
            arr[6] = 0;
        }
        else if(numbers[10].getText().toString() == "")
        {
            numbers[10].setText(numbers[6].getText().toString());
            numbers[6].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[10] = arr[6];
            arr[6] = 0;
        }
    }
    public void clickOnButton7(View v)
    {
        buttonClick.start();
        if(numbers[6].getText().toString() == "")
        {
            numbers[6].setText(numbers[7].getText().toString());
            numbers[7].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[6] = arr[7];
            arr[7] = 0;
        }
        else if(numbers[3].getText().toString() == "")
        {
            numbers[3].setText(numbers[7].getText().toString());
            numbers[7].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[3] = arr[7];
            arr[7] = 0;
        }
        else if(numbers[11].getText().toString() == "")
        {
            numbers[11].setText(numbers[7].getText().toString());
            numbers[7].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[11] = arr[7];
            arr[7] = 0;
        }
    }
    public void clickOnButton8(View v)
    {
        buttonClick.start();
        if(numbers[9].getText().toString() == "")
        {
            numbers[9].setText(numbers[8].getText().toString());
            numbers[8].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[9] = arr[8];
            arr[8] = 0;
        }
        else if(numbers[4].getText().toString() == "")
        {
            numbers[4].setText(numbers[8].getText().toString());
            numbers[8].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[4] = arr[8];
            arr[8] = 0;
        }
        else if(numbers[12].getText().toString() == "")
        {
            numbers[12].setText(numbers[8].getText().toString());
            numbers[8].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[12] = arr[8];
            arr[8] = 0;
        }
    }
    public void clickOnButton9(View v)
    {
        buttonClick.start();
        if(numbers[10].getText().toString() == "")
        {
            numbers[10].setText(numbers[9].getText().toString());
            numbers[9].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[10] = arr[9];
            arr[9] = 0;
        }
        else if(numbers[8].getText().toString() == "")
        {
            numbers[8].setText(numbers[9].getText().toString());
            numbers[9].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[8] = arr[9];
            arr[9] = 0;
        }
        else if(numbers[5].getText().toString() == "")
        {
            numbers[5].setText(numbers[9].getText().toString());
            numbers[9].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[5] = arr[9];
            arr[9] = 0;
        }
        else if(numbers[13].getText().toString() == "")
        {
            numbers[13].setText(numbers[9].getText().toString());
            numbers[9].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[13] = arr[9];
            arr[9] = 0;
        }
    }
    public void clickOnButton10(View v)
    {
        buttonClick.start();
        if(numbers[11].getText().toString() == "")
        {
            numbers[11].setText(numbers[10].getText().toString());
            numbers[10].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[11] = arr[10];
            arr[10] = 0;
        }
        else if(numbers[9].getText().toString() == "")
        {
            numbers[9].setText(numbers[10].getText().toString());
            numbers[10].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[9] = arr[10];
            arr[10] = 0;
        }
        else if(numbers[6].getText().toString() == "")
        {
            numbers[6].setText(numbers[10].getText().toString());
            numbers[10].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[6] = arr[10];
            arr[10] = 0;
        }
        else if(numbers[14].getText().toString() == "")
        {
            numbers[14].setText(numbers[10].getText().toString());
            numbers[10].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[14] = arr[10];
            arr[10] = 0;
        }
    }
    public void clickOnButton11(View v)
    {
        buttonClick.start();
        if(numbers[10].getText().toString() == "")
        {
            numbers[10].setText(numbers[11].getText().toString());
            numbers[11].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[10] = arr[11];
            arr[11] = 0;
        }
        else if(numbers[7].getText().toString() == "")
        {
            numbers[7].setText(numbers[11].getText().toString());
            numbers[11].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[7] = arr[11];
            arr[11] = 0;
        }
        else if(numbers[15].getText().toString() == "")
        {
            numbers[15].setText(numbers[11].getText().toString());
            numbers[11].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[15] = arr[11];
            arr[11] = 0;
        }
    }
    public void clickOnButton12(View v)
    {
        buttonClick.start();
        if(numbers[13].getText().toString() == "")
        {
            numbers[13].setText(numbers[12].getText().toString());
            numbers[12].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[13] = arr[12];
            arr[12] = 0;
        }
        else if(numbers[8].getText().toString() == "")
        {
            numbers[8].setText(numbers[12].getText().toString());
            numbers[12].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[8] = arr[12];
            arr[12] = 0;
        }
    }
    public void clickOnButton13(View v)
    {
        buttonClick.start();
        if(numbers[14].getText().toString() == "")
        {
            numbers[14].setText(numbers[13].getText().toString());
            numbers[13].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[14] = arr[13];
            arr[13] = 0;
        }
        else if(numbers[12].getText().toString() == "")
        {
            numbers[12].setText(numbers[13].getText().toString());
            numbers[13].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[12] = arr[13];
            arr[13] = 0;
        }
        else if(numbers[9].getText().toString() == "")
        {
            numbers[9].setText(numbers[13].getText().toString());
            numbers[13].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[9] = arr[13];
            arr[13] = 0;
        }
    }
    public void clickOnButton14(View v)
    {
        buttonClick.start();
        if(numbers[15].getText().toString() == "")
        {
            numbers[15].setText(numbers[14].getText().toString());
            numbers[14].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[15] = arr[14];
            arr[14] = 0;
        }
        else if(numbers[13].getText().toString() == "")
        {
            numbers[13].setText(numbers[14].getText().toString());
            numbers[14].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[13] = arr[14];
            arr[14] = 0;
        }
        else if(numbers[10].getText().toString() == "")
        {
            numbers[10].setText(numbers[14].getText().toString());
            numbers[14].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[10] = arr[14];
            arr[14] = 0;
        }
    }
    public void clickOnButton15(View v)
    {
        buttonClick.start();
        if(numbers[14].getText().toString() == "")
        {
            numbers[14].setText(numbers[15].getText().toString());
            numbers[15].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[14] = arr[15];
            arr[15] = 0;
        }
        else if(numbers[11].getText().toString() == "")
        {
            numbers[11].setText(numbers[15].getText().toString());
            numbers[15].setText("");
            num_moves++;
            moves.setText("Moves: "+num_moves);
            arr[11] = arr[15];
            arr[15] = 0;
        }
        if(isSorted())
        {
            start.setVisibility(View.VISIBLE);
            test.setVisibility(View.VISIBLE);
            back.setVisibility(View.INVISIBLE);
            moves.setVisibility(View.INVISIBLE);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Message")
                    .setMessage("Congratulations! You finished it in " + num_moves + " moves!")
                    .setPositiveButton("OK", null); // No OnClickListener specified

            AlertDialog dialog = builder.create();
            dialog.show();
            //openDialog();
        }
    }
}
