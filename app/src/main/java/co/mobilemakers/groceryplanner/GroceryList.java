package co.mobilemakers.groceryplanner;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GroceryList implements Parcelable {

    ArrayList<Grocery> mGroceries;

    public GroceryList(){
        mGroceries = new ArrayList<>();
    }

    private GroceryList(Parcel source){
        this();
        source.readTypedList(mGroceries, Grocery.CREATOR);
    }


    public ArrayList<Grocery> getGroceries() {
        return mGroceries;
    }

    public void addGroceries(ArrayList<Grocery> groceries){
        mGroceries.addAll(groceries);
    }

    public void setGroceries(ArrayList<Grocery> mGroceries) {
        this.mGroceries = mGroceries;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(mGroceries);
    }

    public static final Creator CREATOR = new Creator() {
        @Override
        public Object createFromParcel(Parcel source) {
            return new GroceryList(source);
        }

        @Override
        public Object[] newArray(int size) {
            return new GroceryList[size];
        }
    };
}
