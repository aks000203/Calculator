package com.example.aks.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private TextView txtView;
    private double result=0;
    private String inputString="0";
    private char lastOperator=' ';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView=(TextView)findViewById(R.id.txtResultId);
        txtView.setText("0");

        BtnListener listener=new BtnListener();
        ((Button) findViewById(R.id.btnNum0Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum1Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum2Id)).setOnClickListener(listener);
        ((Button)findViewById(R.id.btnNum3Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum4Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum5Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum6Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum7Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum8Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnNum9Id)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnAddId)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnSubId)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnMulId)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnDivId)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnClearId)).setOnClickListener(listener);
        ((Button) findViewById(R.id.btnEqualId)).setOnClickListener(listener);
    }

    private class BtnListener implements OnClickListener {

        public void onClick(View view){
            switch (view.getId()) {
                case R.id.btnNum0Id:
                case R.id.btnNum1Id:
                case R.id.btnNum2Id:
                case R.id.btnNum3Id:
                case R.id.btnNum4Id:
                case R.id.btnNum5Id:
                case R.id.btnNum6Id:
                case R.id.btnNum7Id:
                case R.id.btnNum8Id:
                case R.id.btnNum9Id:
                    String inDigit=((Button)view).getText().toString();
                    if(inputString.equals("0")){
                        inputString=inDigit;
                    }
                    else{
                        inputString+=inDigit;
                    }

                    txtView.setText(inputString);

                    if(lastOperator == '='){
                        result=0;
                        lastOperator=' ';
                    }

                    break;

                case R.id.btnAddId:
                    compute();
                    lastOperator='+';
                    break;

                case R.id.btnSubId:
                    compute();
                    lastOperator='-';
                    break;

                case R.id.btnDivId:
                    compute();
                    lastOperator='/';
                    break;

                case R.id.btnMulId:
                    compute();
                    lastOperator='*';
                    break;

                case R.id.btnEqualId:
                    compute();
                    lastOperator='=';
                    break;

                case R.id.btnClearId:
                    compute();
                    lastOperator=' ';
                    result=0;
                    inputString="0";
                    txtView.setText("0");
                    break;
            }
        }

        private void compute() {
            Double inNum=Double.parseDouble(inputString);
            inputString="0";
            if(lastOperator==' '){
                result=inNum;
            }
            else if(lastOperator=='+'){
                result+=inNum;
            } else if(lastOperator=='-'){
                result-=inNum;
            } else if(lastOperator=='*'){
                result *= inNum;
            } else if(lastOperator=='/') {
                result /= inNum;
            } else if(lastOperator=='=') {

            }
            txtView.setText(String.valueOf(result));
        }

    }
}
