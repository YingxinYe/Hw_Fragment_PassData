package android.example.hw_fragment_passdata;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    EditText username;
    EditText password;
    Button action;
    UsernameListener myNameListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    public interface UsernameListener {
        public void setUsername(String name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        myNameListener = (UsernameListener) getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        username = view.findViewById(R.id.username_editText);
        password = view.findViewById(R.id.password_editText);
        action = view.findViewById(R.id.Login_submit_button);

        action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username_text = username.getText().toString();
                String password_text = password.getText().toString();

                if (username_text.equals("admin") && password_text.equals("123")) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                    String n = username.getText().toString();

                    myNameListener.setUsername(n);
                }
            }
        });
        return view;
    }

}

