package com.example.yury.rk_1;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] data = new int[1000];
        for(int i = 0; i < 1000; i++) {
            data[i] = (i + 1);
        }

        RecyclerView recyclerView = findViewById(R.id.rvNumbers);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        adapter = new MyRecyclerViewAdapter(this, data);
        adapter.setClickListener(this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        final FragmentManager manager = getSupportFragmentManager();
        final FragmentTransaction transaction = manager.beginTransaction();

        transaction.replace(R.id.container, SingleNumberFragment.newInstance(Integer.valueOf(adapter.getItem(position))));
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
