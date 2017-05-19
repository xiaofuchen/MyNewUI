package com.xiaofu.mynewui;

import android.content.res.ColorStateList;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import static com.xiaofu.mynewui.R.id.toolbar;

public class MainActivity extends AppCompatActivity {

    private CoordinatorLayout coordinatorlayout;
    private DrawerLayout drawer;
    private Toolbar mToolbar;
    private AppBarLayout appbarlayout;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private NavigationView navigationView;
    private TabLayout tablayout;
    private ViewPager viewpager,viewpager_photo;
    private FloatingActionButton flaotbutton;
    private int markColor = 0;
    private boolean toolbarLayoutClose = false;

    private SystemBarTintManager tintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化状态栏
        tintManager = new SystemBarTintManager(this);
        tintManager.setStatusBarTintEnabled(true);
        tintManager.setNavigationBarTintEnabled(true);

        initView();
    }

    private void initView() {
        appbarlayout = (AppBarLayout) findViewById(R.id.appbarlayout);

        mToolbar = (Toolbar) findViewById(toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        coordinatorlayout = (CoordinatorLayout) findViewById(R.id.coordinatorlayout);

        appbarlayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {//监听appbarlayout展开、收起状态
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                Log.d("STATE", state.name());
                if( state == State.EXPANDED ) {
                    //展开状态
                    mToolbar.setBackgroundColor(Color.TRANSPARENT);
                    toolbarLayoutClose = false;
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    if(0 != markColor){
                        mToolbar.setBackgroundColor(markColor);
                    }else {
                        mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    }
                    toolbarLayoutClose = true;
                }else {
                    //中间状态
                    mToolbar.setBackgroundColor(Color.TRANSPARENT);
                    toolbarLayoutClose = false;
                }
            }
        });

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(//设置ToolBar菜单键与DrawerLayout联动
                this, drawer, mToolbar, 0, 0){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if(0 == markColor){
                    tintManager.setStatusBarTintColor(Color.TRANSPARENT);
                }else {
                    tintManager.setStatusBarTintColor(markColor);
                }
            }

            @Override
            public void onDrawerStateChanged(int newState) {
                super.onDrawerStateChanged(newState);
                if(2 == newState){
                    tintManager.setStatusBarTintColor(Color.TRANSPARENT);
                }
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle("BEYOND");//设置标题
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);//设置收缩后Toolbar上字体的颜色

        navigationView = (NavigationView) findViewById(R.id.navigation_left);
        //侧边栏的菜单选项点击事件
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                Snackbar.make(coordinatorlayout, item.getTitle().toString(), Snackbar.LENGTH_SHORT).show();
                return false;
            }
        });

        viewpager_photo = (ViewPager)findViewById(R.id.viewpager_photo);
        viewpager_photo.setAdapter(new MyImagerPageAdapter(this));
        //设置滑动选择事件
        viewpager_photo.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //选择后
                switch (position){
                    case 0:
                        getChangeColor(R.mipmap.beyond2);
                        break;
                    case 1:
                        getChangeColor(R.mipmap.beyond3);
                        break;
                    case 2:
                        getChangeColor(R.mipmap.beyond4);
                        break;
                    case 3:
                        getChangeColor(R.mipmap.beyond5);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tablayout = (TabLayout)findViewById(R.id.tablayout);
        viewpager = (ViewPager)findViewById(R.id.viewpager);
        viewpager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        tablayout.setupWithViewPager(viewpager);//TabLayout设置与Viewpager关联
        //tablayout子选项选择事件
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选择后
                switch (tab.getPosition()){
                    case 0:
                        getChangeColor(R.mipmap.jiaju1);
                        break;
                    case 1:
                        getChangeColor(R.mipmap.paul1);
                        break;
                    case 2:
                        getChangeColor(R.mipmap.shirong1);
                        break;
                    case 3:
                        getChangeColor(R.mipmap.jiaqiang1);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //没有选择的
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //再次选择的
            }
        });
        flaotbutton = (FloatingActionButton)findViewById(R.id.flaotbutton);
        //浮动按钮点击事件
        flaotbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(coordinatorlayout, "Gitar", Snackbar.LENGTH_SHORT).show();
            }
        });

        getChangeColor(R.mipmap.beyond2);

    }

    private void getChangeColor(int res){
        //使用Palette异步去解析bitmap，获取bitmap里面的颜色值
        Palette.generateAsync(BitmapFactory.decodeResource(getResources(),res), new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                try {
                    // palette为生成的调色板
                    markColor = palette.getVibrantSwatch().getRgb();//获取充满活力的颜色值，可能获取不到会null，所以要做空指针处理
                    tablayout.setBackgroundColor(markColor);
                    if (toolbarLayoutClose) {
                        mToolbar.setBackgroundColor(markColor);
                    }
                    flaotbutton.setBackgroundTintList(ColorStateList.valueOf(markColor));
                    // 改变状态栏
                    tintManager.setStatusBarTintColor(markColor);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {//按下返回键时候，如果当前DrawerLayout处于打开状态，则先关闭DrawerLayout
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
