package com.example.huehashop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.huehashop.R;
import com.example.huehashop.adapter.LoaispAdapter;
import com.example.huehashop.adapter.SanphamAdapter;
import com.example.huehashop.model.Giohang;
import com.example.huehashop.model.Loaisp;
import com.example.huehashop.model.Sanpham;
import com.example.huehashop.ultil.CheckConnection;
import com.example.huehashop.ultil.Server;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView rcv_last_product;
    NavigationView navigationView;
    ListView listViewmanhinhchinh;
    DrawerLayout drawerLayout;
    ArrayList<Loaisp> mangloaisp;
    LoaispAdapter loaispAdapter;
    int id = 0;
    String tenloaisp = "";
    String hinhanhloaisp = "";
    ArrayList<Sanpham> mangsanpham;
    SanphamAdapter sanphamAdapter;
    public static ArrayList<Giohang> manggiohang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            ActionBar();
            ActionViewFlipper();
            GetDuLieuLoaisp();
            GetDuLieuSPMoiNhat();
            CatchOnItemListView();
        } else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra kết nối");
            finish();
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
            Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void CatchOnItemListView() {
        listViewmanhinhchinh.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, MainActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case 1:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, QuanActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 2:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, AoActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case 3:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, ChanVayActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case 4:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, VayActivity.class);
                            intent.putExtra("idloaisanpham", mangloaisp.get(i).getId());
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case 5:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, LienHeActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 6:
                        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
                            Intent intent = new Intent(MainActivity.this, ThongTinActivity.class);
                            startActivity(intent);
                        } else {
                            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }

            }
        });
    }


    private void GetDuLieuSPMoiNhat() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.duongdanspmoinhat, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int ID = 0;
                    String Tensanpham = "";
                    Integer Giasanpham = 0;
                    String Hinhanhsanpham = "";
                    String Motasanpham = "";
                    int IDsanpham = 0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            ID = jsonObject.getInt("id");
                            Tensanpham = jsonObject.getString("tensp");
                            Giasanpham = jsonObject.getInt("giasp");
                            Hinhanhsanpham = jsonObject.getString("hinhanhsp");
                            Motasanpham = jsonObject.getString("motasp");
                            IDsanpham = jsonObject.getInt("idsanpham");

                            mangsanpham.add(new Sanpham(ID, Tensanpham, Giasanpham, Hinhanhsanpham, Motasanpham, IDsanpham));
                            sanphamAdapter = new SanphamAdapter(MainActivity.this, mangsanpham);
                            rcv_last_product.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                            rcv_last_product.setAdapter(sanphamAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void GetDuLieuLoaisp() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.DuongdanLoaisp, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            tenloaisp = jsonObject.getString("tenloaisp");
                            hinhanhloaisp = jsonObject.getString("hinhanhloaisp");
                            mangloaisp.add(new Loaisp(id, tenloaisp, hinhanhloaisp));
                            loaispAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    mangloaisp.add(5, new Loaisp(0, "Liên hệ", "https://vesinhsieutoc.com/wp-content/uploads/2018/06/Icon-dien-thoai-min.png"));
                    mangloaisp.add(6, new Loaisp(0, "Thông tin", "https://img2.freepng.es/20180401/ybe/kisspng-computer-icons-consultant-businessperson-sales-sports-personal-5ac0d0822b1a18.7313195615225857301766.jpg"));

                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.ShowToast_Short(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void ActionViewFlipper() {
        ArrayList<String> mangquangcao = new ArrayList<>();
        mangquangcao.add("https://s3-ap-southeast-1.amazonaws.com/chupanhvn/wp-content/uploads/2018/01/22044739/chup-anh-quan-ao-7.jpg");
        mangquangcao.add("https://bizweb.dktcdn.net/thumb/grande/100/041/510/products/f091p9-simg-d0daf0-800x1200-max.jpg?v=1546757032280");
        mangquangcao.add("https://kevindecor.com/upload/images/Phong-nen-chup-anh-quan-ao1.png");
        mangquangcao.add("https://images.guucdn.net/full/2016/07/01/08ff1b21b9466d39baf88fe74b45140bd5280cef.jpg");
        for (int i = 0; i < mangquangcao.size(); i++) {
            ImageView imageView = new ImageView(getApplicationContext());
            Picasso.with(getApplicationContext()).load(mangquangcao.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            viewFlipper.addView(imageView);
        }
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        Animation animation_slide_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_right);
        Animation animation_slide_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        viewFlipper.setAnimation(animation_slide_in);
        viewFlipper.setAnimation(animation_slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private void Anhxa() {
        toolbar = findViewById(R.id.toolbarmanhinhchinh);
        viewFlipper = findViewById(R.id.viewflipper);
        rcv_last_product = findViewById(R.id.rcv_last_product);
        navigationView = findViewById(R.id.navigationView);
        listViewmanhinhchinh = findViewById(R.id.listviewmanhinhchinh);
        drawerLayout = findViewById(R.id.drawerlayout);
        mangloaisp = new ArrayList<>();
        mangloaisp.add(0, new Loaisp(0, "Trang chính", "https://simpleicon.com/wp-content/uploads/home-1.png"));
        loaispAdapter = new LoaispAdapter(mangloaisp, getApplicationContext());
        listViewmanhinhchinh.setAdapter(loaispAdapter);

        mangsanpham = new ArrayList<>();
//        sanphamAdapter = new SanphamAdapter(this, mangsanpham);
        rcv_last_product.setHasFixedSize(true);
        rcv_last_product.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        rcv_last_product.setAdapter(sanphamAdapter);
        if(manggiohang !=null){


        }else{
            manggiohang = new ArrayList<>();
        }


    }
}

