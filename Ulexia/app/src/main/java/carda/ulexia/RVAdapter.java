package carda.ulexia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;



public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BlockViewHolder> {

    public Context context;

    public static class BlockViewHolder extends RecyclerView.ViewHolder {

        CardView cv;

        TextView pName;
        Button pButton;
        //
        TextView filename;
        TextView filedata;

        BlockViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            pName = (TextView)itemView.findViewById(R.id.pName);

            pButton = (Button)itemView.findViewById(R.id.pButton);
        }
    }

    List<Block> blocks;

    RVAdapter(List<Block> blocks, Context context){
        this.blocks = blocks;
        this.context = context;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public BlockViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        BlockViewHolder pvh = new BlockViewHolder(v);
        return pvh;
    }


    @Override
    public void onBindViewHolder(BlockViewHolder BlockViewHolder, int i) {
        final String name = blocks.get(i).filename;
        BlockViewHolder.pName.setText(name);

        // block variables

        BlockViewHolder.pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(context, CardView.class);
                intent.putExtra("name", name);

                context.startActivity(intent);
            }
        });
//        BlockViewHolder.personPhoto.setImageResource(persons.get(i).photoId);
    }

    @Override
    public int getItemCount() {
        return blocks.size();
    }
}