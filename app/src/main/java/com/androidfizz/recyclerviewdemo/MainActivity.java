package com.androidfizz.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.androidfizz.recyclerviewdemo.adapters.ListAdapter;
import com.androidfizz.recyclerviewdemo.helper.MyDividerItemDecoration;
import com.androidfizz.recyclerviewdemo.helper.RecyclerItemTouchListener;
import com.androidfizz.recyclerviewdemo.models.AndroidVersion;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private Context context;
    private RecyclerView recyclerView;
    private ListAdapter adapter;
    private List<AndroidVersion> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context=this;

        list=getVersionsList();
        adapter=new ListAdapter(context, list);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        //if your layout has fixed size this will improve it performance
        recyclerView.setHasFixedSize(true);

        //using DividerItemDecoration from support library
        /*DividerItemDecoration dividerItemDecoration= new DividerItemDecoration(context,
                LinearLayoutManager.VERTICAL);

        //setting custom drawable as a divider
        Drawable drawable= ContextCompat.getDrawable(context, R.drawable.divider);
        if(drawable!=null)
            dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);*/


        //default divider using custom ItemDecoration
        //recyclerView.addItemDecoration(new MyDividerItemDecoration(context));

        //setting custom drawable as a divider
        recyclerView.addItemDecoration(new MyDividerItemDecoration(context, R.drawable.divider));

        recyclerView.setAdapter(adapter);

        /*adapter.setOnItemClickListener(new ListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast("Clicked "+position);
            }

            @Override
            public void onItemLongPress(int position) {
                showToast("long Clicked "+position);
            }
        });*/

        recyclerView.addOnItemTouchListener(new RecyclerItemTouchListener(this,
                        new RecyclerItemTouchListener.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showToast("Clicked "+position);
            }

            @Override
            public void onItemLongPress(int position) {
                showToast("long Clicked "+position);
            }
        }));
    }

    private List<AndroidVersion> getVersionsList(){
        List<AndroidVersion> list = new ArrayList<>();
        list.add(new AndroidVersion(R.drawable.cupcake,"Cupcake", "1.5", "3"));
        list.add(new AndroidVersion(R.drawable.donut,"Donut", "1.6", "4"));
        list.add(new AndroidVersion(R.drawable.eclair,"Eclair", "2.0 - 2.1", "5 - 7"));
        list.add(new AndroidVersion(R.drawable.froyo,"Froyo", "2.2 – 2.2.3", "8"));
        list.add(new AndroidVersion(R.drawable.ginger_bread,"Gingerbread", "2.3 – 2.3.7", "9 – 10"));
        list.add(new AndroidVersion(R.drawable.honeycomb,"Honeycomb", "3.0 – 3.2.6", "11 – 13"));
        list.add(new AndroidVersion(R.drawable.ice_cream_sandwich,"Ice Cream Sandwich", "4.0 – 4.0.4", "14 – 15"));
        list.add(new AndroidVersion(R.drawable.jelly_bean,"Jelly Bean", "4.1 – 4.3.1", "16 – 18"));
        list.add(new AndroidVersion(R.drawable.kitkat,"KitKat", "4.4 – 4.4.4", "19 – 20"));
        list.add(new AndroidVersion(R.drawable.lollipop,"Lollipop", "5.0 – 5.1.1", "21 – 22"));
        list.add(new AndroidVersion(R.drawable.marshmallow,"Marshmallow", "6.0 – 6.0.1", "23"));
        list.add(new AndroidVersion(R.drawable.nougat,"Nougat", "7.0 – 7.1.2", "24 – 25"));
        list.add(new AndroidVersion(R.drawable.oreo,"Oreo", "8.0 - 8.1", "26 - 27"));
        return list;
    }

    private void showToast(String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
