package com.droidev.util.expensetracker.ui;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.general.PreferenceHelper;
import com.droidev.util.expensetracker.ui.adapter.DrawerAdapter;
import com.droidev.util.expensetracker.ui.model.ListItems;
import com.droidev.util.expensetracker.ui.model.NavigationDrawerMenuItem;
import com.droidev.util.expensetracker.ui.model.NavigationMenuHeaderItem;

import java.util.ArrayList;


public class HomeActivity extends BaseActivity implements DrawerAdapter.DrawerInteractListener,
        ToolbarFragment.AttachToolbar{

    private ArrayList<ListItems> mDrawerItems;
    private DrawerAdapter mDrawerAdapter;
    private RecyclerView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initHomeFragment();
        iniDrawer();
    }


    private void initHomeFragment() {
        ToolbarFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setAttachToolbar(this);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    private void iniDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (RecyclerView) findViewById(R.id.nav_items);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mDrawerList.setLayoutManager(manager);
        mDrawerList.hasFixedSize();
        showDrawerItems();

        mDrawerToggle = new ActionBarDrawerToggle(
                this,                  /* host Activity */
                mDrawerLayout,         /* DrawerLayout object */
                R.string.drawer_open,  /* "open drawer" description for accessibility */
                R.string.drawer_close  /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void showDrawerItems() {
        prepareDrawerItems();
        mDrawerAdapter = new DrawerAdapter(this, mDrawerItems);
        mDrawerList.setAdapter(mDrawerAdapter);
    }

    private void prepareDrawerItems() {
        getNavDrawerItemsList();
        addHeaderDetailsToDrawer();
    }

    private void addHeaderDetailsToDrawer() {
        NavigationMenuHeaderItem item= new NavigationMenuHeaderItem();
        // TODO: 24/2/16 remove hard coded name
        String userName = PreferenceHelper.getUserName(this);
        String userEmail = PreferenceHelper.getUserEmail(this);
        item.setUserName("User Name");
        item.setUserEmail("info4shajeer@gmail.com");
        mDrawerItems.add(0, item);
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


    @Override
    public void onDrawerItemClicked(int position) {
        launchScreens(position);
    }

    private void launchScreens(int position) {

        switch (position) {

            case 1:
                launchScreen(HomeActivity.class);
                break;
            case 2:
                launchScreen(SettingsActivity.class);
                break;
            case 3:
                launchScreen(UserProfileActivity.class);
                break;
            case 4:
                launchScreen(DashBoardActivity.class);
                break;
            case 5:
                launchScreen(LoginActivity.class);
                break;
            default:
                break;
        }
    }

    private void launchScreen(Class<?> activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    @Override
    public void onAttachToolbar(Toolbar toolbar) {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar,
                0,
                0);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

    }
}
