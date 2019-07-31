package com.example.root.spellinggame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
//------------------(declarations)---------------------------------------------------------
    Button b1,b2,b3,b4,b5,b6,b7,b8,seeAns;
    ImageView img;
    String answere;
    String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String words[] = {
            "HAT","DOG", "APPLE","BOY","CAR",
            "CARROT","CAT","CLOUD","COW", "DOOR",
            "EARTH","EYES","FISH","FOUR","GIRL",
            "GRASS","HAND","HOUSE","ICE","MOBILE",
            "MOON","ONE","PEN","PENCIL","SEVEN",
            "STAR","SUN","THREE","TRAIN","TWO",
            "WALL","ant","iron","joker","key",
            "king","leaf","lion","nail","owl",
            "panda","queen","rose","unicorn","van",
            "violin","whale","worm","xray","zebra"
    };


    String[] ansArry;
    int[] imgarr = {
            R.drawable.hat, R.drawable.dog, R.drawable.apple, R.drawable.boy, R.drawable.car,
            R.drawable.carrot, R.drawable.cat, R.drawable.cloud, R.drawable.cow, R.drawable.door,
            R.drawable.earth,R.drawable.eyes, R.drawable.fish, R.drawable.four, R.drawable.girl,
            R.drawable.grass, R.drawable.hand, R.drawable.house, R.drawable.ice, R.drawable.mobile,
            R.drawable.moon, R.drawable.one, R.drawable.pen, R.drawable.pencil, R.drawable.seven,
            R.drawable.star, R.drawable.sun, R.drawable.three, R.drawable.train, R.drawable.two,
            R.drawable.wall, R.drawable.ant, R.drawable.iron, R.drawable.joker, R.drawable.key,
            R.drawable.king,R.drawable.leaf, R.drawable.lion, R.drawable.nail, R.drawable.owl,
            R.drawable.panda, R.drawable.queen,R.drawable.rose, R.drawable.unicorn,R.drawable.van,
            R.drawable.voiline, R.drawable.whale, R.drawable.worm,R.drawable.xray, R.drawable.zebra

    };

    TextView tt;

    Animation anim;


    int counter = 0;


//-----------------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //---------------------------(Inits)----------------------

        //-----------(Inits views)----------------------
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        tt = findViewById(R.id.textView3);
        seeAns = findViewById(R.id.answer);

        img = findViewById(R.id.img);

        log("init done");

        //-----------(Inits, assigning values)----------------------

        tt.setText("");

    //    img.setImageResource(imgarr[0]);

        findViewById(R.id.tableLayout).setVisibility(View.VISIBLE);



        // setButtons();

        //-----------(onClicks)--------------------
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b1.getText().toString());
                sendText(b1.getText().toString());
            //    b1.setVisibility(View.INVISIBLE);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b2.getText().toString());
                sendText(b2.getText().toString());
      //          b2.setVisibility(View.INVISIBLE);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b3.getText().toString());
                sendText(b3.getText().toString());
           //     b3.setVisibility(View.INVISIBLE);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b4.getText().toString());
                sendText(b4.getText().toString());
           //     b4.setVisibility(View.INVISIBLE);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b5.getText().toString());
                sendText(b5.getText().toString());
       //         b5.setVisibility(View.INVISIBLE);

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b6.getText().toString());
                sendText(b6.getText().toString());
       //         b6.setVisibility(View.INVISIBLE);

            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b7.getText().toString());
                sendText(b7.getText().toString());
     //           b7.setVisibility(View.INVISIBLE);


            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log(b8.getText().toString());
                sendText(b8.getText().toString());
    //            b8.setVisibility(View.INVISIBLE);


            }
        });

        seeAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seeAns.setText("answer is: '"+ answere +"'");
                new CountDownTimer(2000, 100) {
                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        seeAns.setVisibility(View.GONE);

                    }
                }.start();

            }
        });

        seeAns.setVisibility(View.GONE);

        //----------------clearing----------------------------------------

        findViewById(R.id.cls).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    tt.setText(tt.getText().toString().substring(0, tt.getText().toString().length() - 1));
                }
                catch (StringIndexOutOfBoundsException rr){
                    log("nothing to clear");
                }

            }
        });


        //------------------------------------------------------------------

     //   int i = randome(words.length);

        setAns();

        setButtons();



    }//---------------------------------------------------------oncreate end

    @SuppressLint("SetTextI18n")
    private void setButtons() {

        String string = "";
        try {
            string = answere+getRandomChars(8-answere.length());
        } catch (Exception e) {
            e.printStackTrace();
        }
        char[] chars = string.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(aChar);
        }
        Collections.shuffle(list);
        log("shuffled list :::::::"+list);
        String buttonLettors = "";
        for (int a = 0; a < 8; a++){
            log("a= = "+a);
            buttonLettors += list.get(a);
        }

        log(""+buttonLettors);

        b1.setText(""+buttonLettors.charAt(0));
        b2.setText(""+buttonLettors.charAt(1));
        b3.setText(""+buttonLettors.charAt(2));
        b4.setText(""+buttonLettors.charAt(3));
        b5.setText(""+buttonLettors.charAt(4));
        b6.setText(""+buttonLettors.charAt(5));
        b7.setText(""+buttonLettors.charAt(6));
        b8.setText(""+buttonLettors.charAt(7));

    }

    public String getRandomChars(int lim) throws Exception{
        String ret = "";
        for(int a = 0 ; a < lim ; a++){
            ret += letters.charAt(new Random().nextInt(26));
        }
        return ret;
    }




    private void setAns() {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<words.length; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        int index = list.get(randome(list.size()));
        log("We got indexx:::::"+index);
        log("toal pics ::::::"+words.length);

        img.setImageResource(imgarr[index]);
        log("image "+imgarr[index]);
        log("answere is "+words[index]);
        answere = words[index];

    }

    private void sendText(String lettr) {
        String s = tt.getText().toString() + lettr;
      tt.setText(s);

      log(""+tt.getText());
      log(""+answere);

      if(tt.getText().toString().equalsIgnoreCase(answere)){
          log("typed correctluy");

          findViewById(R.id.tableLayout).setVisibility(View.INVISIBLE);

          Toast t1 = new Toast(getApplicationContext());
          View view = getLayoutInflater().inflate(R.layout.toast, null );
          TextView res = view.findViewById(R.id.result);
                  res.setText("CORRECT!");
          t1.setView(view);
          t1.setDuration(Toast.LENGTH_LONG);
          t1.setGravity(Gravity.CENTER,0,300);
          t1.show();

          tt.setTextColor(Color.GREEN);

          new CountDownTimer(1000,100) {
              public void onTick(long millisUntilFinished) {
              }

              public void onFinish() {
                  startActivity(new Intent(MainActivity.this, MainActivity.class));
              }
          }.start();
      }

      else if( tt.getText().toString().length() == 8){

          anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.wrong);
          tt.startAnimation(anim);
          tt.setTextColor(Color.RED);

          findViewById(R.id.tableLayout).setVisibility(View.INVISIBLE);

          Toast t1 = new Toast(getApplicationContext());
          View view = getLayoutInflater().inflate(R.layout.toast, null );
          TextView res = view.findViewById(R.id.result);

          if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
              view.findViewById(R.id.toast_l).setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.toast_wrong) );
          } else {
              view.findViewById(R.id.toast_l).setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.toast_wrong));
          }

          res.setText("WRONG !!");
          t1.setView(view);
          t1.setDuration(Toast.LENGTH_LONG);
          t1.setGravity(Gravity.CENTER,0,300);
   //       t1.show();

          findViewById(R.id.tableLayout).setVisibility(View.VISIBLE);




          new CountDownTimer(1000,100) {

              public void onTick(long millisUntilFinished) {
              }

              public void onFinish() {
                  tt.setText("");
              }
          }.start();
          log("wrong, try again");
        counter += 1;
        if(counter == 3){
            counter = 0;
            seeAns.setText("Want help ??");
            seeAns.setVisibility(View.VISIBLE);
            log("show answere?");
        }
      }
      else{
          log("not yet");
      }

    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(MainActivity.this, Menu.class));
    }

    public void log(String msg){
        Log.e("", "Log:: "+msg);
    }

    public int randome(int bound){
       return (new Random().nextInt(bound));
    }
}
