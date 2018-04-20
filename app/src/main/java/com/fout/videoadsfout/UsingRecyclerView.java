package com.fout.videoadsfout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fout.videoadsfout.Adapter.RecViewAdapter;
import com.fout.videoadsfout.Model.News;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.fout.rfp.android.sdk.RFP;
import jp.fout.rfp.android.sdk.instream.RFPInstreamAdPlacer;
import jp.fout.rfp.android.sdk.instream.RFPInstreamAdPlacerListener;
import jp.fout.rfp.android.sdk.model.RFPInstreamInfoModel;

public class UsingRecyclerView extends AppCompatActivity {
    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    private Unbinder unbinder;
    RecViewAdapter recViewAdapter;
    private RFPInstreamAdPlacer adPlacer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_recycler_view);
        initializeData();
        unbinder = ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recViewAdapter = new RecViewAdapter(getBaseContext(), Newslist, adPlacer);
        recyclerView.setAdapter(recViewAdapter);
        loadfout();
    }


    private List<Object> Newslist;

    private void initializeData() {
        Newslist = new ArrayList<>();
        Newslist.add(new News("Diskusi di Lemhanas, Hasto Beber Peran Parpol Cetak Pemimpin", "Kamis, 19 April 2018 – 14:16 WIB", "http://photo.jpnn.com/arsip/watermark/2018/04/19/sekjen-pdip-hasto-kristiyanto-berdiri-saat-menjadi-pembicara-dalam-diskusi-di-lemhanas-jakarta-pusat-kamis-194-foto-dokumentasi-pdip-for-jpnn.jpg", "Nasional"));
        Newslist.add(new News("Tiket Presale Konser Mariah Carey di Borobudur Ludes 5 Menit", "Kamis, 19 April 2018 – 14:12 WIB", "http://photo.jpnn.com/arsip/watermark/2018/04/19/mariah-carey-akan-tampil-di-kawasan-candi-borobudur-jawa-tengah-6-november-2018-foto-rajawali-indonesia-communication-for-jpcjpnn.jpg", " Entertainment"));
        Newslist.add(new News("Rossi Pengin Memutus Rekor Marc Marquez di MotoGP Amerika", "Kamis, 19 April 2018 – 14:11 WIB", "http://photo.jpnn.com/timthumb.php?src=https://photo.jpnn.com/arsip/normal/2017/05/07/67097026dc538d73f4cd904c13d5e72f.jpg&w=510&h=294&zc=1&q=70", " Olahraga"));
        Newslist.add(new News("Nekat, Turis Spanyol Panjat Padmasana Pura Besakih", "Kamis, 19 April 2018 – 14:09 WIB", "http://photo.jpnn.com/arsip/watermark/2018/04/19/turis-spanyol-bernama-bernat-purel-mundo-yang-memanjat-padmasana-pura-besakih-di-bali-sehingga-menimbulkan-kemarahan-foto-youtube.jpg", " Bali "));
        Newslist.add(new News("Diskusi di Lemhanas, Hasto Beber Peran Parpol Cetak Pemimpin", "Kamis, 19 April 2018 – 14:16 WIB", "http://photo.jpnn.com/arsip/watermark/2018/04/19/sekjen-pdip-hasto-kristiyanto-berdiri-saat-menjadi-pembicara-dalam-diskusi-di-lemhanas-jakarta-pusat-kamis-194-foto-dokumentasi-pdip-for-jpnn.jpg", "Nasional"));
        Newslist.add(new News("Tiket Presale Konser Mariah Carey di Borobudur Ludes 5 Menit", "Kamis, 19 April 2018 – 14:12 WIB", "http://photo.jpnn.com/arsip/watermark/2018/04/19/mariah-carey-akan-tampil-di-kawasan-candi-borobudur-jawa-tengah-6-november-2018-foto-rajawali-indonesia-communication-for-jpcjpnn.jpg", " Entertainment"));
        Newslist.add(new News("Rossi Pengin Memutus Rekor Marc Marquez di MotoGP Amerika", "Kamis, 19 April 2018 – 14:11 WIB", "http://photo.jpnn.com/timthumb.php?src=https://photo.jpnn.com/arsip/normal/2017/05/07/67097026dc538d73f4cd904c13d5e72f.jpg&w=510&h=294&zc=1&q=70", " Olahraga"));
        Newslist.add(new News("Nekat, Turis Spanyol Panjat Padmasana Pura Besakih", "Kamis, 19 April 2018 – 14:09 WIB", "http://photo.jpnn.com/arsip/watermark/2018/04/19/turis-spanyol-bernama-bernat-purel-mundo-yang-memanjat-padmasana-pura-besakih-di-bali-sehingga-menimbulkan-kemarahan-foto-youtube.jpg", " Bali "));
    }

    private void loadfout() {

        RFP.init(this, "1144");

        // (4) Generation of RFPInstreamAdPlacer
        adPlacer = RFP.createInstreamAdPlacer(this, "NTI1OjI3MTY");
        // (1) Set listener in RFPInstreamAdAdapter
        adPlacer.setAdListener(new RFPInstreamAdPlacerListener() {

            // (2) When advertising loading is complete
            // Acquire the advertising case information to pass placeAd(RFPInstreamInfoModel advsinstreaminfomodel, View view, ViewGroup viewgroup) of the RFPInstreamAdPlacer to be described later
            @Override
            public void onAdsLoaded(List<? extends RFPInstreamInfoModel> items) {
                int i = 3;
                Log.d("fout", "onAdsLoaded: " + items.size());
                for (RFPInstreamInfoModel adData : items) {
                    Newslist.add(i, adData);
                    i += 3;
                }
                recViewAdapter.notifyDataSetChanged();
            }

            // (3) When main image loading in advertising View is complete
            @Override
            public void onAdMainImageLoaded(String imageUrl) {
            }

            // (4) When icon image loading in advertising View is complete
            @Override
            public void onAdIconImageLoaded(String imageUrl) {
            }

            // (5) When advertising loading fails
            @Override
            public void onAdsLoadedFail(String errorString) {
            }

            // (6) When advertising View image loading fails
            @Override
            public void onAdImageLoadedFail(String imageUrl, String errorString) {
            }

            // (7) When clicking advertising View
            @Override
            public void onAdClicked(String redirectURL) {
            }
        });
        adPlacer.loadAd();
//        adPlacer.measureImp(adData);
    }
}
