package com.aitangba.lightadapter;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aitangba.lightadapter.core.LightAdapter;
import com.aitangba.lightadapter.core.LightViewHolder;
import com.aitangba.lightadapter.core.ViewModel;
import com.aitangba.lightadapter.databinding.ItemDogBinding;
import com.aitangba.lightadapter.databinding.ItemLightAdapterBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private LightAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mAdapter = new LightAdapter());
        mAdapter.setData(getData(20));

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.addData(new DogViewModel());
            }
        });
    }

    private List<AnimViewModel> getData(int size) {
        List<AnimViewModel> list = new ArrayList<>(size);
        for(int i= 0; i< size ; i++) {
            AnimViewModel anim = new AnimViewModel();
            anim.age = i;
            anim.name = "名字" + i;
            list.add(anim);
        }
        return list;
    }

    private static class AnimViewModel extends Anim implements ViewModel<LightAdapter, ItemLightAdapterBinding> {

        @Override
        public int getViewType() {
            return R.layout.item_light_adapter;
        }

        @Override
        public LightViewHolder<ItemLightAdapterBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
            View contentView = LayoutInflater.from(parent.getContext()).inflate(getViewType(), parent, false);
            return new LightViewHolder(contentView);
        }

        @Override
        public void bindViewForData(LightAdapter lightAdapter, ItemLightAdapterBinding dataBinding) {
            dataBinding.nameText.setText(name);
        }
    }

    private static class DogViewModel implements ViewModel<LightAdapter, ItemDogBinding> {

        @Override
        public int getViewType() {
            return R.layout.item_dog;
        }

        @Override
        public LightViewHolder<ItemDogBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
            View contentView = LayoutInflater.from(parent.getContext()).inflate(getViewType(), parent, false);
            return new LightViewHolder(contentView);
        }

        @Override
        public void bindViewForData(LightAdapter lightAdapter, ItemDogBinding dataBinding) {

        }
    }
}
