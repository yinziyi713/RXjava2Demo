package demo.qf.com.rxjava2demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ui.StandardRxJavaActivity;

public class MainActivity extends Activity implements View.OnClickListener {


//    @BindView(R.id.btn_standard)
    Button btnStandard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStandard = (Button) findViewById(R.id.btn_standard);

        btnStandard.setOnClickListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
//        ButterKnife.bind(this);

    }

//    @OnClick(R.id.btn_standard)
//    public void click() {
//        Log.e(TAG, "ONCLICK");
//        intentToActivity(StandardRxJavaActivity.class);
//    }

    private void intentToActivity(Class targetActivity) {
        Intent intent = new Intent(MainActivity.this, targetActivity);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_standard:
                intentToActivity(StandardRxJavaActivity.class);
                break;
        }
    }
}
