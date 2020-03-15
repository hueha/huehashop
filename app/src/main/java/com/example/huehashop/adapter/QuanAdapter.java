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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class QuanAdapter extends BaseAdapter {
    Context context;
    ArrayList<Sanpham> arrayListquan;

    public QuanAdapter(Context context, ArrayList<Sanpham> arrayListquan) {
        this.context = context;
        this.arrayListquan = arrayListquan;
    }

    @Override
    public int getCount() {
        return arrayListquan.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListquan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        public TextView txttenquan, txtgiaquan, txtmotaquan;
        public ImageView imgquan;
    }



    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_quan,null);
            viewHolder.txttenquan = (TextView) view.findViewById(R.id.textviewquan);
            viewHolder.txtgiaquan = (TextView) view.findViewById(R.id.textviewgiaquan);
            viewHolder.txtmotaquan = (TextView) view.findViewById(R.id.textviewmotaquan);
            viewHolder.imgquan = (ImageView) view.findViewById(R.id.imageviewquan);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttenquan.setText(sanpham.getTensanpham());

        viewHolder.txtgiaquan.setText("Giá: " + NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(sanpham.getGiasanpham()));
        viewHolder.txtmotaquan.setText(sanpham.getMotasanpham());
        viewHolder.txtmotaquan.setMaxLines(2);
        viewHolder.txtmotaquan.setEllipsize(TextUtils.TruncateAt.END);
        Picasso.with(context).load(sanpham.getHinhanhsanpham())
               .placeholder(R.drawable.noimage)
               .error(R.drawable.error)
               .into(viewHolder.imgquan);
        return view;
    }
}
