package com.example.v_school.dieukhoan;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class dieukhoan_ViewModel extends ViewModel {
    private MutableLiveData<String> mText;


    public dieukhoan_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dieu khoan fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
