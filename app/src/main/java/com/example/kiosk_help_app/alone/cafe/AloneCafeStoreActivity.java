package com.example.kiosk_help_app.alone.cafe;

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
import com.example.kiosk_help_app.alone.fastfood.AloneFastfoodDrinkFragment;
import com.example.kiosk_help_app.alone.fastfood.AloneFastfoodPremiumFragment;
import com.example.kiosk_help_app.alone.fastfood.AloneFastfoodSaleFragment;
import com.example.kiosk_help_app.alone.fastfood.AloneFastfoodSideFragment;
import com.example.kiosk_help_app.alone.fastfood.AloneFastfoodWhopperFragment;

import java.util.ArrayList;

public class AloneCafeStoreActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private AloneCafeCoffeeFragment selectCoffeeFragment;
    private AloneCafeLatteFragment selectLatteFragment;
    private AloneCafeAdeFragment selectAdeFragment;
    private AloneCafeTeaFragment selectTeaFragment;
    private AloneCafeSmoothieFragment selectSmoothieFragment;
    private AloneCafeDessertFragment selectDessertFragment;
    private ListView listView;
    private ArrayList<ListViewItem> cafe_data;
    private ListviewAdapter myAdapter = null;
    private int menu_cost_sum;
    //private BFragment fragmentB;
    private FragmentTransaction transaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alone_cafe_store);
        //
        ArrayAdapter<ListViewItem> adapter;
        adapter = new ArrayAdapter<ListViewItem>(this, R.layout.list_view_type, cafe_data);
        //
        cafe_data = new ArrayList<ListViewItem>();
        myAdapter = new ListviewAdapter(this, cafe_data);
        listView  = (ListView)findViewById(R.id.alone_ff_listview);
        listView.setAdapter(myAdapter);
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);

        Button buy_button = findViewById(R.id.alone_ff_buy_btn);


        fragmentManager = getSupportFragmentManager();

        selectCoffeeFragment = new AloneCafeCoffeeFragment();
        selectLatteFragment = new AloneCafeLatteFragment();
        selectTeaFragment = new AloneCafeTeaFragment();
        selectAdeFragment = new AloneCafeAdeFragment();
        selectSmoothieFragment = new AloneCafeSmoothieFragment();
        selectDessertFragment = new AloneCafeDessertFragment();

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
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);
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
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);
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
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);
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
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);
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
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);
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
        TextView cost_sum = findViewById(R.id.alone_ff_cost_sum);
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