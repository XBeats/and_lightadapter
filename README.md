# and_lightadapter
A new way to define RecyclerView.Adapter

##Features
- first set `dataBinding.enabled = true`

##Usage
The core interface **ViewModel**

``` java  
   public interface ViewModel<Ad extends LightAdapter, T extends ViewDataBinding> {

    int getViewType();

    LightViewHolder<T> onCreateViewHolder(ViewGroup parent, int viewType);

    void bindViewForData(Ad lightAdapter, T dataBinding);
   }  
```

This Solution use the Databinding, and every javaBean must implement ViewModel.That's all what you need to do.

``` java 

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

```

##ScreenShot
![image](https://raw.githubusercontent.com/XBeats/and_lightadapter/master/screenshot/lightadapter.gif)