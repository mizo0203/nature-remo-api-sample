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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.mizo0203.natureremoapisample.panasonic.tv.RemoteControlButtonType;

import static com.google.common.base.Preconditions.checkNotNull;

public class MainFragment extends Fragment implements MainContract.View, View.OnClickListener {

    private MainContract.Presenter mPresenter;

    public MainFragment() {
        // Requires empty public constructor
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(@NonNull MainContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        root.findViewById(R.id.button_1).setOnClickListener(this);
        root.findViewById(R.id.button_2).setOnClickListener(this);
        root.findViewById(R.id.button_3).setOnClickListener(this);
        root.findViewById(R.id.button_4).setOnClickListener(this);
        root.findViewById(R.id.button_5).setOnClickListener(this);
        root.findViewById(R.id.button_6).setOnClickListener(this);
        root.findViewById(R.id.button_7).setOnClickListener(this);
        root.findViewById(R.id.button_8).setOnClickListener(this);
        root.findViewById(R.id.button_9).setOnClickListener(this);
        root.findViewById(R.id.button_10).setOnClickListener(this);
        root.findViewById(R.id.button_11).setOnClickListener(this);
        root.findViewById(R.id.button_12).setOnClickListener(this);

        root.findViewById(R.id.button_ch_up).setOnClickListener(this);
        root.findViewById(R.id.button_ch_down).setOnClickListener(this);

        root.findViewById(R.id.button_vol_up).setOnClickListener(this);
        root.findViewById(R.id.button_vol_down).setOnClickListener(this);

        return root;
    }

    @Override
    public void showSuccess() {
        showMessage(getString(R.string.success));
    }

    @Override
    public void showFailure() {
        showMessage(getString(R.string.failure));
    }

    private void showMessage(String message) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_1);
                break;
            case R.id.button_2:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_2);
                break;
            case R.id.button_3:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_3);
                break;
            case R.id.button_4:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_4);
                break;
            case R.id.button_5:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_5);
                break;
            case R.id.button_6:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_6);
                break;
            case R.id.button_7:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_7);
                break;
            case R.id.button_8:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_8);
                break;
            case R.id.button_9:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_9);
                break;
            case R.id.button_10:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_10);
                break;
            case R.id.button_11:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_11);
                break;
            case R.id.button_12:
                mPresenter.sendButtonEvent(RemoteControlButtonType.NUM_12);
                break;
            case R.id.button_ch_up:
                mPresenter.sendButtonEvent(RemoteControlButtonType.CH_UP);
                break;
            case R.id.button_ch_down:
                mPresenter.sendButtonEvent(RemoteControlButtonType.CH_DOWN);
                break;
            case R.id.button_vol_up:
                mPresenter.sendButtonEvent(RemoteControlButtonType.VOL_UP);
                break;
            case R.id.button_vol_down:
                mPresenter.sendButtonEvent(RemoteControlButtonType.VOL_DOWN);
                break;
        }
    }
}
