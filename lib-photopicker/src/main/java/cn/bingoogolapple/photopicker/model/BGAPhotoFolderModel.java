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
package cn.bingoogolapple.photopicker.model;

import java.util.ArrayList;

/**
 * @author pujiang
 * @date 2018-5-27 11:35
 * @mail 515210530@qq.com
 * @Description:
 */
public class BGAPhotoFolderModel {
    public String name;
    public String coverPath;
    private ArrayList<String> mPhotos = new ArrayList<>();
    private boolean mTakePhotoEnabled;

    public BGAPhotoFolderModel(boolean takePhotoEnabled) {
        mTakePhotoEnabled = takePhotoEnabled;
        if (takePhotoEnabled) {
            // 拍照
            mPhotos.add("");
        }
    }

    public BGAPhotoFolderModel(String name, String coverPath) {
        this.name = name;
        this.coverPath = coverPath;
    }

    public boolean isTakePhotoEnabled() {
        return mTakePhotoEnabled;
    }

    public void addLastPhoto(String photoPath) {
        mPhotos.add(photoPath);
    }

    public ArrayList<String> getPhotos() {
        return mPhotos;
    }

    public int getCount() {
        return mTakePhotoEnabled ? mPhotos.size() - 1 : mPhotos.size();
    }
}