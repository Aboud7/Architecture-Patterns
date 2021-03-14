package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

import androidx.lifecycle.MutableLiveData;

public class ViewModel extends androidx.lifecycle.ViewModel {

    MutableLiveData<String> data = new MutableLiveData<>();

    private String multiply(){
        DataBase dataBase = new DataBase();
        int result = dataBase.getNumbers().getFirstNum() * dataBase.getNumbers().getSecondNum();
        return Integer.toString(result);
    }

    public void getResult(){
        String result = multiply();
        data.setValue(result);
    }
}
