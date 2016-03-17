package com.myapps.mkain.dccharacters.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.myapps.mkain.dccharacters.R;
import com.myapps.mkain.dccharacters.model.Character;

import java.util.List;

public class CharacterArrayAdapter extends ArrayAdapter<Character> {

    private final Activity context;
    private final List<Character> characterList;

    public CharacterArrayAdapter(Activity context, List<Character> characterList) {
        super(context, R.layout.item_character, characterList);
        this.context = context;
        this.characterList = characterList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        CharacterViewHolder holder;
        View rowView = convertView;

        if(rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_character, null, true);

            holder = new CharacterViewHolder();
            holder.name = (TextView) rowView.findViewById(R.id.character_name);
            holder.realName = (TextView) rowView.findViewById(R.id.character_real_name);
            holder.image = (ImageView) rowView.findViewById(R.id.character_image);

            rowView.setTag(holder);
        }

        holder = (CharacterViewHolder) rowView.getTag();
        holder.name.setText(characterList.get(position).getName());
        holder.realName.setText(characterList.get(position).getRealName());
        holder.image.setImageResource(characterList.get(position).getImageID());

        return rowView;
    }

}


