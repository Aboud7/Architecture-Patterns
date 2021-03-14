package com.alyndroid.architecturepatternstutorialshomework.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alyndroid.architecturepatternstutorialshomework.R;
import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;
import com.alyndroid.architecturepatternstutorialshomework.pojo.NumberModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,MVP {
    TextView plusTextView;
    TextView divideTextView;
    TextView mulTextView;
    Button plusButton;
    Button divButton;
    Button mulButton;
    DataBase dataBase;
    Presenter presenter;
    ViewModel viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusTextView = findViewById(R.id.plus_result_textView);
        divideTextView = findViewById(R.id.div_result_textView);
        mulTextView = findViewById(R.id.mul_result_textView);
        plusButton = findViewById(R.id.plus_button);
        plusButton.setOnClickListener(this);
        divButton = findViewById(R.id.div_button);
        divButton.setOnClickListener(this);
        mulButton = findViewById(R.id.mul_button);
        mulButton.setOnClickListener(this);
        dataBase = new DataBase();
        presenter = new Presenter(this,dataBase);
        viewModel = ViewModelProviders.of(this).get(ViewModel.class);
        viewModel.data.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                mulTextView.setText(s);
            }
        });
    }

    public void sum(){
        int result = dataBase.getNumbers().getFirstNum() + dataBase.getNumbers().getSecondNum();
        plusTextView.setText(Integer.toString(result));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.plus_button){
            sum();
        }
        else
        if(view.getId() == R.id.div_button){
            presenter.getResult();
        }
        if(view.getId() == R.id.mul_button){
            viewModel.getResult();
        }
    }

    @Override
    public void onGetDivideResult(int result) {
        divideTextView.setText(Integer.toString(result));
    }
}
