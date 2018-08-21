package com.android.ts.emis.activity.work;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.kotlinapp.action.config.StrRes;
import com.android.ts.emis.R;
import com.android.ts.emis.base.BaseActivity;
import com.android.ts.emis.config.RequestCode;
import com.android.ts.emis.handle.EditTextListener;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;

/**
 * 工作-内容输入
 *
 * @author pujiang
 * @date 2018-5-19 21:36
 * @mail 515210530@qq.com
 * @Description:
 */
public class WorkContentInputActivity extends BaseActivity {
    @BindView(R.id.edt_content)
    EditText edtContent;
    @BindView(R.id.tv_contentTip)
    TextView tvContentTip;
    @BindView(R.id.snpl_moment_add_photos)
    BGASortableNinePhotoLayout mPhotosSnpl;//拖拽排序九宫格控件

    private String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_work_content_input);
        ButterKnife.bind(this);

        initData();
        initPhotoPicker();
    }

    private void initData() {
        EditTextListener.setEditTextUpdateTipListener(edtContent, tvContentTip, 1000);
        setTitleBarLayout(R.drawable.icon_back_white_bar, getResources().getString(R.string.text_work_content_input_title), null, getResources().getString(R.string.text_button_bc), true);
        mTitleBar.getRightCtv().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(StrRes.INSTANCE.getSource(), edtContent.getText().toString());
                setResult(RESULT_OK, intent);
                onBackPressed();
            }
        });
    }

    @Override
    public void permissionSuccess(int requestCode) {
        if (RequestCode.INSTANCE.getResult_TakePhotoChoice() == requestCode) {
            choicePhotoWrapper();
        }
    }

    @Override
    public void permissionFail(int requestCode) {
        if (RequestCode.INSTANCE.getResult_TakePhotoChoice() == requestCode) {
            showToast(getResources().getString(R.string.text_permission_fail_xj));
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RequestCode.INSTANCE.getResult_PhotoChoice() && resultCode == RESULT_OK && data != null) {
            mPhotosSnpl.addMoreData(BGAPhotoPickerActivity.getSelectedPhotos(data));
        } else if (requestCode == RequestCode.INSTANCE.getResult_PhotoPreview() && resultCode == RESULT_OK && data != null) {
            mPhotosSnpl.setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
        }
    }

    private void initPhotoPicker() {
        //mPhotosSnpl.setData(null);//是否可编辑
        //mPhotosSnpl.setMaxItemCount(1);//是否可编辑
        mPhotosSnpl.setMaxItemCount(4);//是否可编辑
        mPhotosSnpl.setEditable(true);//是否可编辑
//        mPhotosSnpl.setPlusEnable(true);//
//        mPhotosSnpl.setSortable(true);//
        // 设置拖拽排序控件的代理
        mPhotosSnpl.setDelegate(new BGASortableNinePhotoLayout.Delegate() {
            @Override
            public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissionInfo(RequestCode.INSTANCE.getResult_TakePhotoChoice(), perms);
                    return;
                }
                choicePhotoWrapper();
            }

            @Override
            public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                mPhotosSnpl.removeItem(position);
            }

            @Override
            public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(mContext)
                        .previewPhotos(models) // 当前预览的图片路径集合
                        .selectedPhotos(models) // 当前已选中的图片路径集合
                        .maxChooseCount(mPhotosSnpl.getMaxItemCount()) // 图片选择张数的最大值
                        .currentPosition(position) // 当前预览图片的索引
                        .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                        .build();
                startActivityForResult(photoPickerPreviewIntent, RequestCode.INSTANCE.getResult_PhotoPreview());
            }

            @Override
            public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
                //排序发生变化
            }
        });
    }

    private void choicePhotoWrapper() {
        if (checkPermissions(perms)) {
            // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
            File takePhotoDir = new File(com.libcommon.action.config.AppConfig.FILE_PHOTO_PATH);

            Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(this)
                    .cameraFileDir(takePhotoDir) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                    .maxChooseCount(mPhotosSnpl.getMaxItemCount() - mPhotosSnpl.getItemCount()) // 图片选择张数的最大值
                    .selectedPhotos(null) // 当前已选中的图片路径集合
                    .pauseOnScroll(false) // 滚动列表时是否暂停加载图片
                    .build();
            startActivityForResult(photoPickerIntent, RequestCode.INSTANCE.getResult_PhotoChoice());
        } else {//重新提示开启权限
            requestPermissionInfo(RequestCode.INSTANCE.getResult_TakePhotoChoice(), perms);
        }
    }
}
