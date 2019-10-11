package com.example.awhile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button,clame;
    TextView textview;
    ImageView iv_wheel;

    Random r;

    int degree=0, degree_old=0;

    private static final float FACTOR=4.86f;

    String uploadUrl2="http://youthempire.tech/youthempire/extra_rew.php";
    String login_phone="Null";
    String p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SharedPreferences b=getApplicationContext().getSharedPreferences(login_phone, Context.MODE_PRIVATE);
        p=b.getString("loginPhone","No");

        button=(Button)findViewById(R.id.button);
        clame=(Button)findViewById(R.id.clame);
        textview=(TextView)findViewById(R.id.score);
        iv_wheel=(ImageView)findViewById(R.id.imageview);

        r=new Random();

        clame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clame.setVisibility(View.INVISIBLE);

                scoreUpload2 su2=new scoreUpload2();
                new Thread(su2).start();

                button.setVisibility(View.VISIBLE);

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                degree_old=degree % 360;
                degree=r.nextInt(3600) +720;
                RotateAnimation rotate=new RotateAnimation(degree_old,degree,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                        textview.setText("");

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        textview.setText(currentnumber(360-(degree % 360)));

                        clame.setVisibility(View.VISIBLE);
                        button.setVisibility(View.INVISIBLE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });

                iv_wheel.startAnimation(rotate);

            }
        });

    }

    private String currentnumber(int degrees){
        String text="";

        if(degrees>=(FACTOR * 1) && degrees<(FACTOR * 3)){
            text="0";
        }
        if(degrees>=(FACTOR * 3) && degrees<(FACTOR * 5)){
            text="5";
        }
        if(degrees>=(FACTOR * 5) && degrees<(FACTOR * 7)){
            text="10";
        }
        if(degrees>=(FACTOR * 7) && degrees<(FACTOR * 9)){
            text="5";
        }
        if(degrees>=(FACTOR * 9) && degrees<(FACTOR * 11)){
            text="15";
        }
        if(degrees>=(FACTOR * 11) && degrees<(FACTOR * 13)){
            text="20";
        }
        if(degrees>=(FACTOR * 13) && degrees<(FACTOR * 15)){
            text="0";
        }
        if(degrees>=(FACTOR * 15) && degrees<(FACTOR * 17)){
            text="5";
        }
        if(degrees>=(FACTOR * 17) && degrees<(FACTOR * 19)){
            text="20";
        }
        if(degrees>=(FACTOR * 19) && degrees<(FACTOR * 21)){
            text="15";
        }
        if(degrees>=(FACTOR * 21) && degrees<(FACTOR * 23)){
            text="10";
        }
        if(degrees>=(FACTOR * 23) && degrees<(FACTOR * 25)){
            text="5";
        }
        if(degrees>=(FACTOR * 25) && degrees<(FACTOR * 27)){
            text="20";
        }
        if(degrees>=(FACTOR * 27) && degrees<(FACTOR * 29)){
            text="0";
        }
        if(degrees>=(FACTOR * 29) && degrees<(FACTOR * 31)){
            text="10";
        }
        if(degrees>=(FACTOR * 31) && degrees<(FACTOR * 33)){
            text="5";
        }
        if(degrees>=(FACTOR * 33) && degrees<(FACTOR * 35)){
            text="20";
        }
        if(degrees>=(FACTOR * 35) && degrees<(FACTOR * 37)){
            text="5";
        }
        if(degrees>=(FACTOR * 37) && degrees<(FACTOR * 39)){
            text="15";
        }
        if(degrees>=(FACTOR * 39) && degrees<(FACTOR * 41)){
            text="0";
        }
        if(degrees>=(FACTOR * 41) && degrees<(FACTOR * 43)){
            text="15";
        }
        if(degrees>=(FACTOR * 43) && degrees<(FACTOR * 45)){
            text="5";
        }
        if(degrees>=(FACTOR * 45) && degrees<(FACTOR * 47)){
            text="10";
        }
        if(degrees>=(FACTOR * 47) && degrees<(FACTOR * 49)){
            text="20";
        }
        if(degrees>=(FACTOR * 49) && degrees<(FACTOR * 51)){
            text="0";
        }
        if(degrees>=(FACTOR * 51) && degrees<(FACTOR * 53)){
            text="20";
        }
        if(degrees>=(FACTOR * 53) && degrees<(FACTOR * 55)){
            text="5";
        }
        if(degrees>=(FACTOR * 55) && degrees<(FACTOR * 57)){
            text="15";
        }
        if(degrees>=(FACTOR * 57) && degrees<(FACTOR * 59)){
            text="10";
        }
        if(degrees>=(FACTOR * 59) && degrees<(FACTOR * 61)){
            text="0";
        }
        if(degrees>=(FACTOR * 61) && degrees<(FACTOR * 63)){
            text="10";
        }
        if(degrees>=(FACTOR * 63) && degrees<(FACTOR * 65)){
            text="5";
        }
        if(degrees>=(FACTOR * 65) && degrees<(FACTOR * 67)){
            text="15";
        }
        if(degrees>=(FACTOR * 67) && degrees<(FACTOR * 69)){
            text="20";
        }
        if(degrees>=(FACTOR * 69) && degrees<(FACTOR * 71)){
            text="10";
        }
        if(degrees>=(FACTOR * 71) && degrees<(FACTOR * 73)){
            text="20";
        }
        return text;
    }

    class scoreUpload2 implements Runnable{
        @Override
        public void run() {
            StringRequest stringRequest=new StringRequest(Request.Method.POST,uploadUrl2, new Response.Listener<String>() {
                @Override
                public void onResponse(final String response) {
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getApplicationContext(),"Slow internet connection!",Toast.LENGTH_LONG).show();
                }
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params=new HashMap<String, String>();
                    params.put("ph_no",p);
                    params.put("score",textview.getText().toString());
                    return params;
                }
            };
            RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        }
    }

}

