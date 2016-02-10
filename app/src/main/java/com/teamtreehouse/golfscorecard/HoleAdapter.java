package com.teamtreehouse.golfscorecard;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

        @Bind(R.id.holeLabel) TextView mHoleLabel;
        @Bind(R.id.scoreLabel) TextView mScoreLabel;

        public HoleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindHole(Hole hole) {
            String holeString = "Hole " + hole.getHole() + ":";
            mHoleLabel.setText(holeString);
            mScoreLabel.setText(hole.getScore() + "");
        }

        @OnClick(R.id.addButton)
        public void addScore() {
            int position = this.getAdapterPosition();
            Hole hole = mHoles[position];
            mHoles[position].setScore(hole.getScore() + 1);
            mScoreLabel.setText(hole.getScore() + "");
        }

        @OnClick(R.id.minusButton)
        public void minusScore() {
            int position = this.getAdapterPosition();
            Hole hole = mHoles[position];

            if (hole.getScore() - 1 >= 0) {
                mHoles[position].setScore(hole.getScore() - 1);
            }

            mScoreLabel.setText(hole.getScore() + "");
        }
    }
}
