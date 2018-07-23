package demo.qf.com.rxjava2demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yin zi yi on 2018/7/15.
 */

public abstract class RxOperatorBaseActivity extends Activity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.textView)
    TextView textView;
    public static final String TAG = "Log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewLayoutID() != 0) {
            setContentView(getContentViewLayoutID());
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(getContentViewLayoutID());
        ButterKnife.bind(this);

    }

    /**
     * 获取布局ID
     *
     * @return 布局id
     */
    protected abstract int getContentViewLayoutID();

    protected abstract void doSomething();

    @OnClick(R.id.button)
    public void onViewClicked() {
        textView.append("\n");
        doSomething();
    }

}
