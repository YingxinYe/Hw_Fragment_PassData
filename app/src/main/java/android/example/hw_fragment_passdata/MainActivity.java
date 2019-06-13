package android.example.hw_fragment_passdata;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements LoginFragment.UsernameListener {

    FragmentManager manager=getSupportFragmentManager();
    FragmentTransaction transaction=manager.beginTransaction();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        transaction.add(R.id.fragment_container,new HomeFragment()).commit();
    }

    @Override
    public void setUsername(String name) {
        WelcomeFragment welcomeFragment=new WelcomeFragment();
        Bundle bundle=new Bundle();
        bundle.putString("user",name);
        welcomeFragment.setArguments(bundle);
        manager.beginTransaction().replace(R.id.fragment_container,welcomeFragment,null).addToBackStack(null).commit();

    }
}
