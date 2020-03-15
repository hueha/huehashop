package com.example.huehashop.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huehashop.R;
import com.example.huehashop.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ChanvayAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListchanvay;

    public ChanvayAdapter(Context context, ArrayList<Sanpham> arrayListchanvay) {
        this.context = context;
        this.arrayListchanvay = arrayListchanvay;
    }

    @Override
    public int getCount() {
        return arrayListchanvay.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListchanvay.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.dong_chanvay, viewGroup, false);

        TextView txttenchanvay, txtgiachanvay, txtmotachanvay;
        ImageView imgchanvay;

        txttenchanvay = view.findViewById(R.id.textviewchanvay);
        txtgiachanvay = view.findViewById(R.id.textviewgiachanvay);
        txtmotachanvay = view.findViewById(R.id.textviewmotachanvay);
        imgchanvay = view.findViewById(R.id.imageviewchanvay);

        Sanpham sanpham = arrayListchanvay.get(i);

        txttenchanvay.setText(sanpham.getTensanpham());
        txtmotachanvay.setText(sanpham.getMotasanpham());
        Picasso.with(context).load(sanpham.getHinhanhsanpham()).into(imgchanvay);
        String str = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(sanpham.getGiasanpham()); // hiển thị giá dạng vnđ
        txtgiachanvay.setText(str);
        return view;
    }
}
