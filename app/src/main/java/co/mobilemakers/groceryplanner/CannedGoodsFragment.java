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
public class CannedGoodsFragment extends Fragment {

    CheckBox mCheckboxChickpeas;
    CheckBox mCheckboxRedbeans;
    CheckBox mCheckboxLentils;
    CheckBox mCheckboxTuna;
    CheckBox mCheckboxTomatoSoup;
    CheckBox mCheckboxVegetableSoup;
    EditText mEditTextChickpeas;
    EditText mEditTextRedbeans;
    EditText mEditTextLentils;
    EditText mEditTextTuna;
    EditText mEditTextTomatoSoup;
    EditText mEditTextVegetableSoup;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public CannedGoodsFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_canned_goods, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
    }

    private void wireUpEditText(View rootView) {
        mEditTextChickpeas = (EditText)rootView.findViewById(R.id.edit_text_chickpeas_quantity);
        mEditTextRedbeans = (EditText)rootView.findViewById(R.id.edit_text_red_beans_quantity);
        mEditTextLentils = (EditText)rootView.findViewById(R.id.edit_text_lentils_quantity);
        mEditTextTuna = (EditText)rootView.findViewById(R.id.edit_text_water_packed_tuna_quantity);
        mEditTextTomatoSoup = (EditText)rootView.findViewById(R.id.edit_text_tomato_soups_quantity);
        mEditTextVegetableSoup = (EditText)rootView.findViewById(R.id.edit_text_vegetable_soup_quantity);
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
        if(mCheckboxChickpeas.isChecked()) {
            grocery = new Grocery(mCheckboxChickpeas.getText().toString(),
                    mEditTextChickpeas.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxRedbeans.isChecked()) {
            grocery = new Grocery(mCheckboxRedbeans.getText().toString(),
                    mEditTextRedbeans.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxLentils.isChecked()){
            grocery = new Grocery((mCheckboxLentils.getText().toString()),
                    mEditTextLentils.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxTuna.isChecked()){
            grocery = new Grocery((mCheckboxTuna.getText().toString()),
                    mEditTextTuna.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxTomatoSoup.isChecked()){
            grocery = new Grocery((mCheckboxTomatoSoup.getText().toString()),
                    mEditTextTomatoSoup.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxVegetableSoup.isChecked()){
            grocery = new Grocery((mCheckboxVegetableSoup.getText().toString()),
                    mEditTextVegetableSoup.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }

    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerChickPeas(rootView, dataTextWatcher);
        setOnClickListenerRedBeans(rootView, dataTextWatcher);
        setOnClickListenerLentils(rootView, dataTextWatcher);
        setOnClickListenerTuna(rootView, dataTextWatcher);
        setOnClickListenerTomatoSoup(rootView, dataTextWatcher);
        setOnClickListenerVegetableSoup(rootView, dataTextWatcher);
    }

    private void setOnClickListenerChickPeas(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxChickpeas = (CheckBox)rootView.findViewById(R.id.checkBox_chickpeas);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextChickpeas, dataTextWatcher);
        mCheckboxChickpeas.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerRedBeans(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxRedbeans = (CheckBox)rootView.findViewById(R.id.checkBox_red_beans);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextRedbeans, dataTextWatcher);
        mCheckboxRedbeans.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerLentils(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxLentils = (CheckBox)rootView.findViewById(R.id.checkBox_lentils);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextLentils, dataTextWatcher);
        mCheckboxLentils.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerTuna(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxTuna = (CheckBox)rootView.findViewById(R.id.checkBox_water_packed_tuna);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextTuna, dataTextWatcher);
        mCheckboxTuna.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerTomatoSoup(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxTomatoSoup = (CheckBox)rootView.findViewById(R.id.checkBox_tomato_soups);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextTomatoSoup, dataTextWatcher);
        mCheckboxTomatoSoup.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerVegetableSoup(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxVegetableSoup = (CheckBox)rootView.findViewById(R.id.checkBox_vegetable_soup);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextVegetableSoup, dataTextWatcher);
        mCheckboxVegetableSoup.setOnClickListener(checkBoxOnClickListener);
    }
}
