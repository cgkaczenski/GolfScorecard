package com.teamtreehouse.golfscorecard;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class HoleAdapter extends RecyclerView.Adapter<HoleAdapter.HoleViewHolder> {

    private Hole[] mHoles;
    private Context mContext;

    public HoleAdapter(Context context, Hole[] holes) {
        mHoles = holes;
        mContext = context;
    }

    @Override
    public HoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hole_list_item, parent, false);
        HoleViewHolder viewHolder = new HoleViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HoleViewHolder holder, int position) {
        holder.bindHole(mHoles[position]);
    }

    @Override
    public int getItemCount() {
        return mHoles.length;
    }

    public class HoleViewHolder extends RecyclerView.ViewHolder {

        public TextView mHoleLabel;
        public TextView mScoreLabel;
        public Button mAddButton;
        public Button mMinusButton;

        public HoleViewHolder(View itemView) {
            super(itemView);

            mHoleLabel = (TextView) itemView.findViewById(R.id.holeLabel);
            mScoreLabel = (TextView) itemView.findViewById(R.id.scoreLabel);
            mAddButton = (Button) itemView.findViewById(R.id.addButton);
            mMinusButton = (Button) itemView.findViewById(R.id.minusButton);
        }

        public void bindHole(Hole hole) {
            String holeString = "Hole " + hole.getHole() + ":";
            mHoleLabel.setText(holeString);
            mScoreLabel.setText(hole.getScore() + "");
        }
    }
}
