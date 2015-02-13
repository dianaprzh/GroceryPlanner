package co.mobilemakers.groceryplanner;


import android.os.Parcel;
import android.os.Parcelable;
import android.widget.CheckBox;

public class Grocery implements Parcelable{

    private String mName;
    private String mQuantity;

    public Grocery(String name, String quantity){
        mName = name;
        mQuantity = quantity;
    }

    private Grocery(Parcel source){
        mName = source.readString();
        mQuantity = source.readString();
    }
    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getQuantity() {
        return mQuantity;
    }

    public void setQuantity(String mQuantity) {
        this.mQuantity = mQuantity;
    }

    @Override
    public String toString() {
        return "Grocery: " + mName +" Quantity: " + mQuantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mQuantity);
    }

    public static final Creator<Grocery> CREATOR = new Creator<Grocery>() {
        @Override
        public Grocery createFromParcel(Parcel source) {
            return new Grocery(source);
        }

        @Override
        public Grocery[] newArray(int size) {
            return new Grocery[size];
        }
    };
}
