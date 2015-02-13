package co.mobilemakers.groceryplanner;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class SeeListActivity extends ActionBarActivity {

    private final static String USERNAME_PREFERENCE = "username_preference";

    TextView mTextViewTitle;
    TextView mTextViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_list);
        customizeActionBar();
        wireUpViews();
        displayUserListTitle();
        displayList();
    }

    private void displayList() {
        GroceryList groceryList = getIntent().getParcelableExtra(MainGroceryActivity.GROCERY_LIST);
        ArrayList<Grocery> groceries = groceryList.getGroceries();
        StringBuilder list = new StringBuilder();
        for (int i=0; i<groceries.size() ; i++){
            list.append(groceries.get(i).toString()).append("\n");
        }
        mTextViewList.setText(list);
    }

    private void customizeActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.action_bar_title);
        actionBar.setIcon(R.drawable.ic_grosery);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void wireUpViews() {
        mTextViewTitle = (TextView)findViewById(R.id.text_view_title_see_list);
        mTextViewList = (TextView)findViewById(R.id.text_view_list);
    }

    private void displayUserListTitle() {
        String username = getUsername();
        String title_see_list = String.format(getString(R.string.user_list_title), username);
        mTextViewTitle.setText(title_see_list);
    }

    private String getUsername() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return sharedPreferences.getString(USERNAME_PREFERENCE, getString(R.string.default_username));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_see_list, menu);
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
