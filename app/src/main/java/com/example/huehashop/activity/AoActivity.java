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
import com.example.huehashop.adapter.AoAdapter;
import com.example.huehashop.model.Sanpham;
import com.example.huehashop.ultil.CheckConnection;
import com.example.huehashop.ultil.Server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AoActivity extends AppCompatActivity {

    Toolbar toolbar;
    ListView lva;
    AoAdapter aoAdapter;
    ArrayList<Sanpham> manga;
    int ida = 0;
    int page = 1;
    View footerview;
    boolean isLoading = false;
    boolean limitdata = false;
    AoActivity.mHandler mHandler;

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
        setContentView(R.layout.activity_ao);
        Anhxa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            GetIDloaisp();
            ActionToolBar();
            GetData(page);
            LoadMoreData();
        }else{
            CheckConnection.ShowToast_Short(getApplicationContext(),"Bạn hãy kiểm tra lại internet");
            finish();
        }

    }

    private void LoadMoreData() {
        lva.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ChiTietSanPhamActivity.class);
                intent.putExtra("thongtinsanpham", manga.get(i));
                startActivity(intent);
            }
        });
        lva.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int FirstItem, int VisibleItem, int TotaItem) {
                if(FirstItem + VisibleItem == TotaItem && TotaItem != 0 && isLoading == false && limitdata ==false){
                    isLoading = true;
                    AoActivity.ThreaData threaData = new AoActivity.ThreaData();
                    threaData.start();
                }
            }
        });
    }

    private void GetData(int Page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = Server.Duongdanao + String.valueOf(Page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id =  0;
                String Tena = "";
                int Giaa = 0;
                String Hinhanha = "";
                String Mota = "";
                int Idspa = 0;
                if(response != null && response.length() != 2){
                    lva.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for(int i = 0; i<jsonArray.length(); i++){
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tena = jsonObject.getString("tensp");
                            Giaa = jsonObject.getInt("giasp");
                            Hinhanha = jsonObject.getString("hinhanhsp");
                            Mota = jsonObject.getString("motasp");
                            Idspa = jsonObject.getInt("idsanpham");
                            manga.add(new Sanpham(id,Tena,Giaa,Hinhanha,Mota,Idspa));
                            aoAdapter.notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }else{
                    limitdata = true;
                    lva.removeFooterView(footerview);
                    CheckConnection.ShowToast_Short(getApplicationContext(),"Đã hết dữ liệu");

                }

            }
        },new Response.ErrorListener(){
            public  void onErrorResponse(VolleyError error){

            }

        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String,String>();
                param.put("idsanpham",String.valueOf(ida));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void ActionToolBar() {
        toolbar = findViewById(R.id.toolbarao);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Áo");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void GetIDloaisp() {
        ida = getIntent().getIntExtra("idloaisanpham",-1);
        Log.d("giatriloaisanpham",ida + "");
    }

    private void Anhxa() {
        lva = findViewById(R.id.listviewao);
        manga = new ArrayList<>();
        aoAdapter = new AoAdapter(getApplicationContext(), manga);
        lva.setAdapter(aoAdapter);
        LayoutInflater inflater =(LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progressbar,null);
        mHandler = new AoActivity.mHandler();
    }
    public class mHandler extends Handler {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    lva.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }
    }
    public class ThreaData extends Thread{
        public void run(){
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

