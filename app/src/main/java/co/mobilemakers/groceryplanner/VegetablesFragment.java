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
 * A placeholder fragment containing a simple view.
 */
public class VegetablesFragment extends Fragment {

    CheckBox mCucumber;
    CheckBox mLettuce;
    CheckBox mMushrooms;
    CheckBox mAsparagus;
    CheckBox mBroccoli;
    CheckBox mSpinach;
    CheckBox mOnions;
    CheckBox mTomatoes;
    CheckBox mGarlic;
    EditText mEditTextCucumber;
    EditText mEditTextLettuce;
    EditText mEditTextMushrooms;
    EditText mEditTextAsparagus;
    EditText mEditTextBroccoli;
    EditText mEditTextSpinach;
    EditText mEditTextOnions;
    EditText mEditTextTomatoes;
    EditText mEditTextGarlic;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public VegetablesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_vegetables, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
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
        if(mCucumber.isChecked()) {
            grocery = new Grocery(mCucumber.getText().toString(),
                    mEditTextCucumber.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mLettuce.isChecked()) {
            grocery = new Grocery(mLettuce.getText().toString(),
                    mEditTextLettuce.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mMushrooms.isChecked()){
            grocery = new Grocery((mMushrooms.getText().toString()),
                    mEditTextMushrooms.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mAsparagus.isChecked()){
            grocery = new Grocery((mAsparagus.getText().toString()),
                    mEditTextAsparagus.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mBroccoli.isChecked()){
            grocery = new Grocery((mBroccoli.getText().toString()),
                    mEditTextBroccoli.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mSpinach.isChecked()){
            grocery = new Grocery((mSpinach.getText().toString()),
                    mEditTextSpinach.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mOnions.isChecked()){
            grocery = new Grocery((mOnions.getText().toString()),
                    mEditTextOnions.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mTomatoes.isChecked()){
            grocery = new Grocery((mTomatoes.getText().toString()),
                    mEditTextTomatoes.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mGarlic.isChecked()){
            grocery = new Grocery((mGarlic.getText().toString()),
                    mEditTextGarlic.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }

    private void wireUpEditText(View rootView) {
        mEditTextCucumber = (EditText)rootView.findViewById(R.id.edit_text_cucumber_quantity);
        mEditTextLettuce = (EditText)rootView.findViewById(R.id.edit_text_lettuce_quantity);
        mEditTextMushrooms = (EditText)rootView.findViewById(R.id.edit_text_mushrooms_quantity);
        mEditTextAsparagus = (EditText)rootView.findViewById(R.id.edit_text_asparagus_quantity);
        mEditTextBroccoli = (EditText)rootView.findViewById(R.id.edit_text_broccoli_quantity);
        mEditTextSpinach = (EditText)rootView.findViewById(R.id.edit_text_spinach_quantity);
        mEditTextOnions = (EditText)rootView.findViewById(R.id.edit_text_onions_quantity);
        mEditTextTomatoes = (EditText)rootView.findViewById(R.id.edit_text_tomatoes_quantity);
        mEditTextGarlic = (EditText)rootView.findViewById(R.id.edit_text_garlic_quantity);
    }

    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickCucumber(rootView, dataTextWatcher);
        setOnClickListenerLettuce(rootView, dataTextWatcher);
        setOnClickListenerMushrooms(rootView, dataTextWatcher);
        setOnClickListenerAsparagus(rootView, dataTextWatcher);
        setOnClickListenerBroccoli(rootView, dataTextWatcher);
        setOnClickListenerSpinach(rootView, dataTextWatcher);
        setOnClickListenerOnions(rootView, dataTextWatcher);
        setOnClickListenerTomatoes(rootView, dataTextWatcher);
        setOnClickListenerGarlic(rootView, dataTextWatcher);
    }

    private void setOnClickListenerGarlic(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mGarlic = (CheckBox)rootView.findViewById(R.id.checkBox_garlic);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextGarlic, dataTextWatcher);
        mGarlic.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerTomatoes(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mTomatoes = (CheckBox)rootView.findViewById(R.id.checkBox_tomatoes);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextTomatoes, dataTextWatcher);
        mTomatoes.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerOnions(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mOnions = (CheckBox)rootView.findViewById(R.id.checkBox_onions);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextOnions, dataTextWatcher);
        mOnions.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerSpinach(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mSpinach = (CheckBox)rootView.findViewById(R.id.checkBox_spinach);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextSpinach, dataTextWatcher);
        mSpinach.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerBroccoli(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mBroccoli = (CheckBox)rootView.findViewById(R.id.checkBox_broccoli);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBroccoli, dataTextWatcher);
        mBroccoli.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerAsparagus(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mAsparagus = (CheckBox)rootView.findViewById(R.id.checkBox_asparagus);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextAsparagus, dataTextWatcher);
        mAsparagus.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerMushrooms(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mMushrooms = (CheckBox)rootView.findViewById(R.id.checkBox_mushrooms);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextMushrooms, dataTextWatcher);
        mMushrooms.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerLettuce(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mLettuce = (CheckBox)rootView.findViewById(R.id.checkBox_lettuce);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextLettuce, dataTextWatcher);
        mLettuce.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickCucumber(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCucumber = (CheckBox)rootView.findViewById(R.id.checkBox_cucumber);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextCucumber,dataTextWatcher);
        mCucumber.setOnClickListener(checkBoxOnClickListener);
    }
}
