package co.favorie.menu_world_cup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

import co.favorie.menu_world_cup.Preferences.ManagePreferences;

/**
 * Created by Administrator on 2016-02-01.
 */
public class Menu_step1 extends Fragment {
    Button top_bt;
    FragmentManager fm;

    public Menu_step1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_step1, container, false);

        fm = getFragmentManager();

        final ManagePreferences pref = new ManagePreferences(getActivity());
        top_bt = (Button) rootView.findViewById(R.id.top_bt);

        top_bt.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.rice_o));

        ImageView img_step1 = (ImageView) getActivity().findViewById(R.id.img_step1);
        ImageView img_step2 = (ImageView) getActivity().findViewById(R.id.img_step2);
        ImageView img_step3 = (ImageView) getActivity().findViewById(R.id.img_step3);

        img_step1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.empty_1));
        img_step2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.empty_2));
        img_step3.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.empty_3));

        top_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img_step1 = (ImageView) getActivity().findViewById(R.id.img_step1);
                img_step1.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.img_1_1));

                pref.putValue(ManagePreferences.STEP1_STATUS, 1);
//                Toast.makeText(getActivity(), " step1 : " + pref.getValue(ManagePreferences.STEP1_STATUS, 0) + "\n"
//                        + " step2 : " + pref.getValue(ManagePreferences.STEP2_STATUS, 0) + "\n"
//                        + " step3 : " + pref.getValue(ManagePreferences.STEP3_STATUS, 0), Toast.LENGTH_SHORT).show();

                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                        .replace(R.id.container1, new Menu_step2())
                        .commit();

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        fm
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                                .replace(R.id.container2, new Menu_step2_1())
                                .commit();
                    }
                }, 300);


            }
        });

        return rootView;
    }
}
