package co.favorie.menu_world_cup;

import android.app.Fragment;
import android.app.FragmentManager;
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

import co.favorie.menu_world_cup.Preferences.ManagePreferences;

/**
 * Created by Administrator on 2016-02-01.
 */
public class Menu_step2_1 extends Fragment {
    Button bottom_bt;
    FragmentManager fm;

    public Menu_step2_1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_step2_1, container, false);

        fm = getFragmentManager();

        final ManagePreferences pref = new ManagePreferences(getActivity());
        bottom_bt = (Button) rootView.findViewById(R.id.bottom_bt);

        bottom_bt.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.gukmul_x));

        bottom_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageView img_step2 = (ImageView) getActivity().findViewById(R.id.img_step2);
                img_step2.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.img_2_2));

                pref.putValue(ManagePreferences.STEP2_STATUS, 2);
//                Toast.makeText(getActivity(), " step1 : " + pref.getValue(ManagePreferences.STEP1_STATUS, 0) + "\n"
//                        + " step2 : " + pref.getValue(ManagePreferences.STEP2_STATUS, 0) + "\n"
//                        + " step3 : " + pref.getValue(ManagePreferences.STEP3_STATUS, 0), Toast.LENGTH_SHORT).show();

                getFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                        .replace(R.id.container2, new Menu_step3_1())
                        .commit();

                new Handler().postDelayed(new Runnable() {

                    @Override
                    public void run() {

                        fm
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                                        R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                                .replace(R.id.container1, new Menu_step3())
                                .commit();
                    }

                }, 300);

            }
        });

        return rootView;
    }
}
