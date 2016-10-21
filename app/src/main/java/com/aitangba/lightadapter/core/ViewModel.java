package com.aitangba.lightadapter.core;

import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

/**
 * Created by fhf11991 on 2016/10/20.
 */

public interface ViewModel<Ad extends LightAdapter, T extends ViewDataBinding> {

    int getViewType();

    LightViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType);

    void bindViewForData(Ad lightAdapter, T dataBinding);
}
