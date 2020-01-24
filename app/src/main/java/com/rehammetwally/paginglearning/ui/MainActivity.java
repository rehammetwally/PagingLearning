package com.rehammetwally.paginglearning.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.rehammetwally.paginglearning.R;
import com.rehammetwally.paginglearning.data.api.API;
import com.rehammetwally.paginglearning.data.api.DBClient;
import com.rehammetwally.paginglearning.data.model.Item;
import com.rehammetwally.paginglearning.data.model.StackApiResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ItemViewModel viewModel;
    RecyclerView answers_rv;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        answers_rv=findViewById(R.id.answers_rv);
        answers_rv.setLayoutManager(new LinearLayoutManager(this));
        answers_rv.setHasFixedSize(true);

        viewModel= ViewModelProviders.of(this).get(ItemViewModel.class);
        final AnswersAdapter adapter=new AnswersAdapter(this);
        viewModel.itemPagedList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(PagedList<Item> items) {
                adapter.submitList(items);
            }
        });
        answers_rv.setAdapter(adapter);


    }
}
