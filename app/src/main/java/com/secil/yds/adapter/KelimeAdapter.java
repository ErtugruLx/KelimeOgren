package com.secil.yds.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.secil.yds.R;
import com.secil.yds.model.Kelime;

import java.util.List;

/**
 * Created by root on 5/18/17.
 */

public class KelimeAdapter extends BaseAdapter {

    private Context context;
    private List<Kelime> kelimeItems;

    public KelimeAdapter(Context context, List<Kelime> kelimeItems) {
        //Yapılandırıcı oluşturuldu.
        //Context ve kelime listesi adapter içerisine tanımlandı.
        this.context = context;
        this.kelimeItems = kelimeItems;
    }


    @Override
    public int getCount() {
        //kelime listesinin boyutunu geri döndürür.
        return kelimeItems.size();
    }

    @Override
    public Object getItem(int position) {
        //Girilen pozisyona ait kelime listesini geri döndürür.
        return kelimeItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        //Kelimeye ait pozisyonu döndürür.
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final LayoutInflater inflater = ( LayoutInflater ) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Özel listview tasarımı tanımlandı.
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_kelimeler, null);

        //INGKelime değişkeni oluşturuldu ve tanımlandı.
        TextView INGKelime = (TextView) convertView.findViewById(R.id.ENGKelime);

        //INGKelime değişkenine adapter üzerinden gelen kelime listesinden ingkelime yazıldı.
        INGKelime.setText(kelimeItems.get(position).getINGKelime());

        return convertView;
    }
}
