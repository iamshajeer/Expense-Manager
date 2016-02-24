package com.droidev.util.expensetracker.ui;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.ui.adapter.DrawerAdapter;
import com.droidev.util.expensetracker.ui.model.ListItems;
import com.droidev.util.expensetracker.ui.model.NavigationDrawerMenuItem;
import com.droidev.util.expensetracker.ui.model.NavigationMenuHeaderItem;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity{

    private ArrayList<ListItems> mDrawerItems;
    private DrawerAdapter mDrawerAdaper;
    private RecyclerView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initUi();
        manageAddExpenseButton();
    }

    private void manageAddExpenseButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "we are working on this :-)", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initUi() {
        mDrawerList = (RecyclerView) findViewById(R.id.nav_items);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mDrawerList.setLayoutManager(manager);
        mDrawerList.hasFixedSize();
        showDrawerItems();
    }

    private void showDrawerItems() {
        prepareDrawerItems();
        mDrawerAdaper = new DrawerAdapter(this, mDrawerItems);
        mDrawerList.setAdapter(mDrawerAdaper);
    }

    private void prepareDrawerItems() {
        getNavDrawerItemsList();
        addHeaderDetailsToDrawer();
    }

    private void addHeaderDetailsToDrawer() {
        NavigationMenuHeaderItem item= new NavigationMenuHeaderItem();
        // TODO: 24/2/16 remove hard coded name
        item.setUserName("User Name");
        item.setUserEmail("info4shajeer@gmail.com");
        mDrawerItems.add(0,item);
    }

    private void getNavDrawerItemsList() {
        String[] drawerMenuTitles = getResources().getStringArray(R.array.drawer_menu_items);
        mDrawerItems = new ArrayList<>(drawerMenuTitles.length);
        TypedArray icons = getResources().obtainTypedArray(R.array.nav_drawer_item_icons);
        for (int i = 0; i < drawerMenuTitles.length; i++) {
            NavigationDrawerMenuItem navDrawerItem = new NavigationDrawerMenuItem();
            navDrawerItem.setMenuName(drawerMenuTitles[i]);
            int resId = icons.getResourceId(i, 0);
            navDrawerItem.setmMenuImageId(resId);
            mDrawerItems.add(navDrawerItem);
        }
    }


}
