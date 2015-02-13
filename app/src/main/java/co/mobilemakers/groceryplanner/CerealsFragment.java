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
public class CerealsFragment extends Fragment {

    CheckBox mCheckboxMusli;
    CheckBox mCheckboxAllBran;
    CheckBox mCheckboxChocolateRice;
    CheckBox mCheckboxSteelOats;
    CheckBox mCheckboxFrootLoops;
    EditText mEditTextMusli;
    EditText mEditTextAllBran;
    EditText mEditTextChocolateRice;
    EditText mEditTextSteelOats;
    EditText mEditTextFrootLoops;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public CerealsFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cereals, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
    }

    private void wireUpEditText(View rootView) {
        mEditTextMusli = (EditText)rootView.findViewById(R.id.edit_text_musli_quantity);
        mEditTextAllBran = (EditText)rootView.findViewById(R.id.edit_text_all_bran_quantity);
        mEditTextChocolateRice = (EditText)rootView.findViewById(R.id.edit_text_chocolate_rice_quantity);
        mEditTextSteelOats = (EditText)rootView.findViewById(R.id.edit_text_steel_cut_oats_quantity);
        mEditTextFrootLoops = (EditText)rootView.findViewById(R.id.edit_text_froot_loops_quantity);
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
        if(mCheckboxMusli.isChecked()) {
            grocery = new Grocery(mCheckboxMusli.getText().toString(),
                    mEditTextMusli.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxAllBran.isChecked()) {
            grocery = new Grocery(mCheckboxAllBran.getText().toString(),
                    mEditTextAllBran.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxChocolateRice.isChecked()){
            grocery = new Grocery((mCheckboxChocolateRice.getText().toString()),
                    mEditTextChocolateRice.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxSteelOats.isChecked()){
            grocery = new Grocery((mCheckboxSteelOats.getText().toString()),
                    mEditTextSteelOats.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxFrootLoops.isChecked()){
            grocery = new Grocery((mCheckboxFrootLoops.getText().toString()),
                    mEditTextFrootLoops.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }


    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerMusli(rootView, dataTextWatcher);
        setOnClickListenerAllBran(rootView, dataTextWatcher);
        setOnClickListenerChocolateRice(rootView, dataTextWatcher);
        setOnClickListenerOats(rootView, dataTextWatcher);
        setOnClickListenerFrootLoops(rootView, dataTextWatcher);
    }

    private void setOnClickListenerMusli(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxMusli = (CheckBox)rootView.findViewById(R.id.checkBox_musli);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextMusli, dataTextWatcher);
        mCheckboxMusli.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerAllBran(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxAllBran = (CheckBox)rootView.findViewById(R.id.checkBox_all_bran);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextAllBran, dataTextWatcher);
        mCheckboxAllBran.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerChocolateRice(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxChocolateRice = (CheckBox)rootView.findViewById(R.id.checkBox_chocolate_rice);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextChocolateRice, dataTextWatcher);
        mCheckboxChocolateRice.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerOats(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxSteelOats = (CheckBox)rootView.findViewById(R.id.checkBox_steel_cut_oats);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextSteelOats, dataTextWatcher);
        mCheckboxSteelOats.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerFrootLoops(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxFrootLoops = (CheckBox)rootView.findViewById(R.id.checkBox_froot_loops);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextFrootLoops, dataTextWatcher);
        mCheckboxFrootLoops.setOnClickListener(checkBoxOnClickListener);
    }
}
