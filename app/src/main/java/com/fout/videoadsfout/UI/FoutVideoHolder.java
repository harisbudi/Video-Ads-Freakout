package com.fout.videoadsfout.UI;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.fout.videoadsfout.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.fout.rfp.android.sdk.model.RFPInstreamInfoModel;
import jp.fout.rfp.android.sdk.video.VideoAdView;

public class FoutVideoHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.custom_instream_advertiser_name)
    TextView advertiserName;
    @BindView(R.id.custom_instream_sponsor_name)
    TextView adSponsoredLabel;
    @BindView(R.id.custom_instream_video_view)
    VideoAdView adVideo;
    @BindView(R.id.custom_instream_ad_text)
    TextView adText;

    public View view;

    public FoutVideoHolder(View convertView) {
        super(convertView);
        view = convertView;
        ButterKnife.bind(this, view);
    }

    public void setData(RFPInstreamInfoModel adData) {
        advertiserName.setText(adData.title());
        adText.setText(adData.content());

        String displayedAdvertiser = adData.displayedAdvertiser();
        if (null != displayedAdvertiser && 0 < displayedAdvertiser.length()) {
            adSponsoredLabel.setText(displayedAdvertiser);
        }
    }
}