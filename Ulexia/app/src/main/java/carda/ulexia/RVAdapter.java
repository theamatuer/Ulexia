package carda.ulexia;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;



public class RVAdapter extends RecyclerView.Adapter<RVAdapter.BlockViewHolder> {

    public Context context;

    public static class BlockViewHolder extends RecyclerView.ViewHolder {

        CardView cv;

        Button pButton;
//        String pText;
        //
//        TextView filename;
//        TextView filedata;


        BlockViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
//            pText =
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
    public void onBindViewHolder(BlockViewHolder blockViewHolder, int i) {
        final String name = blocks.get(i).filename;
        final String text = blocks.get(i).filetext;
        blockViewHolder.pButton.setText(name);

        // block variables

        blockViewHolder.pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                // load file
                String textcontent = text;
                Log.d("myTag", "button clicked");
                Log.d("myTag", name);
                Log.d("myTag", text);
//                FileInputStream fis = null;
//
//                try {
//                    fis = InsertView.openFileInput(name);
//                    InputStreamReader isr = new InputStreamReader(fis);
//                    BufferedReader br = new BufferedReader(isr);
//                    StringBuilder sb = new StringBuilder();
//                    String text;
//
//                    while ((text = br.readLine()) != null) {
//                        sb.append(text).append("\n");
//                    }
//
////                    mEditText.setText(sb.toString());
//                    textcontent = sb.toString();
//
//                    Log.d("myTag", textcontent);
////                    blockViewHolder.pName.setText(textcontent);
//
//                } catch (FileNotFoundException e) {
//                    Log.d("myTag", "caught1");
//
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    Log.d("myTag", "caught2");
//
//                    e.printStackTrace();
//                } finally {
//                    if (fis != null) {
//                        try {
//                            fis.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
                // end load file

                Intent intent = new Intent(context, CardaView.class);
                intent.putExtra("textcontent", textcontent);
//                Log.d("myTag", "made past here");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return blocks.size();
    }


}