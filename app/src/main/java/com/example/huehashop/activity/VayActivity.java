package com.example.huehashop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.huehashop.R;
import com.example.huehashop.adapter.VayAdapter;
import com.example.huehashop.model.Sanpham;
import com.example.huehashop.ultil.CheckConnection;
import com.example.huehashop.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VayActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvv;
    VayAdapter vayAdapter;
    ArrayList<Sanpham> mangv;
    int idv = 0;
    int page = 1;
    View footerview;
    boolean isLoading = false;
    boolean limitdata = false;
    VayActivity.mHandler mHandler;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menugiohang:
                Intent intent = new Intent(getApplicationContext(), GioHangActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vay);
        Anhxa();
        if (CheckConnection.haveNetworkConnection(getApplicationContext())) {
            GetIDloaisp();
            ActionToolBar();
            GetData(page);
            LoadMoreData();
        } else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại internet");
            finish();
        }

    }

    private void LoadMoreData() {
        lvv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", mangv.get(i));
                startActivity(intent);
            }
        });
        lvv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int FirstItem, int VisibleItem, int TotaItem) {
                if (FirstItem + VisibleItem == TotaItem && TotaItem != 0 && isLoading == false && limitdata == false) {
                    isLoading = true;
                    VayActivity.ThreaData threaData = new VayActivity.ThreaData();
                    threaData.start();
                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanvay + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tenv = "";
                int Giav = 0;
                String Hinhanhv = "";
                String Mota = "";
                int Idspv = 0;
                if (response != null && response.length() != 2) {
                    lvv.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tenv = jsonObject.getString("tensp");
                            Giav = jsonObject.getInt("giasp");
                            Hinhanhv = jsonObject.getString("hinhanhsp");
                            Mota = jsonObject.getString("motasp");
                            Idspv = jsonObject.getInt("idsanpham");
                            mangv.add(new Sanpham(id, Tenv, Giav, Hinhanhv, Mota, Idspv));
                            vayAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    limitdata = true;
                    lvv.removeFooterView(footerview);
                    CheckConnection.ShowToast_Short(getApplicationContext(), "Đã hết dữ liệu");

                }

            }
        }, new Response.ErrorListener() {
            public void onErrorResponse(VolleyError error) {

            }

        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idsanpham", String.valueOf(idv));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolBar() {
        toolbar = findViewById(R.id.toolbarvay);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Váy");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIDloaisp() {
        idv = getIntent().getIntExtra("idloaisanpham", -1);
        Log.d("giatriloaisanpham", idv + "");
    }

    private void Anhxa() {
        lvv = findViewById(R.id.listviewvay);
        mangv = new ArrayList<>();
        vayAdapter = new VayAdapter(getApplicationContext(), mangv);
        lvv.setAdapter(vayAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar, null);
        mHandler = new VayActivity.mHandler();
    }

    public class mHandler extends Handler {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lvv.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }

    public class ThreaData extends Thread {
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}
