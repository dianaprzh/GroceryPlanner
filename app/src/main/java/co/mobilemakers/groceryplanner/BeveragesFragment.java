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


public class BeveragesFragment extends Fragment {

    CheckBox mCheckboxTea;
    CheckBox mCheckboxCoffee;
    CheckBox mCheckboxBottledWater;
    CheckBox mCheckboxCocaCola;
    CheckBox mCheckboxPepsi;
    CheckBox mCheckbox7up;
    CheckBox mCheckboxSprite;
    CheckBox mCheckboxYogurt;
    EditText mEditTextTea;
    EditText mEditTextCoffee;
    EditText mEditTextBottledWater;
    EditText mEditTextCocaCola;
    EditText mEditTextPepsi;
    EditText mEditText7up;
    EditText mEditTextSprite;
    EditText mEditTextYogurt;
    Button mButtonAddToList;
    ArrayList<Grocery> mGroceriesChosen;
    GroceryList mGroceryList;

    public BeveragesFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_beverages, container, false);
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

    private void retrieveDataChosen(){
        mGroceriesChosen = new ArrayList<>();
        Grocery grocery;
        if(mCheckboxTea.isChecked()) {
            grocery = new Grocery(mCheckboxTea.getText().toString(),
                    mEditTextTea.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxCoffee.isChecked()) {
            grocery = new Grocery(mCheckboxCoffee.getText().toString(),
                    mEditTextCoffee.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxBottledWater.isChecked()){
            grocery = new Grocery((mCheckboxBottledWater.getText().toString()),
                    mEditTextBottledWater.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxCocaCola.isChecked()){
            grocery = new Grocery((mCheckboxCocaCola.getText().toString()),
                    mEditTextCocaCola.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxPepsi.isChecked()){
            grocery = new Grocery((mCheckboxPepsi.getText().toString()),
                    mEditTextPepsi.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckbox7up.isChecked()){
            grocery = new Grocery((mCheckbox7up.getText().toString()),
                    mEditText7up.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxSprite.isChecked()){
            grocery = new Grocery((mCheckboxSprite.getText().toString()),
                    mEditTextSprite.getText().toString());
            mGroceriesChosen.add(grocery);
        }
        if(mCheckboxYogurt.isChecked()){
            grocery = new Grocery((mCheckboxYogurt.getText().toString()),
                    mEditTextYogurt.getText().toString());
            mGroceriesChosen.add(grocery);
        }
    }

    private void createBundle(Intent intent) {
        Bundle bundle = new Bundle();
        mGroceryList.addGroceries(mGroceriesChosen);
        bundle.putParcelable(MainGroceryActivity.GROCERY_LIST, mGroceryList);
        intent.putExtras(bundle);
    }

    private void wireUpEditText(View rootView) {
        mEditTextTea = (EditText)rootView.findViewById(R.id.edit_text_tea_quantity);
        mEditTextCoffee = (EditText)rootView.findViewById(R.id.edit_text_coffee_quantity);
        mEditTextBottledWater = (EditText)rootView.findViewById(R.id.edit_text_bottled_quantity);
        mEditTextCocaCola = (EditText)rootView.findViewById(R.id.edit_text_coca_cola_quantity);
        mEditTextPepsi = (EditText)rootView.findViewById(R.id.edit_text_pepsi_quantity);
        mEditText7up = (EditText)rootView.findViewById(R.id.edit_text_7up_quantity);
        mEditTextSprite = (EditText)rootView.findViewById(R.id.edit_text_sprite_quantity);
        mEditTextYogurt = (EditText)rootView.findViewById(R.id.edit_text_yogurt_quantity);
    }

    private void wireUpCheckBoxes(View rootView) {
        final DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        setOnClickListenerTea(rootView, dataTextWatcher);
        setOnClickListenerCoffee(rootView, dataTextWatcher);
        setOnClickListenerBottledWater(rootView, dataTextWatcher);
        setOnClickListenerCocaCola(rootView, dataTextWatcher);
        setOnClickListenerPepsi(rootView, dataTextWatcher);
        setOnClickListener7up(rootView, dataTextWatcher);
        setOnClickListenerSprite(rootView, dataTextWatcher);
        setOnClickListenerYogurt(rootView, dataTextWatcher);
    }

    private void setOnClickListenerYogurt(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxYogurt = (CheckBox)rootView.findViewById(R.id.checkBox_yogurt);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextYogurt, dataTextWatcher);
        mCheckboxYogurt.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerSprite(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxSprite = (CheckBox)rootView.findViewById(R.id.checkBox_sprite);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextSprite, dataTextWatcher);
        mCheckboxSprite.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListener7up(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckbox7up = (CheckBox)rootView.findViewById(R.id.checkBox_7up);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditText7up, dataTextWatcher);
        mCheckbox7up.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerPepsi(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxPepsi = (CheckBox)rootView.findViewById(R.id.checkBox_pepsi);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextPepsi, dataTextWatcher);
        mCheckboxPepsi.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerCocaCola(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxCocaCola = (CheckBox)rootView.findViewById(R.id.checkBox_coca_cola);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextCocaCola, dataTextWatcher);
        mCheckboxCocaCola.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerBottledWater(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxBottledWater = (CheckBox)rootView.findViewById(R.id.checkBox_bottled_water);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextBottledWater, dataTextWatcher);
        mCheckboxBottledWater.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerCoffee(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxCoffee = (CheckBox)rootView.findViewById(R.id.checkBox_coffee);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextCoffee, dataTextWatcher);
        mCheckboxCoffee.setOnClickListener(checkBoxOnClickListener);
    }

    private void setOnClickListenerTea(View rootView, DataTextWatcher dataTextWatcher) {
        CheckBoxOnClickListener checkBoxOnClickListener;
        mCheckboxTea = (CheckBox)rootView.findViewById(R.id.checkBox_tea);
        checkBoxOnClickListener = new CheckBoxOnClickListener(mEditTextTea, dataTextWatcher);
        mCheckboxTea.setOnClickListener(checkBoxOnClickListener);
    }
}
