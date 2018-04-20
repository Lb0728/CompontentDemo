/*******************************************************************************
 * Copyright 2011, 2012 Chris Banes.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.moudlemain;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.basemodule.ARouterManager;
import com.basemodule.BaseActivity;
import com.contrarywind.listener.OnItemSelectedListener;
import com.contrarywind.view.WheelView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private TextView button;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_launcher;
    }

    @Override
    protected void initView() {
        button = (TextView) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. 应用内简单的跳转(通过URL跳转在'进阶用法'中)
                ARouter.getInstance().build("/dev/videoactivity").navigation();
                Log.w("TAG", "-----" + BuildConfig.DEBUG);
            }
        });


        WheelView wheelView = findViewById(R.id.wheelview);
        wheelView.setCyclic(false);
        wheelView.setCurrentItem(2);
        wheelView.setDividerType(WheelView.DividerType.WRAP);
        wheelView.setLineSpacingMultiplier(4f);
        final List<String> mOptionsItems = new ArrayList<>();
        mOptionsItems.add("item0");
        mOptionsItems.add("item123456765432");
        mOptionsItems.add("item2");
        wheelView.setAdapter(new ArrayWheelAdapter(mOptionsItems));
        wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                Toast.makeText(MainActivity.this, "" + mOptionsItems.get(index), Toast.LENGTH_SHORT).show();
            }
        });

    }


}