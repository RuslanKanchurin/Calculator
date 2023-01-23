package ru.kruslan.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String nominator="";
    String denominator="";
    Button one;
    Button two;
    Button three;
    Button four;
    Button five;
    Button six;
    Button seven;
    Button eight;
    Button nine;
    Button zero;
    Button sum;
    Button sub;
    Button equal;
    Button div;
    Button mul;
    Button denom_but;
    Button clear;
    Button back;
    Button left_par;
    Button right_par;

    TextView nom;
    TextView denom;

    boolean flag=false;
    boolean eq_flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=(Button) findViewById(R.id.one);
        two=(Button) findViewById(R.id.two);
        three=(Button) findViewById(R.id.three);
        four=(Button) findViewById(R.id.four);
        five=(Button) findViewById(R.id.five);
        six=(Button) findViewById(R.id.six);
        seven=(Button) findViewById(R.id.seven);
        eight=(Button) findViewById(R.id.eight);
        nine=(Button) findViewById(R.id.nine);
        zero=(Button) findViewById(R.id.zero);
        sum=(Button) findViewById(R.id.sum);
        sub=(Button) findViewById(R.id.sub);
        equal=(Button) findViewById(R.id.equal);
        div=(Button) findViewById(R.id.div);
        mul=(Button) findViewById(R.id.mul);
        denom_but=(Button) findViewById(R.id.denom_but);
        clear=(Button) findViewById(R.id.clear);
        back=(Button) findViewById(R.id.back);
        left_par=(Button) findViewById(R.id.left_par);
        right_par=(Button) findViewById(R.id.right_par);


        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zero.setOnClickListener(this);
        sum.setOnClickListener(this);
        sub.setOnClickListener(this);
        equal.setOnClickListener(this);
        div.setOnClickListener(this);
        mul.setOnClickListener(this);
        denom_but.setOnClickListener(this);
        clear.setOnClickListener(this);
        back.setOnClickListener(this);
        left_par.setOnClickListener(this);
        right_par.setOnClickListener(this);

        nom=(TextView) findViewById(R.id.nom);
        denom=(TextView) findViewById(R.id.denom);
    }

    @Override
    public void onClick(View v) {
        if (eq_flag) {denominator="";eq_flag=false;}

        switch (v.getId()) {
            case R.id.one:
                if (!flag) nominator+=1;
                else denominator+=1;
                break;
            case R.id.two:
                if (!flag) nominator+=2;
                else denominator+=2;
                break;
            case R.id.three:
                if (!flag) nominator+=3;
                else denominator+=3;
                break;
            case R.id.four:
                if (!flag) nominator+=4;
                else denominator+=4;
                break;
            case R.id.five:
                if (!flag) nominator+=5;
                else denominator+=5;
                break;
            case R.id.six:
                if (!flag) nominator+=6;
                else denominator+=6;
                break;
            case R.id.seven:
                if (!flag) nominator+=7;
                else denominator+=7;
                break;
            case R.id.eight:
                if (!flag) nominator+=8;
                else denominator+=8;
                break;
            case R.id.nine:
                if (!flag) nominator+=9;
                else denominator+=9;
                break;
            case R.id.zero:
                if (!flag) nominator+=0;
                else denominator+=0;
                break;
            case R.id.sum:
                if (!flag) if (Character.isDigit(nominator.charAt(nominator.length()-1))) nominator+="+";
                else {nominator=nominator.substring(0,nominator.length()-1);nominator+="+";}
                else if (Character.isDigit(denominator.charAt(denominator.length()-1))) denominator+="+";
                else {denominator=denominator.substring(0,denominator.length()-1);denominator+="+";}
                break;
            case R.id.sub:
                if (!flag) if (Character.isDigit(nominator.charAt(nominator.length()-1))) nominator+="-";
                else {nominator=nominator.substring(0,nominator.length()-1);nominator+="-";}
                else if (Character.isDigit(denominator.charAt(denominator.length()-1))) denominator+="-";
                else {denominator=denominator.substring(0,denominator.length()-1);denominator+="-";}
                break;
            case R.id.div:
                if (!flag) if (Character.isDigit(nominator.charAt(nominator.length()-1))) nominator+="/";
                else {nominator=nominator.substring(0,nominator.length()-1);nominator+="/";}
                else if (Character.isDigit(denominator.charAt(denominator.length()-1))) denominator+="/";
                else {denominator=denominator.substring(0,denominator.length()-1);denominator+="/";}
                break;
            case R.id.mul:
                if (!flag) if (Character.isDigit(nominator.charAt(nominator.length()-1))) nominator+="x";
                else {nominator=nominator.substring(0,nominator.length()-1);nominator+="x";}
                else if (Character.isDigit(denominator.charAt(denominator.length()-1))) denominator+="x";
                else {denominator=denominator.substring(0,denominator.length()-1);denominator+="x";}
                break;
            case R.id.left_par:
                if (!flag) if (Character.isDigit(nominator.charAt(nominator.length()-1))) nominator+="(";
                else {nominator=nominator.substring(0,nominator.length()-1);nominator+="(";}
                else if (Character.isDigit(denominator.charAt(denominator.length()-1))) denominator+="(";
                else {denominator=denominator.substring(0,denominator.length()-1);denominator+="(";}
                break;
            case R.id.right_par:
                if (!flag) if (Character.isDigit(nominator.charAt(nominator.length()-1))) nominator+=")";
                else {nominator=nominator.substring(0,nominator.length()-1);nominator+=")";}
                else if (Character.isDigit(denominator.charAt(denominator.length()-1))) denominator+=")";
                else {denominator=denominator.substring(0,denominator.length()-1);denominator+=")";}
                break;
            case R.id.back:
                if (!flag) if (nominator.length()!=0)nominator=nominator.substring(0,nominator.length()-1);
                else if (denominator.length()!=0)denominator=denominator.substring(0,denominator.length()-1);
                break;
            case R.id.denom_but:
                if (!flag) flag=true;
                else flag=false;
                break;
            case R.id.clear:flag=false;nominator="";denominator="";break;
            case R.id.equal:
                if (!(nominator==""&&denominator=="")) {
                    eq_flag = true;
                    double res=0;
                    try {
                        res = Calculator.calculate(nominator, denominator);
                    }
                    catch (java.lang.Throwable e){
                    }
                    if (Math.ceil(res) == Math.floor(res))
                        denominator = String.format("%,.0f", res);
                    else denominator = String.format("%.15f", res);
                    nominator = "";
                }
                break;
        }
        updateViews();
    }

    private void updateViews(){

        nom.setText(nominator);
        denom.setText(denominator);

    }

}