package co.favorie.menu_world_cup;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import co.favorie.menu_world_cup.Preferences.ManagePreferences;

/**
 * Created by Administrator on 2016-02-02.
 */
public class Menu_final extends Fragment {

    ImageView img_replay;
    ImageView img_final_menu;
    int step1_status = 0, step2_status = 0, step3_status = 0;

    public Menu_final() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_final, container, false);

        final ManagePreferences pref = new ManagePreferences(getActivity());
        step1_status = pref.getValue(ManagePreferences.STEP1_STATUS,0);
        step2_status = pref.getValue(ManagePreferences.STEP2_STATUS,0);
        step3_status = pref.getValue(ManagePreferences.STEP3_STATUS,0);

        img_replay = (ImageView) rootView.findViewById(R.id.img_replay);
        img_final_menu = (ImageView) rootView.findViewById(R.id.img_final_menu);

        Random random = new Random();

        if(step1_status == 1){
            if(step2_status == 1){
                if(step3_status == 1){
                    Integer[] food_list = {
                        R.drawable.red_1, R.drawable.red_2, R.drawable.red_3,
                        R.drawable.red_4, R.drawable.red_5, R.drawable.red_6,
                        R.drawable.red_7, R.drawable.red_8
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                } else if(step3_status == 2){
                    Integer[] food_list = {
                            R.drawable.white_1, R.drawable.white_2, R.drawable.white_3,
                            R.drawable.white_4, R.drawable.white_5, R.drawable.white_6,
                            R.drawable.white_7
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                }
            } else if(step2_status == 2){
                if(step3_status == 1){
                    Integer[] food_list = {
                            R.drawable.meat_1, R.drawable.meat_2, R.drawable.meat_3,
                            R.drawable.meat_4, R.drawable.meat_5, R.drawable.meat_6,
                            R.drawable.meat_7
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                } else if(step3_status == 2){
                    Integer[] food_list = {
                            R.drawable.meat_x_1, R.drawable.meat_x_2, R.drawable.meat_x_3,
                            R.drawable.meat_x_4, R.drawable.meat_x_5
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                }
            }
        } else if(step1_status == 2){
            if(step2_status == 1){
                if(step3_status == 1){
                    Integer[] food_list = {
                            R.drawable.hot_1, R.drawable.hot_2, R.drawable.hot_3
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                } else if(step3_status == 2){
                    Integer[] food_list = {
                            R.drawable.cold_1, R.drawable.cold_2, R.drawable.cold_3,
                            R.drawable.cold_4
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                }
            } else if(step2_status == 2){
                if(step3_status == 1){
                    Integer[] food_list = {
                            R.drawable.noodle_1, R.drawable.noodle_2, R.drawable.noodle_3, R.drawable.noodle_4
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                } else if(step3_status == 2){
                    Integer[] food_list = {
                            R.drawable.noodle_x_1, R.drawable.noodle_x_2, R.drawable.noodle_x_3,
                            R.drawable.noodle_x_4, R.drawable.noodle_x_5, R.drawable.noodle_x_6
                    };
                    int selected = random.nextInt(food_list.length);
                    img_final_menu.setImageDrawable(ContextCompat.getDrawable(getActivity(), food_list[selected]));
                }
            }
        }

        img_replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref.resetAllPref();

                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                        .replace(R.id.container1, new Menu_step1())
                        .commit();
                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                        .replace(R.id.container2, new Menu_step1_1())
                        .commit();
            }
        });

        return rootView;
    }
}
