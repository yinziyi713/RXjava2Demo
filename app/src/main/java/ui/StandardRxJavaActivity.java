package ui;


import android.util.Log;

import demo.qf.com.rxjava2demo.R;
import demo.qf.com.rxjava2demo.RxOperatorBaseActivity;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by Yin zi yi on 2018/7/15.
 */

public class StandardRxJavaActivity extends RxOperatorBaseActivity {

    @Override
    protected int getContentViewLayoutID() {
        return R.layout.activity_standard_layout;
    }

    @Override
    protected void doSomething() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
//                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
//                Log.e(TAG, "Observable emit 3" + "\n");
//                e.onNext(3);
//                e.onComplete();
//                Log.e(TAG, "Observable emit 4" + "\n");
//                e.onNext(4);
            }
        }).subscribe(new Observer<Integer>() {
            private int i;
            private Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
            }

            @Override
            public void onNext(@NonNull Integer integer) {
                i++;
                Log.e(TAG, "onNext" + i+"\n");
//                if (i == 3) {
//                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
//                    mDisposable.dispose();
//                }

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e(TAG, "onError : value : " + e.getMessage() + "\n");
            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete" + "\n");
            }
        });
    }


}
