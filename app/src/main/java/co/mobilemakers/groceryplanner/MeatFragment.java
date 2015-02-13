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


public class MeatFragment extends Fragment {

    CheckBox mCheckboxChickenBreast;
    CheckBox mCheckboxSalmon;
    CheckBox mCheckboxTurkey;
    CheckBox mCheckboxBeef;
    CheckBox mCheckboxPork;
    EditText mEditTextChickenBreast;
    EditText mEditTextSalmon;
    EditText mEditTextTurkey;
    EditText mEditTextBeef;
    EditText mEditTextPork;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public MeatFragment(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_meat, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
    }

    private void wireUpEditText(View rootView) {
        mEditTextChickenBreast = (EditText)rootView.findViewById(R.id.edit_text_chicken_breast_quantity);
        mEditTextSalmon = (EditText)rootView.findViewById(R.id.edit_text_salmon_quantity);
        mEditTextTurkey = (EditText)rootView.findViewById(R.id.edit_text_turkey_quantity);
        mEditTextBeef = (EditText)rootView.findViewById(R.id.edit_text_beef_quantity);
        mEditTextPork = (EditText)rootView.findViewById(R.id.edit_text_pork_quantity);
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
        if(mCheckboxChickenBreast.isChecked()) {
            grocery = new Grocery(mCheckboxChickenBreast.getText().toString(),
                    mEditTextChickenBreast.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxSalmon.isChecked()) {
            grocery = new Grocery(mCheckboxSalmon.getText().toString(),
                    mEditTextSalmon.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxTurkey.isChecked()){
            grocery = new Grocery((mCheckboxTurkey.getText().toString()),
                    mEditTextTurkey.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxBeef.isChecked()){
            grocery = new Grocery((mCheckboxBeef.getText().toString()),
                    mEditTextBeef.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxPork.isChecked()){
            grocery = new Grocery((mCheckboxPork.getText().toString()),
                    mEditTextPork.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }

    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerChickenBreast(rootView, dataTextWatcher);
        setOnClickListenerSalmon(rootView, dataTextWatcher);
        setOnClickListenerTurkey(rootView, dataTextWatcher);
        setOnClickListenerBeef(rootView, dataTextWatcher);
        setOnClickListenerPork(rootView, dataTextWatcher);
    }

    private void setOnClickListenerChickenBreast(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxChickenBreast = (CheckBox)rootView.findViewById(R.id.checkBox_chicken_breast);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextChickenBreast, dataTextWatcher);
        mCheckboxChickenBreast.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerSalmon(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxSalmon = (CheckBox)rootView.findViewById(R.id.checkBox_salmon);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextSalmon, dataTextWatcher);
        mCheckboxSalmon.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerTurkey(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxTurkey = (CheckBox)rootView.findViewById(R.id.checkBox_turkey);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextTurkey, dataTextWatcher);
        mCheckboxTurkey.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerBeef(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxBeef = (CheckBox)rootView.findViewById(R.id.checkBox_beef);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBeef, dataTextWatcher);
        mCheckboxBeef.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerPork(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxPork = (CheckBox)rootView.findViewById(R.id.checkBox_pork);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextPork, dataTextWatcher);
        mCheckboxPork.setOnClickListener(checkBoxOnClickListener);
    }
}
