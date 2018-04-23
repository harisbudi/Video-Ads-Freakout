package com.fout.videoadsfout.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fout.videoadsfout.Model.News;
import com.fout.videoadsfout.R;
import com.fout.videoadsfout.UI.FoutVideoHolder;
import com.fout.videoadsfout.UI.NewsFeedHolder;

import java.util.List;

import jp.fout.rfp.android.sdk.instream.RFPInstreamAdPlacer;
import jp.fout.rfp.android.sdk.model.RFPInstreamInfoModel;

public class RecViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Object> items;
    private final int HEAD_THUMB = 0;
    private final int TERBARU = 1;
    private final int ADS_FOUT_VIDEO = 2;
    // (2) Definition of RFPInstreamAdPlacer
    private RFPInstreamAdPlacer adPlacer;
    private final String TAG = "RecViewAdapter";

    public RecViewAdapter(Context context, List<Object> items, RFPInstreamAdPlacer adPlacer) {
        this.adPlacer = adPlacer;
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RecyclerView.ViewHolder holder;
        View view;
        switch (viewType) {
            case HEAD_THUMB:
                view = inflater.inflate(R.layout.item_list_newsfeed_thumb, parent, false);
                holder = new NewsFeedHolder(view);
                break;
            case ADS_FOUT_VIDEO:
                view = inflater.inflate(R.layout.item_list_freakout, parent, false);
                holder = new FoutVideoHolder(view);
                break;
            case TERBARU:
                view = inflater.inflate(R.layout.item_list_newsfeed, parent, false);
                holder = new NewsFeedHolder(view);
                break;
            default:
                view = inflater.inflate(R.layout.item_list_newsfeed, parent, false);
                holder = new NewsFeedHolder(view);
                break;
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case HEAD_THUMB:
            case TERBARU:
                News feed = (News) items.get(position);
                NewsFeedHolder n = (NewsFeedHolder) holder;
                n.setdata(feed);
                break;
            case ADS_FOUT_VIDEO:
                Log.d("fout", "onBindViewHolder: ");
                RFPInstreamInfoModel adsdata = (RFPInstreamInfoModel) items.get(position);
                FoutVideoHolder F = (FoutVideoHolder) holder;


                F.setData(adsdata);

                F.view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        F.adVideo.pause();
//                        adPlacer.sendClickEvent(adsdata);
                    }
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
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

    boolean isplay = false;
    boolean neverplay = true;

    public void VisibiltyTreshold(RecyclerView.ViewHolder viewHolder, float visibility) {
        if (viewHolder.getItemViewType() == ADS_FOUT_VIDEO) {
            FoutVideoHolder v = (FoutVideoHolder) viewHolder;
            if (visibility >= 50) {
                if (neverplay) {
                    RFPInstreamInfoModel adsdata = (RFPInstreamInfoModel) items.get(viewHolder.getAdapterPosition());
                    v.adVideo.processAd(adsdata);
                    adPlacer.measureImp(adsdata);
                    neverplay = false;
                    isplay = true;
                } else {
                    if (isplay) {

                    } else {
                        v.adVideo.play();
                        isplay = true;
                    }
                }
            } else {
                v.adVideo.pause();
                isplay = false;
            }
        }
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
}
