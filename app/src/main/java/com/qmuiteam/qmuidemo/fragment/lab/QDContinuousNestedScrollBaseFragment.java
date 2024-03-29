/*
 * Tencent is pleased to support the open source community by making QMUI_Android available.
 *
 * Copyright (C) 2017-2018 THL A29 Limited, a Tencent company. All rights reserved.
 *
 * Licensed under the MIT License (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 *
 * http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.qmuiteam.qmuidemo.fragment.lab;

import android.view.LayoutInflater;
import android.view.View;

import com.qmuiteam.qmui.nestedScroll.QMUIContinuousNestedScrollLayout;
import com.qmuiteam.qmuidemo.R;
import com.qmuiteam.qmuidemo.base.BaseFragment;
import com.qmuiteam.qmuidemo.manager.QDDataManager;
import com.qmuiteam.qmui.util.QMUIDisplayHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.widget.QMUITopBarLayout;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;


import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class QDContinuousNestedScrollBaseFragment extends BaseFragment {
    @BindView(R.id.topbar)
    QMUITopBarLayout mTopBarLayout;
    @BindView(R.id.coordinator)
    QMUIContinuousNestedScrollLayout mCoordinatorLayout;


    @Override
    protected View onCreateView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_continuous_nested_scroll, null);
        ButterKnife.bind(this, view);
        initTopBar();
        initCoordinatorLayout();
        return view;
    }

    private void initTopBar() {
        mTopBarLayout.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popBackStack();
            }
        });

        mTopBarLayout.setTitle(QDDataManager.getInstance().getName(this.getClass()));
        mTopBarLayout.addRightTextButton("scroll", QMUIViewHelper.generateViewId())
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showBottomSheet();
                    }
                });
    }

    protected abstract void initCoordinatorLayout();

    private void showBottomSheet() {
        new QMUIBottomSheet.BottomListSheetBuilder(getContext())
                .addItem("scrollToBottom")
                .addItem("scrollToTop")
                .addItem("scrollBottomViewToTop")
                .addItem("scrollBy 40dp")
                .addItem("scrollBy -40dp")
                .addItem("smoothScrollBy 100dp/1s")
                .addItem("smoothScrollBy -100dp/1s")
                .setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                    @Override
                    public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                        switch (position) {
                            case 0:
                                mCoordinatorLayout.scrollToBottom();
                                break;
                            case 1:
                                mCoordinatorLayout.scrollToTop();
                                break;
                            case 2:
                                mCoordinatorLayout.scrollBottomViewToTop();
                                break;
                            case 3:
                                mCoordinatorLayout.scrollBy(QMUIDisplayHelper.dp2px(getContext(), 40));
                                break;
                            case 4:
                                mCoordinatorLayout.scrollBy(QMUIDisplayHelper.dp2px(getContext(), -40));
                                break;
                            case 5:
                                mCoordinatorLayout.smoothScrollBy(QMUIDisplayHelper.dp2px(getContext(), 100), 1000);
                                break;
                            case 6:
                                mCoordinatorLayout.smoothScrollBy(QMUIDisplayHelper.dp2px(getContext(), -100), 1000);
                                break;
                        }
                        dialog.dismiss();
                    }
                })
                .build().show();
    }
}
