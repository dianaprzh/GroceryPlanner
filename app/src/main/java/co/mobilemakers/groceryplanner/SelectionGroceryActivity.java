package co.mobilemakers.groceryplanner;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;


public class SelectionGroceryActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_grosery);
        customizeActionBar();
        String fragmentType = (String)getIntent().getExtras().get(MainGroceryActivity.FRAGMENT);
        prepareFragmentManager(fragmentType);
    }


    private void customizeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.action_bar_title);
        actionBar.setIcon(R.drawable.ic_grocery);
        actionBar.setDisplayShowHomeEnabled(true);
    }
    private void prepareFragmentManager(String fragmentType) {
        Fragment fragment = getFragmentType(fragmentType);
        getFragmentManager().beginTransaction()
                .add(R.id.container, fragment)
                .commit();
    }

    private Fragment getFragmentType(String fragmentType) {
        if(TextUtils.equals(MainGroceryActivity.VEGETABLES,fragmentType))
            return new VegetablesFragment();
        if(TextUtils.equals(MainGroceryActivity.FRUITS, fragmentType))
            return new FruitsFragment();
        if(TextUtils.equals(MainGroceryActivity.BAKERY, fragmentType))
            return new BakeryFragment();
        if(TextUtils.equals(MainGroceryActivity.BEVERAGES, fragmentType))
            return new BeveragesFragment();
        if(TextUtils.equals(MainGroceryActivity.CANNED_GOODS, fragmentType))
            return new CannedGoodsFragment();
        if(TextUtils.equals(MainGroceryActivity.CEREALS, fragmentType))
            return new CerealsFragment();
        if(TextUtils.equals(MainGroceryActivity.MEAT, fragmentType))
            return new MeatFragment();
        if(TextUtils.equals(MainGroceryActivity.CONDIMENTS, fragmentType))
            return new CondimentsFragment();
        return new Fragment();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection_grosery, menu);
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
