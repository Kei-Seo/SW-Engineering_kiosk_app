package com.example.kiosk_help_app.challenge.cafe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kiosk_help_app.ListViewItem;
import com.example.kiosk_help_app.ListviewAdapter;
import com.example.kiosk_help_app.PayCheckActivity;
import com.example.kiosk_help_app.R;
import com.example.kiosk_help_app.challenge.ChallengeMissionFailedActivity;
import com.example.kiosk_help_app.challenge.ChallengeMissionSuccessActivity;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeAdeFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeCoffeeFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeDessertFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeLatteFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeSmoothieFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeTeaFragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class ChallengeCafeStoreActivity extends AppCompatActivity {

    private final static int SECOND = 1000;
    private final static int LIMIT_TIME = 0;

    private FragmentManager fragmentManager;
    private ChallengeCafeCoffeeFragment selectCoffeeFragment;
    private ChallengeCafeLatteFragment selectLatteFragment;
    private ChallengeCafeAdeFragment selectAdeFragment;
    private ChallengeCafeTeaFragment selectTeaFragment;
    private ChallengeCafeSmoothieFragment selectSmoothieFragment;
    private ChallengeCafeDessertFragment selectDessertFragment;
    private ListView listView;
    private ArrayList<ListViewItem> cafe_data;
    private ListviewAdapter myAdapter = null;
    private int menu_cost_sum;
    //private BFragment fragmentB;
    private FragmentTransaction transaction;
    private int current_time;
    private TextView count_view;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.kiosk_help_app.R.layout.activity_challenge_cafe_store);

        //
        ArrayAdapter<ListViewItem> adapter;
        adapter = new ArrayAdapter<ListViewItem>(this, R.layout.list_view_type, cafe_data);
        //
        cafe_data = new ArrayList<ListViewItem>();
        myAdapter = new ListviewAdapter(this, cafe_data);
        listView  = (ListView)findViewById(R.id.challenge_ff_listview);
        listView.setAdapter(myAdapter);
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        current_time = 100000;
        count_view = (TextView) findViewById(R.id.count_down);
        Button buy_button = findViewById(R.id.challenge_ff_buy_btn);


        fragmentManager = getSupportFragmentManager();

        selectCoffeeFragment = new ChallengeCafeCoffeeFragment();
        selectLatteFragment = new ChallengeCafeLatteFragment();
        selectTeaFragment = new ChallengeCafeTeaFragment();
        selectAdeFragment = new ChallengeCafeAdeFragment();
        selectSmoothieFragment = new ChallengeCafeSmoothieFragment();
        selectDessertFragment = new ChallengeCafeDessertFragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectCoffeeFragment).commitAllowingStateLoss();

        TimerTask task=new TimerTask(){
            @Override
            public void run() {
                current_time -= SECOND;
                if(current_time <= LIMIT_TIME){
                    this.cancel();
                    onMissionFailed();
                    return;
                }
                displayText("seconds: " + current_time / 1000);
            }
        };
        timer = new Timer();
        timer.scheduleAtFixedRate(task, SECOND, SECOND);
    }

    private void displayText(final String text){
        this.runOnUiThread(new Runnable(){
            @Override
            public void run() {
                count_view.setText(text);
            }
        });
    }


    @SuppressLint("MissingSuperCall")
    protected void onMissionFailed() {
        Intent intent = new Intent(getApplicationContext(), ChallengeMissionFailedActivity.class);
        startActivity(intent);
    }

    public boolean isMissionFailed() {
        ArrayList<String> mission = new ArrayList<String>();
        mission.add("?????????");
        mission.add("?????????");

        ArrayList<String> cafe_list = new ArrayList<String>();
        for(int i = 0;i < cafe_data.size(); i++)
            cafe_list.add(cafe_data.get(i).getName());

        if(mission.containsAll(cafe_list))
            return false;
        else
            return true;
    }

    public void mOnPopupClick(View v){
        //????????? ????????? ??????(????????????) ??????
        Intent intent = new Intent(this, PayCheckActivity.class);
        timer.cancel();
        intent.putExtra("name", cafe_data);
        if(isMissionFailed())
            startActivityForResult(intent, 0);
        else
            startActivityForResult(intent, 1);
    }

    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //????????? ??????
                Intent intent = new Intent(getApplicationContext(), ChallengeMissionSuccessActivity.class);
                intent.putExtra("time", current_time);
                startActivity(intent);
            }
        }
        else if(requestCode == 0){
            if(resultCode==RESULT_OK) {
                Intent intent = new Intent(getApplicationContext(), ChallengeMissionFailedActivity.class);
                startActivity(intent);
            }
        }
    }
    public void addCafeAdeMenuHandler(int item){
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        switch (item){
            case 1:
                cafe_data.add(new ListViewItem("?????? ?????????", "4800"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4800;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 2:
                cafe_data.add(new ListViewItem("????????? ?????????", "4800"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4800;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 3:
                cafe_data.add(new ListViewItem("?????? ?????????", "4800"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4800;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 4:
                cafe_data.add(new ListViewItem("?????? ?????????", "4800"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4800;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
        }
    }

    public void addCafeCoffeeMenuHandler(int item){
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        switch (item){
            case 1:
                cafe_data.add(new ListViewItem("?????? ??????", "4500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 2:
                cafe_data.add(new ListViewItem("???????????????", "4000"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4000;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 3:
                cafe_data.add(new ListViewItem("?????? ??????", "4800"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4800;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 4:
                cafe_data.add(new ListViewItem("????????? ????????????", "5200"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5200;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
        }
    }

    public void addCafeTeaMenuHandler(int item){
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        switch (item){
            case 1:
                cafe_data.add(new ListViewItem("?????????", "4200"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4200;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 2:
                cafe_data.add(new ListViewItem("?????????", "4200"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4200;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 3:
                cafe_data.add(new ListViewItem("?????????", "4200"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4200;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 4:
                cafe_data.add(new ListViewItem("?????????", "4200"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4200;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
        }
    }

    public void addCafeSmoothieMenuHandler(int item){
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        switch (item){
            case 1:
                cafe_data.add(new ListViewItem("???????????? ?????????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 2:
                cafe_data.add(new ListViewItem("????????? ?????????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 3:
                cafe_data.add(new ListViewItem("?????? ?????????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 4:
                cafe_data.add(new ListViewItem("???????????? ????????? ?????????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
        }
    }

    public void addCafeDessertMenuHandler(int item){
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        switch (item){
            case 1:
                cafe_data.add(new ListViewItem("????????? ???????????????", "2000"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 2000;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 2:
                cafe_data.add(new ListViewItem("?????????", "2500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 2500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 3:
                cafe_data.add(new ListViewItem("???????????? ??????", "2500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 2500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 4:
                cafe_data.add(new ListViewItem("?????????", "3000"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 3000;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
        }
    }

    public void addCafeLatteMenuHandler(int item){
        TextView cost_sum = findViewById(R.id.challenge_ff_cost_sum);
        switch (item){
            case 1:
                cafe_data.add(new ListViewItem("????????? ??????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 2:
                cafe_data.add(new ListViewItem("????????? ??????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 3:
                cafe_data.add(new ListViewItem("?????????", "4800"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 4800;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
            case 4:
                cafe_data.add(new ListViewItem("????????? ??????", "5500"));
                myAdapter.notifyDataSetChanged();
                menu_cost_sum += 5500;
                cost_sum.setText("??? ?????? ?????? : " + Integer.toString(menu_cost_sum));
                break;
        }
    }



    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();

        switch(view.getId())
        {
            case R.id.challenge_cafe_coffee_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectCoffeeFragment).commitAllowingStateLoss();
                break;
            case R.id.challenge_cafe_latte_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectLatteFragment).commitAllowingStateLoss();
                break;
            case R.id.challenge_cafe_smoothie_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectSmoothieFragment).commitAllowingStateLoss();
                break;
            case R.id.challenge_cafe_ade_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectAdeFragment).commitAllowingStateLoss();
                break;
            case R.id.challenge_cafe_Tea_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectTeaFragment).commitAllowingStateLoss();
                break;
            case R.id.challenge_cafe_dessert_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectDessertFragment).commitAllowingStateLoss();
                break;
        }
    }
}