package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// 给ListView传递自定义子项布局的适配器
public class FruitAdapter extends ArrayAdapter<Fruit> {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourceId, List<Fruit> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    // 该方法在每个子项被滚动到屏幕内时被调用
    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        Fruit fruit = getItem(position); // 获取当前子项的实例

        // View view =
        //         LayoutInflater.from(getContext()).inflate(resourceId, parent, false);

        // // 用之前加载好的缓存布局converView提升ListView运行效率
        // View view;
        // if (converView == null) {
        //     view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
        //             false);
        // } else {
        //     view = converView;
        // }
        //
        // ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        // TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        // fruitImage.setImageResource(fruit.getImageId());
        // fruitName.setText(fruit.getName());

        // 用内部类ViewHolder对控件实例缓存，避免每次调用findViewById()，进一步提升ListView效率
        View view;
        ViewHolder viewHolder;
        if (converView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent,
                    false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitName = (TextView) view.findViewById(R.id.fruit_name);
            view.setTag(viewHolder); // 将viewHolder存储在View中
        } else {
            view = converView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitName.setText(fruit.getName());

        return view;
    }

    class ViewHolder {
        ImageView fruitImage;
        TextView fruitName;
    }
}
