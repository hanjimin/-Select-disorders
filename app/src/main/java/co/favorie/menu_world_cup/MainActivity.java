package co.favorie.menu_world_cup;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends Activity {

    boolean doubleBackToExitPressedOnce = false;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm = getFragmentManager();

        fm
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                .replace(R.id.container1, new Menu_step1())
                .commit();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                fm
                        .beginTransaction()
                        .setCustomAnimations(
                                R.animator.card_flip_left_in, R.animator.card_flip_left_out,
                                R.animator.card_flip_right_in, R.animator.card_flip_right_out)
                        .replace(R.id.container2, new Menu_step1_1())
                        .commit();
            }

        }, 300);
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