package com.example.dj.fragmentcommunication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (findViewById(R.id.fragment_container)!=null){

            if (savedInstanceState!=null){
                return;
            }


            MessageFragment messageFragment = new MessageFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, messageFragment,null).commit();

        }
    }

    @Override
    public void onMessageSend(String message) {

        DisplayFragment displayFragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", message);
        displayFragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, displayFragment, null).addToBackStack(null).commit();

    }
}
