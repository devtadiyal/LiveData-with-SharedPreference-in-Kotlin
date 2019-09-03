package com.example.profile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {

    // Create a LiveData with a String
    val currentName: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    // Rest of the ViewModel...
}
//IN JAVA LANGUAGE
/*public class NameViewModel extends ViewModel {

// Create a LiveData with a String
private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

// Rest of the ViewModel...
}*/