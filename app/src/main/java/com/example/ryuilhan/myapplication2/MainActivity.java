package com.example.ryuilhan.myapplication2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    CheckBox c1;
    RadioGroup RG;
    TextView TV1;
    LinearLayout LL;
    RatingBar RB;
    CalendarView CV;


    @Override
    protected void onCreate(Bundle savedInstanceState) { // main = onCreate
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // R = res폴더를 의미, res.layout.filename

        TV1 = (TextView)findViewById(R.id.TextView1);
        TV1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TV1.setText("Clicked..!");
            }
        });

        b1 = (Button)findViewById(R.id.button); // 아이디로 버튼을 찾겠다
        b1.setOnClickListener(new View.OnClickListener() { // 리스너는 인터페이스
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Hello~", Toast.LENGTH_SHORT).show();
            }
        });
        b2 = (Button)findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Button2 clicked", Toast.LENGTH_SHORT).show();
            }
        });

        c1 = (CheckBox)findViewById(R.id.checkBox);
        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    Toast.makeText(getApplicationContext(), "눌림", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "안눌림", Toast.LENGTH_SHORT).show();
                }
            }
        });
        LL = (LinearLayout)findViewById(R.id.container);
        RG = (RadioGroup) findViewById(R.id.RG1);

        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radioButton:
                        LL.setBackgroundColor(Color.rgb(255,0,0));
                        RB = (RatingBar) findViewById(R.id.ratingBar);
                        RB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                                LL.setBackgroundColor(Color.rgb(255-(int)v*30, 0, 0));
                            }
                        });
                        break;
                    case R.id.radioButton2:
                        LL.setBackgroundColor(Color.rgb(0,0,255));
                        RB = (RatingBar) findViewById(R.id.ratingBar);
                        RB.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                            @Override
                            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                                LL.setBackgroundColor(Color.rgb(0, 0, 255-(int)v*30));
                            }
                        });
                        break;
                }
            }
        });

        CV = (CalendarView)findViewById(R.id.calendarView);
        CV.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(getApplicationContext(), i+"년 "+ i1+"월 "+i2+"일", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
