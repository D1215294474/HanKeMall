package com.example.hankemall.adapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class LeadImgAdapter extends PagerAdapter {
    //放置2个页面
    private List<View> list;
    public LeadImgAdapter(List<View> list) {
        this.list = list;
    }
    //页个数面
    @Override
    public int getCount() {
        return list.size();
    }
    //判断当前页是否显示正确
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    //销毁不关联页面
    /** @param container  ViewPager
     * @param position  例如：0-1
     * @param object 例如：ImageView */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position));
    }
    //相当于getView方法
    //添加页面
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position));
        return list.get(position);//返回含有图片的ImageView
    }
}
