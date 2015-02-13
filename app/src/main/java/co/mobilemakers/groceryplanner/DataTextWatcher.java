package co.mobilemakers.groceryplanner;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;


public class DataTextWatcher implements TextWatcher {

   ArrayList<EditText> mEditTextChosen;
    Button mButtonAddToList;
    ArrayList<String> mGroceries;

    public DataTextWatcher(Button buttonAddToList){
        mEditTextChosen = new ArrayList<>();
        mButtonAddToList = buttonAddToList;
    }

    public void addEditTextChosen(EditText editText){
        mEditTextChosen.add(editText);
    }

    public void toogleButton(Boolean state){
        mButtonAddToList.setEnabled(state);
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        for (int i=0; i<mEditTextChosen.size() ; i++){
            if(TextUtils.isEmpty(mEditTextChosen.get(i).getText())){
                toogleButton(false);
                break;
            }else{
                toogleButton(true);
            }
        }
    }
}
