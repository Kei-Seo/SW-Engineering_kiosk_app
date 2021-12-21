package com.example.kiosk_help_app.alone.Movie;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kiosk_help_app.ListViewItem;
import com.example.kiosk_help_app.ListviewAdapter;
import com.example.kiosk_help_app.MainActivity;
import com.example.kiosk_help_app.R;
import com.example.kiosk_help_app.timetable.TransferReservationInfoActivity;

import java.util.ArrayList;

public class AloneMovieSeatSelect extends Activity {
    int price = 0;
    int number = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_alone_movie_seat_select);
        Intent intent = new Intent(this, AloneMovieSeatCheckAndPay.class);

        //rest today
        TextView ticketText = findViewById(R.id.alone_movie_ticket_number);
        TextView priceText = findViewById(R.id.alone_movie_price);

        Button pay_btn = findViewById(R.id.alone_movie_pay);
        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "결제가 완료되었습니다.", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        ImageButton seat_1 = findViewById(R.id.alone_movie_seat_1);
        seat_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_2 = findViewById(R.id.alone_movie_seat_2);
        seat_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_3 = findViewById(R.id.alone_movie_seat_3);
        seat_3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_4 = findViewById(R.id.alone_movie_seat_4);
        seat_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_5 = findViewById(R.id.alone_movie_seat_5);
        seat_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_6 = findViewById(R.id.alone_movie_seat_6);
        seat_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_7 = findViewById(R.id.alone_movie_seat_7);
        seat_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });


        ImageButton seat_8 = findViewById(R.id.alone_movie_seat_8);
        seat_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_9 = findViewById(R.id.alone_movie_seat_9);
        seat_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_10 = findViewById(R.id.alone_movie_seat_10);
        seat_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_11 = findViewById(R.id.alone_movie_seat_11);
        seat_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_12 = findViewById(R.id.alone_movie_seat_12);
        seat_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_13 = findViewById(R.id.alone_movie_seat_13);
        seat_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_14 = findViewById(R.id.alone_movie_seat_14);
        seat_14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_15 = findViewById(R.id.alone_movie_seat_15);
        seat_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });


        ImageButton seat_16 = findViewById(R.id.alone_movie_seat_16);
        seat_16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_17 = findViewById(R.id.alone_movie_seat_17);
        seat_17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_18 = findViewById(R.id.alone_movie_seat_18);
        seat_18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_19 = findViewById(R.id.alone_movie_seat_19);
        seat_19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_20 = findViewById(R.id.alone_movie_seat_20);
        seat_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_21 = findViewById(R.id.alone_movie_seat_21);
        seat_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_22 = findViewById(R.id.alone_movie_seat_22);
        seat_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_23 = findViewById(R.id.alone_movie_seat_23);
        seat_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_24 = findViewById(R.id.alone_movie_seat_24);
        seat_24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_25 = findViewById(R.id.alone_movie_seat_25);
        seat_25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_26 = findViewById(R.id.alone_movie_seat_26);
        seat_26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_27 = findViewById(R.id.alone_movie_seat_27);
        seat_27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_28 = findViewById(R.id.alone_movie_seat_28);
        seat_28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_29 = findViewById(R.id.alone_movie_seat_29);
        seat_29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_30 = findViewById(R.id.alone_movie_seat_30);
        seat_30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_31 = findViewById(R.id.alone_movie_seat_31);
        seat_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });
        ImageButton seat_32 = findViewById(R.id.alone_movie_seat_32);
        seat_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_33 = findViewById(R.id.alone_movie_seat_33);
        seat_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_34 = findViewById(R.id.alone_movie_seat_34);
        seat_34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_35 = findViewById(R.id.alone_movie_seat_35);
        seat_35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_36 = findViewById(R.id.alone_movie_seat_36);
        seat_36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_37 = findViewById(R.id.alone_movie_seat_37);
        seat_37.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_38 = findViewById(R.id.alone_movie_seat_38);
        seat_38.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

        ImageButton seat_39 = findViewById(R.id.alone_movie_seat_39);
        seat_39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //여기서는 좌석을 클릭했을 때 구현 내용이 들어가야한다.
                price += 7000;
                number += 1;
                ticketText.setText(Integer.toString(number));
                priceText.setText(Integer.toString(price));
            }
        });

    }

}