package com.example.v_school.thongtinFragment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class thongtin_ViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public thongtin_ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is thong tin fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
