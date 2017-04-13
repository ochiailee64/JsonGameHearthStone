package com.example.csaper6.jsongamehearthstone;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName(); //only for log
    private TextView one, two, three, four, five; //TODO: change to buttons
    private Button button;

    //our code is horrible, oops


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wirewidgets();
        String jason = "";
        try {
            InputStream fileInput = getAssets().open("Hearthstone.JSON");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInput));
            String added;
            while ((added = reader.readLine()) != null) {
                jason += added;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject object = null;
        try {
            object = new JSONObject(jason);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        final JSONObject finalObject = object;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ButtonReset();


                boolean spell = true;
                String x = "";
                String correct = "";
                String wrong = "";
                String wrong2 = "";
                String wrong3 = "";


                while (spell) {

                    Random rand = new Random();
                    int n = rand.nextInt(200);

                    x = finalObject.optJSONArray("cards").optJSONObject(n).optString("name");
                    correct = finalObject.optJSONArray("cards").optJSONObject(n).optString("flavor");
                    wrong = finalObject.optJSONArray("cards").optJSONObject(n + 1).optString("flavor");
                    wrong2 = finalObject.optJSONArray("cards").optJSONObject(n + 3).optString("flavor");
                    wrong3 = finalObject.optJSONArray("cards").optJSONObject(n + 2).optString("flavor");

                    if (!finalObject.optJSONArray("cards").optJSONObject(n).optString("type").equals("SPELL")) {
                        spell = false;
                    }

                }

                Random rand = new Random();
                one.setText("What is the flavor of " + x);
                int n = rand.nextInt(4);

                if (n == 1) {


                    two.setText(correct);

                    two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            two.setBackgroundColor(Color.GREEN);

                            two.setEnabled(false);
                        }
                    });

                    three.setText(wrong);
                    three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            three.setBackgroundColor(Color.RED);
                            three.setEnabled(false);
                        }
                    });

                    four.setText(wrong2);
                    four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            four.setBackgroundColor(Color.RED);
                            four.setEnabled(false);
                        }
                    });


                    five.setText(wrong3);
                    five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five.setBackgroundColor(Color.RED);
                            five.setEnabled(false);

                        }
                    });
                } else if (n == 2) {

                    three.setText(correct);

                    three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            three.setBackgroundColor(Color.GREEN);
                            three.setEnabled(false);
                        }
                    });

                    two.setText(wrong);
                    two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            two.setBackgroundColor(Color.RED);
                            two.setEnabled(false);
                        }
                    });

                    four.setText(wrong2);
                    four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            four.setBackgroundColor(Color.RED);
                            four.setEnabled(false);
                        }
                    });

                    five.setText(wrong3);
                    five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five.setBackgroundColor(Color.RED);
                            five.setEnabled(false);
                        }
                    });
                } else if (n == 3) {
                    four.setText(correct);
                    four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            four.setBackgroundColor(Color.GREEN);
                            four.setEnabled(false);
                        }
                    });

                    five.setText(wrong3);
                    five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five.setBackgroundColor(Color.RED);
                            five.setEnabled(false);
                        }
                    });

                    two.setText(wrong);
                    two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            two.setBackgroundColor(Color.RED);
                            two.setEnabled(false);
                        }
                    });

                    three.setText(wrong2);
                    three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            three.setBackgroundColor(Color.RED);
                            three.setEnabled(false);
                        }
                    });
                } else {
                    five.setText(correct);
                    five.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(MainActivity.this, "correct", Toast.LENGTH_SHORT).show();
                            five.setBackgroundColor(Color.GREEN);
                            five.setEnabled(false);
                        }
                    });

                    four.setText(wrong3);
                    four.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            four.setBackgroundColor(Color.RED);
                            four.setEnabled(false);
                        }
                    });

                    two.setText(wrong);
                    two.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            two.setBackgroundColor(Color.RED);
                            two.setEnabled(false);
                        }
                    });

                    three.setText(wrong2);
                    three.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            three.setBackgroundColor(Color.RED);
                            three.setEnabled(false);
                        }
                    });


                }


            }
        });


    }

    private void ButtonReset() {
        two.setEnabled(true);
        three.setEnabled(true);
        four.setEnabled(true);
        five.setEnabled(true);

        two.setBackgroundColor(Color.LTGRAY);
        three.setBackgroundColor(Color.LTGRAY);
        four.setBackgroundColor(Color.LTGRAY);
        five.setBackgroundColor(Color.LTGRAY);

        two.setVisibility(View.VISIBLE);
        three.setVisibility(View.VISIBLE);
        four.setVisibility(View.VISIBLE);
        five.setVisibility(View.VISIBLE);

    }

    private void wirewidgets() {
        one = (TextView) findViewById(R.id.one);
        button = (Button) findViewById(R.id.button);
        two = (Button) findViewById(R.id.button2);
        three = (Button) findViewById(R.id.button3);
        four = (Button) findViewById(R.id.button4);
        five = (Button) findViewById(R.id.button5);

        two.setVisibility(View.INVISIBLE);
        three.setVisibility(View.INVISIBLE);
        four.setVisibility(View.INVISIBLE);
        five.setVisibility(View.INVISIBLE);
    }


}
