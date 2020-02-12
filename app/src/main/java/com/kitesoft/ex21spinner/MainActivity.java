package com.kitesoft.ex21spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner= findViewById(R.id.spinner);

        //res>>values폴더안에 있는 arrays.xml문서의 'datas' String배열을 읽어와서 View객체로 만들어주는 Adapter객체 생성
        // * 3번째 파라미터 [R.layout.spinner_selected] : 스피너를 클릭하기전 선택된 항목값을 보여주는 TextView의 모양 지정
        adapter= ArrayAdapter.createFromResource(this, R.array.datas, R.layout.spinner_selected);

        //스피너를 클릭해서 드롭다운된 아이템들의 View모양 설정
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

        //Adapter를 스피너에게 설정
        spinner.setAdapter(adapter);

        //스피너의 아이템이 선택되는 것을 듣는 리스너
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            //선택했을 때 발동하는 콜백함수
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                //선택된 항목의 위치(인덱스번호 : 0, 1, 2 ~~ ) 토스트로 확인
                Toast.makeText(MainActivity.this, position+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
