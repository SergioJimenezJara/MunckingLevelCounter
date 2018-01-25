package com.tx2.levelcounter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.tx2.levelcounter.Helpers.RVAdapter;
import com.tx2.levelcounter.Models.Player;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.imgBtnAddPlayer)
    ImageButton btnAddPlayer;
    @BindView(R.id.rvPlayerList)
    RecyclerView rvPlayerList;


    ArrayList<Player> playerList;
    RVAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Variables
        playerList = new ArrayList<Player>();
        activity = this;

        layoutManager = new LinearLayoutManager(this);
        rvPlayerList.setLayoutManager(layoutManager);

        adapter = new RVAdapter(activity, playerList);
        rvPlayerList.setAdapter(adapter);

        btnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If the name is empty or null
                if(etName.getText().toString() == null || etName.getText().toString().equals("")){
                    // Create a dialog to write the name of the new player
                } else {
                    // Create the new player
                    playerList.add(new Player(etName.getText().toString()));

                    // Check the picture
                    int img = CheckPic(etName.getText().toString().toLowerCase());

                    // Update the pic if is a friend
                    playerList.get(playerList.size()-1).setPhoto(img);

                    // Fill the list
                    adapter = new RVAdapter(activity, playerList);
                    rvPlayerList.setAdapter(adapter);
                }
            }
        });

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });

    }


    private int CheckPic(String name){
        int img;

        switch (name){
            case "dani":
            case "daltonico":
                img = R.drawable.dani;
                break;

            case "martin":
            case "encargado":
            case "encargao":
                img = R.drawable.martin;
                break;
            default:
                img = R.drawable.male;
                break;
        }

        return img;
    }
}
