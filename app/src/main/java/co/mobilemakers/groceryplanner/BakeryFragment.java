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
public class BakeryFragment extends Fragment {

    CheckBox mCheckboxWholeGrain;
    CheckBox mCheckboxBrownRiceWrap;
    CheckBox mCheckboxBaguette;
    EditText mEditTextWholeGrain;
    EditText mEditTextBrownRiceWrap;
    EditText mEditTextBaguette;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;


    public BakeryFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bakery, container, false);
        wireUpEditText(rootView);
        prepareAddToListButton(rootView);
        wireUpCheckBoxes(rootView);
        mGroceryList = getActivity().getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            mGroceryList = savedInstanceState.getParcelable(MainGroceryActivity.GROCERY_LIST);
        }else{
            mGroceryList = new GroceryList();
        }
    }

    private void wireUpEditText(View rootView) {
        mEditTextWholeGrain = (EditText)rootView.findViewById(R.id.edit_text_whole_grain_bread_quantity);
        mEditTextBrownRiceWrap = (EditText)rootView.findViewById(R.id.edit_text_brown_rice_wrap_quantity);
        mEditTextBaguette = (EditText)rootView.findViewById(R.id.edit_text_baguette_quantity);
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
        if(mCheckboxBaguette.isChecked()) {
            grocery = new Grocery(mCheckboxBaguette.getText().toString(),
                    mEditTextBaguette.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxWholeGrain.isChecked()) {
            grocery = new Grocery(mCheckboxWholeGrain.getText().toString(),
                    mEditTextWholeGrain.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxBrownRiceWrap.isChecked()){
            grocery = new Grocery((mCheckboxBrownRiceWrap.getText().toString()),
                    mEditTextBrownRiceWrap.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }

    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerWholeGrain(rootView, dataTextWatcher);
        setOnClickListenerBrownRiceWrap(rootView, dataTextWatcher);
        setOnClickListenerBaguette(rootView, dataTextWatcher);
    }

    private void setOnClickListenerBaguette(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxBaguette = (CheckBox)rootView.findViewById(R.id.checkBox_baguette);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBaguette, dataTextWatcher);
        mCheckboxBaguette.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerBrownRiceWrap(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxBrownRiceWrap = (CheckBox)rootView.findViewById(R.id.checkBox_brown_rice_wrap);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBrownRiceWrap, dataTextWatcher);
        mCheckboxBrownRiceWrap.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerWholeGrain(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxWholeGrain = (CheckBox)rootView.findViewById(R.id.checkBox_whole_grain_bread);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextWholeGrain, dataTextWatcher);
        mCheckboxWholeGrain.setOnClickListener(checkBoxOnClickListener);
    }

}
