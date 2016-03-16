package co.favorie.menu_world_cup;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

import co.favorie.menu_world_cup.Preferences.ManagePreferences;

public class FinalActivity extends Activity {

    boolean doubleBackToExitPressedOnce = false;
    ImageView img_replay;
    ImageView img_final_menu;
    ImageView img_step1, img_step2, img_step3;
    int step1_status = 0, step2_status = 0, step3_status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        final ManagePreferences pref = new ManagePreferences(FinalActivity.this);
        step1_status = pref.getValue(ManagePreferences.STEP1_STATUS,0);
        step2_status = pref.getValue(ManagePreferences.STEP2_STATUS,0);
        step3_status = pref.getValue(ManagePreferences.STEP3_STATUS,0);

        img_replay = (ImageView) findViewById(R.id.img_replay);
        img_final_menu = (ImageView) findViewById(R.id.img_final_menu);

        img_step1 = (ImageView) findViewById(R.id.img_step1);
        img_step2 = (ImageView) findViewById(R.id.img_step2);
        img_step3 = (ImageView) findViewById(R.id.img_step3);

        Random random = new Random();

        if(step1_status == 1){
            if(step2_status == 1){
                if(step3_status == 1){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_1));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_1));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_1));;

                    Integer[] food_list = {
                            R.drawable.red_1, R.drawable.red_2, R.drawable.red_3,
                            R.drawable.red_4, R.drawable.red_5, R.drawable.red_6,
                            R.drawable.red_7, R.drawable.red_8
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                } else if(step3_status == 2){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_1));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_1));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_2));

                    Integer[] food_list = {
                            R.drawable.white_1, R.drawable.white_2, R.drawable.white_3,
                            R.drawable.white_4, R.drawable.white_5, R.drawable.white_6,
                            R.drawable.white_7
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                }
            } else if(step2_status == 2){
                if(step3_status == 1){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_1));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_2));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_3));

                    Integer[] food_list = {
                            R.drawable.meat_1, R.drawable.meat_2, R.drawable.meat_3,
                            R.drawable.meat_4, R.drawable.meat_5, R.drawable.meat_6,
                            R.drawable.meat_7
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                } else if(step3_status == 2){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_1));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_2));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_4));

                    Integer[] food_list = {
                            R.drawable.meat_x_1, R.drawable.meat_x_2, R.drawable.meat_x_3,
                            R.drawable.meat_x_4, R.drawable.meat_x_5
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                }
            }
        } else if(step1_status == 2){
            if(step2_status == 1){
                if(step3_status == 1){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_2));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_1));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_5));

                    Integer[] food_list = {
                            R.drawable.hot_1, R.drawable.hot_2, R.drawable.hot_3
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                } else if(step3_status == 2){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_2));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_1));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_6));

                    Integer[] food_list = {
                            R.drawable.cold_1, R.drawable.cold_2, R.drawable.cold_3,
                            R.drawable.cold_4
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                }
            } else if(step2_status == 2){
                if(step3_status == 1){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_2));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_2));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_7));

                    Integer[] food_list = {
                            R.drawable.noodle_1, R.drawable.noodle_2, R.drawable.noodle_3, R.drawable.noodle_4
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                } else if(step3_status == 2){

                    img_step1.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_1_2));
                    img_step2.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_2_2));
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.img_3_8));

                    Integer[] food_list = {
                            R.drawable.noodle_x_1, R.drawable.noodle_x_2, R.drawable.noodle_x_3,
                            R.drawable.noodle_x_4, R.drawable.noodle_x_5, R.drawable.noodle_x_6
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), food_list[selected]));
                }
            }
        }

        img_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.resetAllPref();

                Intent intent = new Intent(FinalActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }
}
