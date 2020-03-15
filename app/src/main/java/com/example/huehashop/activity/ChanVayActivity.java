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
import com.example.huehashop.adapter.ChanvayAdapter;
import com.example.huehashop.model.Sanpham;
import com.example.huehashop.ultil.CheckConnection;
import com.example.huehashop.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChanVayActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lvcv;
    ChanvayAdapter chanvayAdapter;
    ArrayList<Sanpham> mangcv;
    int idcv = 0;
    int page = 1;
    View footerview;
    boolean isLoading = false;
    boolean limitdata = false;
    ChanVayActivity.mHandler mHandler;

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
        setContentView(R.layout.activity_chan_vay);
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
        lvcv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", mangcv.get(i));
                startActivity(intent);
            }
        });
        lvcv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int FirstItem, int VisibleItem, int TotaItem) {
                if (FirstItem + VisibleItem == TotaItem && TotaItem != 0 && isLoading == false && limitdata == false) {
                    isLoading = true;
                    ChanVayActivity.ThreaData threaData = new ChanVayActivity.ThreaData();
                    threaData.start();
                }
            }
        });
    }

    private void ActionToolBar() {
        toolbar = findViewById(R.id.toolbarchanvay);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Chân Váy");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanchanvay + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tencv = "";
                int Giacv = 0;
                String Hinhanhcv = "";
                String Mota = "";
                int Idspcv = 0;
                if (response != null && response.length() != 2) {
                    lvcv.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Log.d("Test", "onResponse: "+ jsonObject.toString());
                            id = jsonObject.getInt("id");
                            Tencv = jsonObject.getString("tensp");
                            Giacv = jsonObject.getInt("giasp");
                            Hinhanhcv = jsonObject.getString("hinhanhsp");
                            Mota = jsonObject.getString("motasp");
                            Idspcv = jsonObject.getInt("idsanpham");
                            mangcv.add(new Sanpham(id, Tencv, Giacv, Hinhanhcv, Mota, Idspcv));
                            chanvayAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    limitdata = true;
                    lvcv.removeFooterView(footerview);
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
                param.put("idsanpham", String.valueOf(idcv));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void GetIDloaisp() {
        idcv = getIntent().getIntExtra("idloaisanpham", -1);
        Log.d("giatriloaisanpham", idcv + "");
    }

    private void Anhxa() {
        lvcv = findViewById(R.id.listviewchanvay);
        mangcv = new ArrayList<>();
        chanvayAdapter = new ChanvayAdapter(getApplicationContext(), mangcv);
        lvcv.setAdapter(chanvayAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar, null);
        mHandler = new ChanVayActivity.mHandler();
    }

    public class mHandler extends Handler {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lvcv.addFooterView(footerview);
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
