package com.myapps.mkain.dccharacters;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.myapps.mkain.dccharacters.adapter.CharacterArrayAdapter;
import com.myapps.mkain.dccharacters.dao.CharacterDao;
import com.myapps.mkain.dccharacters.util.Resource;

public class MainActivity extends ListActivity {

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resource.init();

        list = getListView();
        CharacterArrayAdapter adapter = new CharacterArrayAdapter(this, CharacterDao.getInstance().findAll());
        setListAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItemTitle = CharacterDao.getInstance().findAll().get(position).getTitle();
                String selectedItemDescription = CharacterDao.getInstance().findAll().get(position).getDescription();

                Intent intent = new Intent(getApplicationContext(), SingleListItem.class);
                intent.putExtra("selectedItemTitle", selectedItemTitle);
                intent.putExtra("selectedItemDescription", selectedItemDescription);
                startActivity(intent);
            }
        });
    }
}

