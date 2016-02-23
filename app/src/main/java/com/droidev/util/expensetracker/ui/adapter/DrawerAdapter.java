package com.droidev.util.expensetracker.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.ui.model.ListItems;
import com.droidev.util.expensetracker.ui.model.NavigationDrawerMenuItem;
import com.droidev.util.expensetracker.ui.model.NavigationMenuHeaderItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by shajeer on 23/2/16.
 */
public class DrawerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList<ListItems> mDataSet;
    Context mContext;

    public DrawerAdapter(Context mContext, ArrayList<ListItems> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {

            case ListItems.NAVIGATION_HEADER_ITEM:
                view = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.drawer_header_item, parent, false);
                return new DrawerHeaderItemHolder(view);

            case ListItems.NAVIGATION_NORMAL_ITEM:
                view = LayoutInflater.
                        from(parent.getContext()).
                        inflate(R.layout.drawer_normal_item, parent, false);
                return new DrawerMenuItemViewHolder(view);
        }
        throw new RuntimeException("View holder not defined");
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(holder instanceof DrawerMenuItemViewHolder) {
            setDrawerItem((DrawerMenuItemViewHolder) holder, position);
        }else if(holder instanceof DrawerHeaderItemHolder) {
            setHeaderData((DrawerHeaderItemHolder) holder, position);
        }
    }

    private void setHeaderData(DrawerHeaderItemHolder holder, int position) {
        NavigationMenuHeaderItem item = (NavigationMenuHeaderItem) mDataSet.get(position);
        String userName = item.getmUserName();

        if(!TextUtils.isEmpty(userName)) {
            holder.mUserName.setText(userName);
        }
    }

    private void setDrawerItem(DrawerMenuItemViewHolder holder, int position) {
        NavigationDrawerMenuItem item = (NavigationDrawerMenuItem) mDataSet.get(position);
        String menuName = item.getMenuName();

        if(!TextUtils.isEmpty(menuName)) {
            holder.mDrawerMenu.setText(menuName);
        }
        String imageUrl = item.getMenuImageUrl();

        if(!TextUtils.isEmpty(imageUrl)) {
            Picasso.with(mContext).load(imageUrl)
                    .fit().centerCrop().into(holder.mDrawerIcon);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mDataSet.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    /**
     * View holder classes
     */
    private class DrawerHeaderItemHolder extends RecyclerView.ViewHolder {

        TextView mUserName;

        public DrawerHeaderItemHolder(View itemView) {
            super(itemView);
            mUserName = (TextView) itemView.findViewById(R.id.user_name);
        }
    }

    private class DrawerMenuItemViewHolder extends RecyclerView.ViewHolder {
        ImageView mDrawerIcon;
        TextView mDrawerMenu;

        public DrawerMenuItemViewHolder(View itemView) {
            super(itemView);
            mDrawerIcon = (ImageView) itemView.findViewById(R.id.drawer_icon);
            mDrawerMenu = (TextView) itemView.findViewById(R.id.menu_item);
        }
    }
}
