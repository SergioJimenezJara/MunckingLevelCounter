package com.tx2.levelcounter.Helpers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tx2.levelcounter.Models.Player;
import com.tx2.levelcounter.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.PlayerViewHolder> implements View.OnClickListener {

    private ArrayList<Player> game;
    private Activity activity;
    private View.OnClickListener listener;

    public RVAdapter(Activity activity, ArrayList<Player> game){
        this.game = game;
        this.activity = activity;
    }

    public class PlayerViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public ImageButton imgBtnSex;
        public TextView tvName;
        public ImageButton imgBtnSettings;
        public ImageView imgPlayer;
        public Button btnMinusLevel;
        public TextView tvLevel;
        public Button btnPlusLevel;
        public Button btnMinusGear;
        public TextView tvGear;
        public Button btnPlusGear;
        public TextView tvTotal;
        public Button btnBattle;




        PlayerViewHolder(final View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            imgBtnSex = itemView.findViewById(R.id.imgBtnSex);
            tvName =itemView.findViewById(R.id.tvName);
            imgBtnSettings = itemView.findViewById(R.id.imgBtnSettings);
            imgPlayer = itemView.findViewById(R.id.imgPlayer);
            btnMinusLevel = itemView.findViewById(R.id.btnMinusLevel);
            tvLevel = itemView.findViewById(R.id.btnMinusLevel);
            btnPlusLevel = itemView.findViewById(R.id.btnPlusLevel);
            btnMinusGear = itemView.findViewById(R.id.btnMinusGear);
            tvGear = itemView.findViewById(R.id.tvGear);
            btnPlusGear = itemView.findViewById(R.id.btnPlusGear);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            btnBattle = itemView.findViewById(R.id.btnBattle);
        }


        
    }


    // enlaza los elementos del layout con los elementos creados en esta clase
    @Override
    public PlayerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.munchking_card_view , viewGroup, false);
        PlayerViewHolder pvh = new PlayerViewHolder(v);
        v.setOnClickListener(this);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final PlayerViewHolder holder, final int position) {
        holder.tvName.setText(game.get(position).getName());

        // Change the sex
        holder.imgBtnSex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///////////////
                alertDialog("Illo, que esto no furula aun");
                ///////////////
            }
        });

        // Remove Player
        holder.imgBtnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteItem(position);
            }
        });

        // Add level
        holder.btnPlusLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the current level
                TextView tvTemp = view.findViewById(R.id.tvLevel);
                TextView tvTotal = view.findViewById(R.id.tvTotal);

                // if the level is less than 10
                if(Integer.valueOf(tvTemp.getText().toString())<10){
                    // Add one level
                    tvTemp.setText(Integer.valueOf(tvTemp.getText().toString())+1);

                    // Update the strength
                    tvTotal.setText(updateStats());
                }
            }
        });

        // Remove level
        holder.btnMinusLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the current level
                TextView tvTemp = view.findViewById(R.id.tvGear);
                TextView tvTotal = view.findViewById(R.id.tvTotal);

                // if the level is more than 1
                if(Integer.valueOf(tvTemp.getText().toString())>1){
                    // Remove one level
                    tvTemp.setText(Integer.valueOf(tvTemp.getText().toString())+1);

                    // Update the strength
                    tvTotal.setText(updateStats());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return game.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null){
            listener.onClick(view);
        }
    }

    // Method to delete item on the player list
    public void deleteItem(final int index) {

        new AlertDialog.Builder(activity)
                .setMessage(R.string.ask_exit)
                .setCancelable(false)
                .setPositiveButton(R.string.yes,new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        game.remove(index);
                        notifyItemRemoved(index);
                    }
                })
                .setNegativeButton(R.string.no, null)
                .show();
    }

    // Method to make an alert dialog
    public void alertDialog(String s){
        Toast.makeText(activity, s, Toast.LENGTH_SHORT).show();
    }

    // Method to update the stats, return the sum of gear and level
    public int updateStats(){
        // Get level and gear
        TextView tvLevel = activity.findViewById(R.id.tvLevel);
        TextView tvGear = activity.findViewById(R.id.tvGear);

        return Integer.valueOf(tvLevel.getText().toString()) + Integer.valueOf(tvGear.getText().toString());
    }



}
