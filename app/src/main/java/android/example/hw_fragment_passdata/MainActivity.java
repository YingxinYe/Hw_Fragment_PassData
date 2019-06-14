package android.example.hw_fragment_passdata;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LoginFragment.UsernameListener {

    FragmentManager manager=getSupportFragmentManager();
    FragmentTransaction transaction=manager.beginTransaction();
    MyViewPagerAdapter adapter;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("Mytag","activity_main");

        initialize();

    }

    private void initialize(){
        tabLayout=findViewById(R.id.tab_Layout);

        Log.e("Mytag","tabLayout: " + tabLayout);
        viewPager=findViewById(R.id.view_Pager);
        adapter=new MyViewPagerAdapter(manager);
        adapter=new MyViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new HomeFragment(),"Home");
        adapter.addFragment(new LoginFragment(),"Login");
        adapter.addFragment(new RegisterFragment(),"Register");
        adapter.addFragment(new WelcomeFragment(),"Welcome");

        transaction.add(R.id.fragment_container,new HomeFragment()).commit();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
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
