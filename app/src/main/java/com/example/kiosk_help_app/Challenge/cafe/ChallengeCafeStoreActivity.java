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
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeAdeFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeCoffeeFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeDessertFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeLatteFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeSmoothieFragment;
import com.example.kiosk_help_app.challenge.cafe.ChallengeCafeTeaFragment;

import java.util.ArrayList;

public class ChallengeCafeStoreActivity extends AppCompatActivity {

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


    }



    public void mOnPopupClick(View v){
        //????????? ????????? ??????(????????????) ??????
        Intent intent = new Intent(this, PayCheckActivity.class);
        intent.putExtra("name", cafe_data);
        startActivityForResult(intent, 1);
    }

    @SuppressLint("MissingSuperCall")
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //????????? ??????
                String result = data.getStringExtra("result");
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
                cafe_data.add(new ListViewItem("????????? ??????", "5500" + myAdapter.getCount()));
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
            case R.id.alone_cafe_coffee_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectCoffeeFragment).commitAllowingStateLoss();
                break;
            case R.id.alone_cafe_latte_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectLatteFragment).commitAllowingStateLoss();
                break;
            case R.id.alone_cafe_smoothie_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectSmoothieFragment).commitAllowingStateLoss();
                break;
            case R.id.alone_cafe_ade_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectAdeFragment).commitAllowingStateLoss();
                break;
            case R.id.alone_cafe_Tea_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectTeaFragment).commitAllowingStateLoss();
                break;
            case R.id.alone_cafe_dessert_btn:
                transaction.replace(com.example.kiosk_help_app.R.id.frameLayout, selectDessertFragment).commitAllowingStateLoss();
                break;
        }
    }
}