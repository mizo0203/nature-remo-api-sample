/*
 * Copyright 2020, Satoki Mizoguchi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mizo0203.natureremoapisample;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.mizo0203.natureremoapisample.util.ActivityUtils;

public class MainActivity extends AppCompatActivity {

    // TODO: (optional) Nature API を使用する場合は TOKEN をセット
    private static final String TOKEN = "";

    // TODO: NATURE_REMO_IP_ADDRESS をセット
    private static final String NATURE_REMO_IP_ADDRESS = "192.168.1.23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment =
                (MainFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        if (mainFragment == null) {
            // Create the fragment
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), mainFragment, R.id.fragment);
        }

        // Create the presenter
        new MainPresenter(Injection.provideNatureRemoRepository(TOKEN, NATURE_REMO_IP_ADDRESS), mainFragment);
    }
}
