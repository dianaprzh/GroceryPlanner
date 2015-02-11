package co.mobilemakers.groceryplanner;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class WelcomeFragment extends Fragment {

    private final static String WELCOME = "WELCOME";

    public WelcomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_welcome, container, false);
        Button button = (Button)rootView.findViewById(R.id.button_go);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new MainGroseryFragment())
                        .addToBackStack(WELCOME).commit();
            }
        });
        return rootView;
    }
}
