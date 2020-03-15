package com.example.huehashop.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.huehashop.R;
import com.example.huehashop.model.Sanpham;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class VayAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListvay;

    public VayAdapter(Context context, ArrayList<Sanpham> arrayListvay) {
        this.context = context;
        this.arrayListvay = arrayListvay;
    }

    @Override
    public int getCount() {
        return arrayListvay.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListvay.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        public TextView txttenvay, txtgiavay, txtmotavay;
        public ImageView imgvay;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VayAdapter.ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new VayAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_vay,null);
            viewHolder.txttenvay = (TextView) view.findViewById(R.id.textviewvay);
            viewHolder.txtgiavay = (TextView) view.findViewById(R.id.textviewgiavay);
            viewHolder.txtmotavay = (TextView) view.findViewById(R.id.textviewmotavay);
            viewHolder.imgvay = (ImageView) view.findViewById(R.id.imageviewvay);
            view.setTag(viewHolder);
        }else{
            viewHolder = (VayAdapter.ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttenvay.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiavay.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + "Đ");
        viewHolder.txtmotavay.setText(sanpham.getMotasanpham());
        viewHolder.txtmotavay.setMaxLines(2);
        viewHolder.txtmotavay.setEllipsize(TextUtils.TruncateAt.END);
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgvay);
        return view;
    }
}

