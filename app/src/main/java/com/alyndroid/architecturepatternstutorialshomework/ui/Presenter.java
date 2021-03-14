package com.alyndroid.architecturepatternstutorialshomework.ui;

import com.alyndroid.architecturepatternstutorialshomework.pojo.DataBase;

public class Presenter {
    MVP mvp;
    DataBase dataBase;

    public Presenter(MVP mvp, DataBase dataBase) {
        this.mvp = mvp;
        this.dataBase = dataBase;
    }

    public int devide(){
        int result = dataBase.getNumbers().getFirstNum() / dataBase.getNumbers().getSecondNum();
        return result;
    }

    public void getResult(){
        mvp.onGetDivideResult(devide());
    }

}
