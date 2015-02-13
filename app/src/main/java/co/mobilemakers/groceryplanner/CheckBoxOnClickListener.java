package co.mobilemakers.groceryplanner;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by diany_000 on 2/11/2015.
 */
public class CheckBoxOnClickListener implements View.OnClickListener {

    EditText mEditTextQuantity;
    DataTextWatcher mDataTextWatcher;

    public CheckBoxOnClickListener(EditText editText, DataTextWatcher dataTextWatcher){
        mEditTextQuantity = editText;
        mDataTextWatcher = dataTextWatcher;
    }

    @Override
    public void onClick(View v) {
            mEditTextQuantity.setEnabled(true);
            mDataTextWatcher.toogleButton(false);
            mDataTextWatcher.addEditTextChosen(mEditTextQuantity);
            mEditTextQuantity.addTextChangedListener(mDataTextWatcher);

    }
}
