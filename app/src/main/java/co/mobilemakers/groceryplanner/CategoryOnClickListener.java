package co.mobilemakers.groceryplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by diany_000 on 2/11/2015.
 */
public class CategoryOnClickListener implements View.OnClickListener{

    private String mFragmentType;
    private ArrayList<Grocery> mGroceries;


    public CategoryOnClickListener(String fragmentType, ArrayList<Grocery> groceries){
        mFragmentType = fragmentType;
        mGroceries = groceries;
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), SelectionGroceryActivity.class);
        intent.putExtra(MainGroceryActivity.FRAGMENT, mFragmentType);
        Bundle bundle = createBundle();
        intent.putExtras(bundle);
        v.getContext().startActivity(intent);
    }

    private Bundle createBundle() {
        Bundle bundle = new Bundle();
        GroceryList groceryList = new GroceryList();
        groceryList.setGroceries(mGroceries);
        bundle.putParcelable(MainGroceryActivity.GROCERY_LIST, groceryList);
        return bundle;
    }
}
