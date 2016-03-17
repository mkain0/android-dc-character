package com.myapps.mkain.dccharacters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SingleListItem extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.details_character);

        TextView title = (TextView) findViewById(R.id.character_title);
        TextView description = (TextView) findViewById(R.id.character_description);

        Intent intent = getIntent();
        String selectedItemTitle = intent.getStringExtra("selectedItemTitle");
        String selectedItemDescription = intent.getStringExtra("selectedItemDescription");
        title.setText(selectedItemTitle);
        description.setText(selectedItemDescription);
    }

}
