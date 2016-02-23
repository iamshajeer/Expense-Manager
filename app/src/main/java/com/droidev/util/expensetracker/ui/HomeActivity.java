package com.droidev.util.expensetracker.ui;

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
        String[] drawerMenuList = getResources().getStringArray(R.array.drawer_menu_items);
        int totalMenus = drawerMenuList.length;
        //String[] drawerIconList = fillIconList(totalMenus);
        mDrawerItems = new ArrayList<>(totalMenus);
        addHeaderDetailsToDrawer();

        for (int index = 0; index < totalMenus; index++) {
            NavigationDrawerMenuItem item = new NavigationDrawerMenuItem();
            item.setMenuName(drawerMenuList[index]);
            mDrawerItems.add(item);
           // item.setMenuImageUrl(drawerIconList[index]);
        }
    }

    private void addHeaderDetailsToDrawer() {
        NavigationMenuHeaderItem item= new NavigationMenuHeaderItem();
        item.setUserName("Shajeer Ahamed");
        mDrawerItems.add(item);
    }

    private String[] fillIconList(int total) {
        String[] iconList = new String[total];

        for (int i = 0; i < total; i++) {

        }
        return iconList;
    }
}
