package cn.ckz.kumiweather.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.db.City;
import cn.ckz.kumiweather.manager.CityManager;
import cn.ckz.kumiweather.presenter.addcity.IAddCityPresenter;
import cn.ckz.kumiweather.utils.ACache;
import cn.ckz.kumiweather.utils.LogUtils;
import cn.ckz.kumiweather.utils.StatusBarUtil;
import cn.ckz.kumiweather.view.mvpview.addcity.IAddCityView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class AddCityActivity extends AppCompatActivity implements TextWatcher,IAddCityView,AdapterView.OnItemClickListener,
        View.OnClickListener{
    private String TAG = getClass().getSimpleName();
    private ImageView finishbtn;
    private EditText inputbox;
    private ImageView voicebtn;
    private ListView resultlist;

    private List<String> mData;
    private ArrayAdapter<String> mAdapter;

    private IAddCityPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_city);
        StatusBarUtil.setColor(this, Color.WHITE,40);
        initView();
        presenter = new IAddCityPresenter(this,this);
    }

    private void initView() {
        resultlist = (ListView) findViewById(R.id.result_list);
        voicebtn = (ImageView) findViewById(R.id.voice_btn);
        inputbox = (EditText) findViewById(R.id.input_box);
        finishbtn = (ImageView) findViewById(R.id.finish_btn);

        inputbox.addTextChangedListener(this);
        mData = new ArrayList<>();
        mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mData);
        resultlist.setAdapter(mAdapter);
        resultlist.setOnItemClickListener(this);
        finishbtn.setOnClickListener(this);

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {

        mData.clear();
        presenter.searchCity(charSequence.toString());
        LogUtils.d(TAG,mData.size()+"");
    }

    @Override
    public void afterTextChanged(final Editable editable) {

    }

    @Override
    public void showCityList(final List<City> cityList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                LogUtils.d(getClass().getSimpleName(),cityList.size()+"");
                for (City city:cityList){
                    String point = city.getCityNameCh()+"-"+city.getBelongCityCh();
                    mData.add(point);
                }
                mAdapter.notifyDataSetChanged();
                LogUtils.d(getClass().getSimpleName(),mData.size()+"");
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        final String[] data = mData.get(i).split("-");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onComplete();
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Integer integer) {
                switch (integer){
                    case 1:

                        presenter.saveWeatherCity(data[0],data[1],2);
                        break;
                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
//                finish();
                ACache.get(AddCityActivity.this).put("new_city",data[0]);
                Intent intent = new Intent(AddCityActivity.this,MainPageActivity.class);
                startActivity(intent);

            }
        });

//      startActivity(new Intent(this, CityManagerActivity.class));
      finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.finish_btn:
                finish();
                break;
        }
    }
}
