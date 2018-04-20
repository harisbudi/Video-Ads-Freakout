package com.fout.videoadsfout.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.fout.videoadsfout.Model.News;
import com.fout.videoadsfout.R;
import com.fout.videoadsfout.UI.FoutVideoHolder;
import com.fout.videoadsfout.UI.NewsFeedHolder;

import java.util.List;

import jp.fout.rfp.android.sdk.model.RFPInstreamInfoModel;

public class ListViewAdapter extends BaseAdapter {

    private static final String TAG_DEFAULT = "TAG_DEFAULT";
    private Context context;
    private List<Object> items;
    private final int HEAD_THUMB = 0;
    private final int TERBARU = 1;
    private final int ADS_FOUT_VIDEO = 2;

    public ListViewAdapter(Context context, List<Object> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();

    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof News) {
            if (position == 0) {
                return HEAD_THUMB;
            } else
                return TERBARU;
        } else if (isVideoAd(position)) {
            return ADS_FOUT_VIDEO;
        }
        return -1;
    }


    private boolean isAd(int position) {
        return (items.get(position) instanceof RFPInstreamInfoModel);
    }

    private boolean isVideoAd(int position) {
        if (!isAd(position)) {
            return false;
        }
        RFPInstreamInfoModel item = (RFPInstreamInfoModel) items.get(position);
        return item.isVideo();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);

        NewsFeedHolder news;
        FoutVideoHolder fout;
        switch (getItemViewType(position)) {
            case HEAD_THUMB:
                view = inflater.inflate(R.layout.item_list_newsfeed_thumb, parent, false);
                news = new NewsFeedHolder(view);
                news.setdata((News) items.get(position));
                break;
            case TERBARU:
                view = inflater.inflate(R.layout.item_list_newsfeed, parent, false);
                news = new NewsFeedHolder(view);
                news.setdata((News) items.get(position));
                break;

            case ADS_FOUT_VIDEO:
                view = inflater.inflate(R.layout.item_list_freakout, parent, false);
                fout = new FoutVideoHolder(view);
                fout.setData((RFPInstreamInfoModel) items.get(position));
                break;
            default:
                view = inflater.inflate(R.layout.item_list_newsfeed, parent, false);
                news = new NewsFeedHolder(view);
                news.setdata((News) items.get(position));
                break;
        }

        return view;
    }
}

