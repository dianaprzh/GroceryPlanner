package co.mobilemakers.groceryplanner;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by diany_000 on 2/11/2015.
 */
public class CondimentsFragment extends Fragment {

    CheckBox mCheckboxMustard;
    CheckBox mCheckboxPepper;
    CheckBox mCheckboxMayo;
    CheckBox mCheckboxTomatoPaste;
    CheckBox mCheckboxCumin;
    CheckBox mCheckboxPapikra;
    EditText mEditTextMustard;
    EditText mEditTextPepper;
    EditText mEditTextMayo;
    EditText mEditTextTomatoPaste;
    EditText mEditTextCumin;
    EditText mEditTextPaprika;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public CondimentsFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_condiments, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
    }

    private void wireUpEditText(View rootView) {
        mEditTextMustard = (EditText)rootView.findViewById(R.id.edit_text_mustard_quantity);
        mEditTextPepper = (EditText)rootView.findViewById(R.id.edit_text_pepper_quantity);
        mEditTextMayo = (EditText)rootView.findViewById(R.id.edit_text_mayonnaise_quantity);
        mEditTextTomatoPaste = (EditText)rootView.findViewById(R.id.edit_text_tomato_paste_quantity);
        mEditTextCumin = (EditText)rootView.findViewById(R.id.edit_text_cumin_quantity);
        mEditTextPaprika = (EditText)rootView.findViewById(R.id.edit_text_paprika_quantity);
    }

    private void prepareAddToListButton(View rootView) {
        mButtonAddToList = (Button)rootView.findViewById(R.id.button_add_to_list);
        mButtonAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveDataChosen();
                Intent intent = new Intent(getActivity(), MainGroceryActivity.class);
                createBundle(intent);
                startActivity(intent);
            }
        });
    }

    private void createBundle(Intent intent) {
        Bundle bundle = new Bundle();
        mGroceryList.addGroceries(mGroceriesChosen);
        bundle.putParcelable(MainGroceryActivity.GROCERY_LIST, mGroceryList);
        intent.putExtras(bundle);
    }

    private void retrieveDataChosen(){
        mGroceriesChosen = new ArrayList<>();
        Grocery grocery;
        if(mCheckboxMustard.isChecked()) {
            grocery = new Grocery(mCheckboxMustard.getText().toString(),
                    mEditTextMustard.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxPepper.isChecked()) {
            grocery = new Grocery(mCheckboxPepper.getText().toString(),
                    mEditTextPepper.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxMayo.isChecked()){
            grocery = new Grocery((mCheckboxMayo.getText().toString()),
                    mEditTextMayo.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxTomatoPaste.isChecked()){
            grocery = new Grocery((mCheckboxTomatoPaste.getText().toString()),
                    mEditTextTomatoPaste.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxCumin.isChecked()){
            grocery = new Grocery((mCheckboxCumin.getText().toString()),
                    mEditTextCumin.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxPapikra.isChecked()){
            grocery = new Grocery((mCheckboxPapikra.getText().toString()),
                    mEditTextPaprika.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }


    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerMustard(rootView, dataTextWatcher);
        setOnClickListenerPepper(rootView, dataTextWatcher);
        setOnClickListenerMayo(rootView, dataTextWatcher);
        setOnClickListenerTomatoPaste(rootView, dataTextWatcher);
        setOnClickListenerCumin(rootView, dataTextWatcher);
        setOnClickListenerPaprika(rootView, dataTextWatcher);
    }

    private void setOnClickListenerPaprika(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxPapikra = (CheckBox)rootView.findViewById(R.id.checkBox_paprika);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextPaprika, dataTextWatcher);
        mCheckboxPapikra.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerCumin(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxCumin = (CheckBox)rootView.findViewById(R.id.checkBox_cumin);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextCumin, dataTextWatcher);
        mCheckboxCumin.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerTomatoPaste(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxTomatoPaste = (CheckBox)rootView.findViewById(R.id.checkBox_tomato_paste);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextTomatoPaste, dataTextWatcher);
        mCheckboxTomatoPaste.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerMayo(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxMayo = (CheckBox)rootView.findViewById(R.id.checkBox_mayonnaise);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextMayo, dataTextWatcher);
        mCheckboxMayo.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerPepper(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxPepper = (CheckBox)rootView.findViewById(R.id.checkBox_pepper);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextPepper, dataTextWatcher);
        mCheckboxPepper.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerMustard(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxMustard = (CheckBox)rootView.findViewById(R.id.checkBox_mustard);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextMustard, dataTextWatcher);
        mCheckboxMustard.setOnClickListener(checkBoxOnClickListener);
    }

}
