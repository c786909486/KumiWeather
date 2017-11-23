package cn.ckz.kumiweather.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.vuandroidadsdk.utils.MyDialogUtils;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

import cn.ckz.kumiweather.R;
import cn.ckz.kumiweather.adapter.citymanager.CityManagerAdapter;
import cn.ckz.kumiweather.db.CitySave;
import cn.ckz.kumiweather.presenter.citymanager.ICityManagerPresenter;
import cn.ckz.kumiweather.utils.LogUtils;
import cn.ckz.kumiweather.utils.StatusBarUtil;
import cn.ckz.kumiweather.view.fragment.WeatherFragment;
import cn.ckz.kumiweather.view.mvpview.citymanager.ICityManagerView;
import cn.ckz.kumiweather.view.view.DragListView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class CityManagerActivity extends AppCompatActivity implements ICityManagerView, View.OnClickListener,AdapterView.OnItemClickListener
,AdapterView.OnItemLongClickListener{

    private ImageView backbtn;
    private ImageView addbtn;
    private ListView citylistview;

    private ICityManagerPresenter presenter;
    private List<CitySave> mData;
    private CityManagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_manager);
        StatusBarUtil.setColor(this, Color.WHITE,40);
        initView();
        presenter = new ICityManagerPresenter(this,this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.getCityList();
    }

    private void initView() {
        citylistview =  findViewById(R.id.city_list_view);
        addbtn = (ImageView) findViewById(R.id.add_btn);
        backbtn = (ImageView) findViewById(R.id.back_btn);
        addbtn.setOnClickListener(this);
        backbtn.setOnClickListener(this);

        mData = new ArrayList<>();
        mAdapter = new CityManagerAdapter(this,mData);
        citylistview.setAdapter(mAdapter);
        citylistview.setOnItemClickListener(this);
        citylistview.setOnItemLongClickListener(this);
//        citylistview.setDragImageSourceId(R.id.drag_btn);
        //citylistview.setDragItemChangeListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.add_btn:
                //跳转到添加城市界面
                startActivity(new Intent(this,AddCityActivity.class));
                break;
        }
    }

    @Override
    public void showCity(final List<CitySave> cityList) {
       for (CitySave citySave: cityList){
           if (!mData.contains(citySave)){
               if (citySave.getType() == 1){
                   mData.add(0,citySave);
               }else {
                   mData.add(citySave);
               }
           }
       }
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(this,WeatherFragment.class);
        intent.putExtra("POSITION",i);
        setResult(RESULT_OK,intent);
        finish();
    }

    private MyDialogUtils dialogUtils = MyDialogUtils.getInstance();

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

       if (position!=0){
           dialogUtils.createNormalDialog(CityManagerActivity.this, "", "确定删除该城市吗？", new DialogInterface.OnClickListener() {
               @Override
               public void onClick(DialogInterface dialogInterface, int i) {
                   deleteCity(position);
               }
           });
       }
        return true;
    }

    private void deleteCity(final int position){
        presenter.deleteCity(mData.get(position).getCity());
       mData.remove(position);
       mAdapter.notifyDataSetChanged();
    }


}
