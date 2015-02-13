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
public class FruitsFragment extends Fragment {

    CheckBox mCheckboxBlueberries;
    CheckBox mCheckboxApples;
    CheckBox mCheckboxBananas;
    CheckBox mCheckboxAvocado;
    CheckBox mCheckboxMango;
    CheckBox mCheckboxStrawberries;
    CheckBox mCheckboxCranberries;
    CheckBox mCheckboxLemons;
    EditText mEditTextBlueberries;
    EditText mEditTextApples;
    EditText mEditTextBananas;
    EditText mEditTextAvocado;
    EditText mEditTextMango;
    EditText mEditTextStrawberries;
    EditText mEditTextCranberries;
    EditText mEditTextLemons;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public FruitsFragment(){
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fruits, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
    }

    private void wireUpEditText(View rootView) {
        mEditTextBlueberries = (EditText)rootView.findViewById(R.id.edit_text_blueberries_quantity);
        mEditTextApples = (EditText)rootView.findViewById(R.id.edit_text_apples_quantity);
        mEditTextBananas = (EditText)rootView.findViewById(R.id.edit_text_bananas_quantity);
        mEditTextAvocado = (EditText)rootView.findViewById(R.id.edit_text_avocado_quantity);
        mEditTextMango = (EditText)rootView.findViewById(R.id.edit_text_mango_quantity);
        mEditTextStrawberries = (EditText)rootView.findViewById(R.id.edit_text_strawberry_quantity);
        mEditTextCranberries = (EditText)rootView.findViewById(R.id.edit_text_cranberries_quantity);
        mEditTextLemons = (EditText)rootView.findViewById(R.id.edit_text_lemons_quantity);
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
        if(mCheckboxBlueberries.isChecked()) {
            grocery = new Grocery(mCheckboxBlueberries.getText().toString(),
                    mEditTextBlueberries.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxApples.isChecked()) {
            grocery = new Grocery(mCheckboxApples.getText().toString(),
                    mEditTextApples.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxBananas.isChecked()){
            grocery = new Grocery((mCheckboxBananas.getText().toString()),
                    mEditTextBananas.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxAvocado.isChecked()){
            grocery = new Grocery((mCheckboxAvocado.getText().toString()),
                    mEditTextAvocado.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxMango.isChecked()){
            grocery = new Grocery((mCheckboxMango.getText().toString()),
                    mEditTextMango.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxStrawberries.isChecked()){
            grocery = new Grocery((mCheckboxStrawberries.getText().toString()),
                    mEditTextStrawberries.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxCranberries.isChecked()){
            grocery = new Grocery((mCheckboxCranberries.getText().toString()),
                    mEditTextCranberries.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxLemons.isChecked()){
            grocery = new Grocery((mCheckboxLemons.getText().toString()),
                    mEditTextLemons.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }

    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerBlueberries(rootView, dataTextWatcher);
        setOnClickListenerApples(rootView, dataTextWatcher);
        setOnClickListenerBananas(rootView, dataTextWatcher);
        setOnClickListenerAvocado(rootView, dataTextWatcher);
        setOnClickListenerMango(rootView, dataTextWatcher);
        setOnClickListenerStrawberries(rootView, dataTextWatcher);
        setOnClickListenerCranberries(rootView, dataTextWatcher);
        setOnClickListenerLemons(rootView, dataTextWatcher);
    }

    private void setOnClickListenerBlueberries(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxBlueberries = (CheckBox)rootView.findViewById(R.id.checkBox_blueberries);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBlueberries, dataTextWatcher);
        mCheckboxBlueberries.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerApples(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxApples = (CheckBox)rootView.findViewById(R.id.checkBox_apples);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextApples, dataTextWatcher);
        mCheckboxApples.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerBananas(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxBananas = (CheckBox)rootView.findViewById(R.id.checkBox_bananas);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBananas, dataTextWatcher);
        mCheckboxBananas.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerAvocado(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxAvocado = (CheckBox)rootView.findViewById(R.id.checkBox_avocado);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextAvocado, dataTextWatcher);
        mCheckboxAvocado.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerMango(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxMango = (CheckBox)rootView.findViewById(R.id.checkBox_mango);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextMango, dataTextWatcher);
        mCheckboxMango.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerStrawberries(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxStrawberries = (CheckBox)rootView.findViewById(R.id.checkBox_strawberry);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextStrawberries, dataTextWatcher);
        mCheckboxStrawberries.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerCranberries(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxCranberries = (CheckBox)rootView.findViewById(R.id.checkBox_cranberries);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextCranberries, dataTextWatcher);
        mCheckboxCranberries.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerLemons(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxLemons = (CheckBox)rootView.findViewById(R.id.checkBox_lemons);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextLemons, dataTextWatcher);
        mCheckboxLemons.setOnClickListener(checkBoxOnClickListener);
    }
}
