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
    private TextView adSponsoredLabel, advertiserName, adText;
    public VideoAdView adVideo;
    public View view;

    public FoutVideoHolder(View convertView) {
        super(convertView);
        view = convertView;
        advertiserName = convertView.findViewById(R.id.custom_instream_advertiser_name);
        adSponsoredLabel = convertView.findViewById(R.id.custom_instream_sponsor_name);
        adVideo = convertView.findViewById(R.id.custom_instream_video_view);
        adText = convertView.findViewById(R.id.custom_instream_ad_text);
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