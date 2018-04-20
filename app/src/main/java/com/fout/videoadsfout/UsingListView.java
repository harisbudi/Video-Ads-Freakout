package com.fout.videoadsfout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.fout.videoadsfout.Adapter.ListViewAdapter;
import com.fout.videoadsfout.Model.News;
import com.fout.videoadsfout.UI.FoutVideoHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import jp.fout.rfp.android.sdk.RFP;
import jp.fout.rfp.android.sdk.instream.InstreamAdViewBinderImpl;
import jp.fout.rfp.android.sdk.instream.RFPInstreamAdPlacer;
import jp.fout.rfp.android.sdk.instream.RFPInstreamAdPlacerListener;
import jp.fout.rfp.android.sdk.model.RFPInstreamInfoModel;

public class UsingListView extends AppCompatActivity {
    private Unbinder unbinder;
    private RFPInstreamAdPlacer adPlacer;
    private ListViewAdapter listViewAdapter;
    @BindView(R.id.listview)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_list_view);
        unbinder = ButterKnife.bind(this);
        initializeData();
        listViewAdapter = new ListViewAdapter(this,Newslist);
        listView.setAdapter(listViewAdapter);
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

        RFP.init(this, "1143");

        // (4) Generation of RFPInstreamAdPlacer
        adPlacer = RFP.createInstreamAdPlacer(this, "NTI1OjI3MTY");

        // (5)  Allocate advertising case information to any View (see parameter items used for customized infeed advertising, as described below)
        InstreamAdViewBinderImpl adViewBinder = new InstreamAdViewBinderImpl(getApplicationContext()) {
            @Override
            public View createView(ViewGroup parent, int layoutId) {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item_list_freakout, parent, false);
                FoutVideoHolder holder = new FoutVideoHolder(view);
                view.setTag(holder);
                return view;
            }

            @Override
            public void bindAdData(View v, RFPInstreamInfoModel adData) {
                FoutVideoHolder holder = (FoutVideoHolder) v.getTag();
                holder.setData(adData);

//                loadAdImage(adData, holder.view, null);
//                loadAdIconImage(adData, holder.iconImage, null);
            }
        };
        adPlacer.registerAdViewBinder(adViewBinder);
    }

}
