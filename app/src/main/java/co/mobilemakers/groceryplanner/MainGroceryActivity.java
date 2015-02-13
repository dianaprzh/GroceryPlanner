package co.mobilemakers.groceryplanner;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;


public class MainGroceryActivity extends ActionBarActivity {

    public static final int RESULT_SETTINGS = 1;

    public final static String FRAGMENT = "FRAGMENT";
    public final static String VEGETABLES = "VEGETABLES";
    public final static String FRUITS = "FRUITS";
    public final static String BAKERY = "BAKERY";
    public final static String MEAT = "MEAT";
    public final static String CEREALS = "CEREALS";
    public final static String CONDIMENTS = "CONDIMENTS";
    public final static String BEVERAGES = "BEVERAGES";
    public final static String CANNED_GOODS = "CANNED_GOODS";

    Button mButtonVegetables;
    Button mButtonFruits;
    Button mButtonBakery;
    Button mButtonMeat;
    Button mButtonCereals;
    Button mButtonCondiments;
    Button mButtonBeverages;
    Button mButtonCannedGoods;
    Button mButtonSeeList;
    Button mButtonAddGrosery;
    CategoryOnClickListener mCategoryOnClickListener;
    public static final String GROCERY_LIST = "GROCERY_LIST";
    ArrayList<Grocery> mGroceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_grosery);
        customizeActionBar();
        GroceryList groceryList = getIntent().getParcelableExtra(GROCERY_LIST);
        mGroceries = new ArrayList<>();
        if(groceryList != null)
            mGroceries.addAll(groceryList.getGroceries());
        prepareVegetablesButton();
        prepareFruitsButton();
        prepareBakeryButton();
        prepareButtonMeat();
        prepareCerealButton();
        prepareCondimentsButton();
        prepareBeveragesButton();
        prepareCannedGoodsButton();
        prepareSeeListButton();
        prepareButtonAddGrocery();
    }

    private void prepareButtonAddGrocery() {
        mButtonAddGrosery = (Button)findViewById(R.id.button_add_other);
        mButtonAddGrosery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGroceryActivity.this, AddGroceryActivity.class);
                Bundle bundle = createBundle();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void prepareSeeListButton() {
        mButtonSeeList = (Button)findViewById(R.id.button_see_list);
        mButtonSeeList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainGroceryActivity.this, SeeListActivity.class);
                Bundle bundle = createBundle();
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        GroceryList groceryList = new GroceryList();
        groceryList.setGroceries(mGroceries);
        bundle.putParcelable(MainGroceryActivity.GROCERY_LIST, groceryList);
        return bundle;
    }

    private void customizeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.action_bar_title);
        actionBar.setIcon(R.drawable.ic_grocery);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void prepareCannedGoodsButton() {
        mButtonCannedGoods = (Button)findViewById(R.id.button_canned_goods);
        mCategoryOnClickListener = new CategoryOnClickListener(CANNED_GOODS, mGroceries);
        mButtonCannedGoods.setOnClickListener(mCategoryOnClickListener);
    }

    private void prepareBeveragesButton() {
        mButtonBeverages = (Button)findViewById(R.id.button_beverages);
        mCategoryOnClickListener = new CategoryOnClickListener(BEVERAGES, mGroceries);
        mButtonBeverages.setOnClickListener(mCategoryOnClickListener);
    }

    private void prepareCondimentsButton() {
        mButtonCondiments = (Button)findViewById(R.id.button_condiments);
        mCategoryOnClickListener = new CategoryOnClickListener(CONDIMENTS, mGroceries);
        mButtonCondiments.setOnClickListener(mCategoryOnClickListener);
    }

    private void prepareCerealButton() {
        mButtonCereals = (Button)findViewById(R.id.button_cereals);
        mCategoryOnClickListener = new CategoryOnClickListener(CEREALS, mGroceries);
        mButtonCereals.setOnClickListener(mCategoryOnClickListener);
    }


    private void prepareButtonMeat() {
        mButtonMeat = (Button)findViewById(R.id.button_meat);
        mCategoryOnClickListener = new CategoryOnClickListener(MEAT, mGroceries);
        mButtonMeat.setOnClickListener(mCategoryOnClickListener);
    }

    private void prepareVegetablesButton() {
        mButtonVegetables = (Button)findViewById(R.id.button_vegetables);
        mCategoryOnClickListener = new CategoryOnClickListener(VEGETABLES, mGroceries);
        mButtonVegetables.setOnClickListener(mCategoryOnClickListener);
    }

    private void prepareFruitsButton() {
        mButtonFruits = (Button)findViewById(R.id.button_fruits);
        mCategoryOnClickListener = new CategoryOnClickListener(FRUITS, mGroceries);
        mButtonFruits.setOnClickListener(mCategoryOnClickListener);
    }

    private void prepareBakeryButton() {
        mButtonBakery = (Button)findViewById(R.id.button_bakery);
        mCategoryOnClickListener = new CategoryOnClickListener(BAKERY, mGroceries);
        mButtonBakery.setOnClickListener(mCategoryOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_grosery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.action_settings:
                Intent intent = new Intent(this, AppSettingsActivity.class);
                startActivityForResult(intent, RESULT_SETTINGS);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(GROCERY_LIST,mGroceries);
    }
}
