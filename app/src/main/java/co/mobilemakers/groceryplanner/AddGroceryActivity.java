package co.mobilemakers.groceryplanner;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class AddGroceryActivity extends ActionBarActivity {

    EditText mEditTextGrocery;
    EditText mEditTextQuantity;
    Button mButtonAddToList;
    GroceryList mGroceryList;
    ArrayList<Grocery> mGroceryData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);
        customizeActionBar();
        prepareAddListButton();
        wireUpViews();
        addTextWatcher();
        mGroceryList = getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
    }

    private void customizeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.action_bar_title);
        actionBar.setIcon(R.drawable.ic_grocery);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void addTextWatcher() {
        DataTextWatcher dataTextWatcher = new DataTextWatcher(mButtonAddToList);
        dataTextWatcher.addEditTextChosen(mEditTextGrocery);
        dataTextWatcher.addEditTextChosen(mEditTextQuantity);
        mEditTextGrocery.addTextChangedListener(dataTextWatcher);
        mEditTextQuantity.addTextChangedListener(dataTextWatcher);
    }

    private void prepareAddListButton() {
        mButtonAddToList = (Button)findViewById(R.id.button_add_to_list);
        mButtonAddToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveData();
                Intent intent = new Intent(AddGroceryActivity.this, MainGroceryActivity.class);
                createBundle(intent);
                startActivity(intent);
            }
        });
    }

    private void createBundle(Intent intent) {
        Bundle bundle = new Bundle();
        mGroceryList.addGroceries(mGroceryData);
        bundle.putParcelable(MainGroceryActivity.GROCERY_LIST, mGroceryList);
        intent.putExtras(bundle);
    }

    private void retrieveData() {
        Grocery grocery = new Grocery(mEditTextGrocery.getText().toString(),
                mEditTextQuantity.getText().toString());
        mGroceryData = new ArrayList<>();
        mGroceryData.add(grocery);
    }

    private void wireUpViews() {
        mEditTextGrocery = (EditText)findViewById(R.id.edit_text_grocery);
        mEditTextQuantity = (EditText)findViewById(R.id.edit_text_quantity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_grocery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
