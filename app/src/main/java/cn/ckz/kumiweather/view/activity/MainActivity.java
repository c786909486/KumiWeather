package cn.ckz.kumiweather.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.db.City;
import cn.ckz.kumiweather.presenter.main.MMainPresenter;
import cn.ckz.kumiweather.utils.LogUtils;
import cn.ckz.kumiweather.utils.SPUtils;
import cn.ckz.kumiweather.utils.StatusBarUtil;
import cn.ckz.kumiweather.view.mvpview.main.MMainView;
import cn.ckz.kumiweather.view.view.SkipView;


public class MainActivity extends AppCompatActivity implements MMainView{
    private SkipView skipView;
    private MMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setTransparent(this);
        skipView = findViewById(R.id.skip_view);
        skipView.start(new SkipView.OnSkipListener() {
            @Override
            public void onClick(View view) {
                intentTo();
            }

            @Override
            public void onFinish() {
                intentTo();
            }
        });
        presenter = new MMainPresenter(this,this);
        presenter.getCityData();
        SPUtils.putBooleanSp(this,"isFirst",false);
//        List<City> md = City.findAll(City.class);
//        LogUtils.d("Main",md.get(0).getProvinceNameCh());
    }

    private void intentTo(){
        Intent intent = new Intent(this, MainPageActivity.class);
        startActivity(intent);
        finish();
    }
}
