package com.droidev.util.expensetracker.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.droidev.util.expensetracker.R;
import com.droidev.util.expensetracker.ui.CircleTransform;
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
    DrawerInteractListener mListener;

    public DrawerAdapter(Context mContext, ArrayList<ListItems> mDataSet) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
        mListener = (DrawerInteractListener) mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

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

        if (holder instanceof DrawerMenuItemViewHolder) {
            setDrawerItem((DrawerMenuItemViewHolder) holder, position);
        } else if (holder instanceof DrawerHeaderItemHolder) {
            setHeaderData((DrawerHeaderItemHolder) holder, position);
        }
    }

    private void setHeaderData(DrawerHeaderItemHolder holder, int position) {
        NavigationMenuHeaderItem item = (NavigationMenuHeaderItem) mDataSet.get(position);
        String userName = item.getmUserName();
        String userEmail = item.getmUserEmail();

        if (!TextUtils.isEmpty(userName)) {
            holder.mUserName.setText(userName);
        }

        if (!TextUtils.isEmpty(userEmail)) {
            holder.mUserEmail.setText(userEmail);
        }

        Drawable userPic = ContextCompat.getDrawable(mContext, R.drawable.profile);
        Picasso.with(mContext).load(item.getmUserImage()).placeholder(userPic)
                .transform((new
                        CircleTransform()))
                .into(holder.mUserImage);
    }

    private void setDrawerItem(DrawerMenuItemViewHolder holder, final int position) {
        NavigationDrawerMenuItem item = (NavigationDrawerMenuItem) mDataSet.get(position);
        String menuName = item.getMenuName();

        if (!TextUtils.isEmpty(menuName)) {
            holder.mDrawerMenu.setText(menuName);
        }
        int imageId = item.getMenuImageId();
        Picasso.with(mContext).load(imageId).into(holder.mDrawerIcon);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            holder.mDrawerIcon.setImageAlpha(150);
        } else {
            holder.mDrawerIcon.setAlpha(150);
        }

        holder.mMenuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                triggerDrawerItemClick(position);
            }
        });
    }

    /**
     * triggering drawer item click to activity
     * @param position position of clicked item
     */
    private void triggerDrawerItemClick(int position) {

        if (mListener != null) {
            mListener.onDrawerItemClicked(position);
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
        TextView mUserEmail;
        ImageView mUserImage;

        public DrawerHeaderItemHolder(View itemView) {
            super(itemView);
            mUserName = (TextView) itemView.findViewById(R.id.user_name);
            mUserEmail = (TextView) itemView.findViewById(R.id.user_mail);
            mUserImage = (ImageView) itemView.findViewById(R.id.user_pic);
        }
    }

    private class DrawerMenuItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout mMenuItem;
        ImageView mDrawerIcon;
        TextView mDrawerMenu;

        public DrawerMenuItemViewHolder(View itemView) {
            super(itemView);
            mMenuItem = (LinearLayout) itemView.findViewById(R.id.menu_item_panel);
            mDrawerIcon = (ImageView) itemView.findViewById(R.id.drawer_icon);
            mDrawerMenu = (TextView) itemView.findViewById(R.id.menu_item);
        }
    }

    public interface DrawerInteractListener {
        void onDrawerItemClicked(int position);
    }
}
