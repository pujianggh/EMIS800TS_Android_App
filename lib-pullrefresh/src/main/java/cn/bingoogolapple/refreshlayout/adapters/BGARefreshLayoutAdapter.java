/**
 * Copyright 2016 bingoogolapple
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.bingoogolapple.refreshlayout.adapters;

import android.databinding.BindingAdapter;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * @author pujiang
 * @date 2018-5-31 09:28
 * @mail 515210530@qq.com
 * @Description:
 */
public class BGARefreshLayoutAdapter {

    @BindingAdapter({"bga_refresh_delegate"})
    public static void setDelegate(BGARefreshLayout refreshLayout, BGARefreshLayout.BGARefreshLayoutDelegate delegate) {
        refreshLayout.setDelegate(delegate);
    }

}