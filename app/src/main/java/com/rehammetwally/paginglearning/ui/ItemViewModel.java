package com.rehammetwally.paginglearning.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.rehammetwally.paginglearning.data.model.Item;
import com.rehammetwally.paginglearning.data.repository.ItemDataSource;
import com.rehammetwally.paginglearning.data.repository.ItemDataSourceFactory;

public class ItemViewModel extends ViewModel {
     LiveData<PagedList<Item>> itemPagedList;
     LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;


    public ItemViewModel() {
        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();
        PagedList.Config config = new PagedList.Config.Builder().setEnablePlaceholders(false)
                .setPageSize(ItemDataSource.PAGE_SIZE)
                .build();

        itemPagedList = new LivePagedListBuilder(itemDataSourceFactory, config).build();

    }
}
