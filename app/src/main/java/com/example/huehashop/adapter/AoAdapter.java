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

public class AoAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListao;

    public AoAdapter(Context context, ArrayList<Sanpham> arrayListao) {
        this.context = context;
        this.arrayListao = arrayListao;
    }

    @Override
    public int getCount() {
        return arrayListao.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder {
        public TextView txttenao, txtgiaao, txtmotaao;
        public ImageView imgao;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        AoAdapter.ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new AoAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_ao,null);
            viewHolder.txttenao = (TextView) view.findViewById(R.id.textviewao);
            viewHolder.txtgiaao = (TextView) view.findViewById(R.id.textviewgiaao);
            viewHolder.txtmotaao = (TextView) view.findViewById(R.id.textviewmotaao);
            viewHolder.imgao = (ImageView) view.findViewById(R.id.imageviewao);
            view.setTag(viewHolder);
        }else{
            viewHolder = (AoAdapter.ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttenao.setText(sanpham.getTensanpham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiaao.setText("Giá: " + decimalFormat.format(sanpham.getGiasanpham()) + "Đ");
        viewHolder.txtmotaao.setText(sanpham.getMotasanpham());
        viewHolder.txtmotaao.setMaxLines(2);
        viewHolder.txtmotaao.setEllipsize(TextUtils.TruncateAt.END);
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
                .placeholder(R.drawable.noimage)
                .error(R.drawable.error)
                .into(viewHolder.imgao);
        return view;
    }
}
