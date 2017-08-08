package org.jay.basedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.jay.basedemo.bannerviewpager.other.transformer.RotateDownTransformer;
import org.jay.baselib.widget.BannerViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WidgetActivity extends AppCompatActivity {

    @BindView(R.id.banner)
    BannerViewPager mBanner;
    public static List<?> images = new ArrayList<>();
    public static List<String> titles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);
        ButterKnife.bind(this);
        initData();
        initView();
    }
    private void initView() {
        /**
         * BannerViewPager
         */
        mBanner.setImages(images)
                .setDelayTime(3000)
                .setPageTransformer(true, new RotateDownTransformer())
                .setBannerTitles(titles)
                .setBannerStyle(BannerViewPager.BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                .start();
    }
    private void initData() {
        /**
         * BannerViewPager
         */
        String[] urls = getResources().getStringArray(R.array.url);
        String[] tips = getResources().getStringArray(R.array.title);
        List list = Arrays.asList(urls);
        images = new ArrayList(list);
        List list1 = Arrays.asList(tips);
        titles = new ArrayList(list1);
    }
}
