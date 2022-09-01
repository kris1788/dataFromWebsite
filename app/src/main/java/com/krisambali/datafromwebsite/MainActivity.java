package com.krisambali.datafromwebsite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    TextView distext,distext1,dis,dis1,distext2,distext3,dis2,dis3,distext4,distext5,dis4,dis5;
    EditText enumber1;
    Button button1;
    TableLayout table1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.button);
        table1=findViewById(R.id.tbl1);
        enumber1=findViewById(R.id.empnumber);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                table1.setVisibility(View.VISIBLE);
                String empnumber=enumber1.getText() + "";

                distext = findViewById(R.id.display);
                distext1 = findViewById(R.id.display1);
                dis = findViewById(R.id.dis);
                dis1 = findViewById(R.id.dis1);

                distext2 = findViewById(R.id.display2);
                distext3 = findViewById(R.id.display3);
                dis2 = findViewById(R.id.dis2);
                dis3 = findViewById(R.id.dis3);

                distext4 = findViewById(R.id.display4);
                distext5 = findViewById(R.id.display5);
                dis4 = findViewById(R.id.dis4);
                dis5 = findViewById(R.id.dis5);
                String[] empid=new String[1];
                empid[0]="empid";
                String[] data=new String[1];
                data[0]=empnumber;
                FetchData fetchData=new FetchData("https://krisambali.com/android/index.php", "POST", empid, data);
                if (fetchData.startPut()) {
                    if (fetchData.onComplete()) {
                        String result = fetchData.getResult();
                        try {
                            JSONArray jsonArray = new JSONArray(result);
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            Iterator<String> keys=jsonObject.keys();
                            String enumber= keys.next();
                            String name = jsonObject.optString(enumber);
                            dis.setText(enumber);
                            distext.setText(name);
                            enumber= keys.next();
                            name = jsonObject.optString(enumber);
                            dis1.setText(enumber);
                            distext1.setText(name);
                            enumber= keys.next();
                            name = jsonObject.optString(enumber);
                            dis2.setText(enumber);
                            distext2.setText(name);
                            enumber= keys.next();
                            name = jsonObject.optString(enumber);
                            dis3.setText(enumber);
                            distext3.setText(name);
                            enumber= keys.next();
                            name = jsonObject.optString(enumber);
                            dis4.setText(enumber);
                            distext4.setText(name);
                            enumber= keys.next();
                            name = jsonObject.optString(enumber);
                            dis5.setText(enumber);
                            distext5.setText(name);
                        } catch (JSONException e) {
                            table1.setVisibility(View.GONE);
                            Log.e("Buffer Error", "Error converting result " + e.toString());
                        }
                    }

                }

            }
        });
    }
}