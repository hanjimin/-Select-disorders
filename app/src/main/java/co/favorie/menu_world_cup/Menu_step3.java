package co.favorie.menu_world_cup;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
public class Menu_step3 extends Fragment {
    Button top_bt;
    FragmentManager fm;
    int step1_status, step2_status;
    int total_status = 0;

    public Menu_step3() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_menu_step3, container, false);

        fm = getFragmentManager();

        final ManagePreferences pref = new ManagePreferences(getActivity());
        step1_status = pref.getValue(ManagePreferences.STEP1_STATUS,0);
        step2_status = pref.getValue(ManagePreferences.STEP2_STATUS,0);

        top_bt = (Button) rootView.findViewById(R.id.top_bt);
        final ImageView img_step3 = (ImageView) getActivity().findViewById(R.id.img_step3);

        if(step1_status == 1 && step2_status == 1){
            top_bt.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.red));
            total_status = 1;
        } else if(step1_status == 1 && step2_status == 2){
            top_bt.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.meat_o));
            total_status = 2;
        } else if(step1_status == 2 && step2_status == 1){
            top_bt.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.hot));
            total_status = 3;
        } else if(step1_status == 2 && step2_status == 2){
            top_bt.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.noodle_o));
            total_status = 4;
        }

        top_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(total_status == 1){
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.img_3_1));
                } else if(total_status == 2){
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.img_3_3));
                } else if(total_status == 3){
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.img_3_5));
                } else if(total_status == 4){
                    img_step3.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.img_3_7));
                }

                pref.putValue(ManagePreferences.STEP3_STATUS, 1);
//                Toast.makeText(getActivity(), " step1 : " + pref.getValue(ManagePreferences.STEP1_STATUS, 0) + "\n"
//                        + " step2 : " + pref.getValue(ManagePreferences.STEP2_STATUS, 0) + "\n"
//                        + " step3 : " + pref.getValue(ManagePreferences.STEP3_STATUS, 0), Toast.LENGTH_SHORT).show();


                final Intent intent = new Intent(getActivity(),FinalActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                getActivity().finish();

            }
        });
        return rootView;
    }
}