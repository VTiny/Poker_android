package com.pk.poker._8_media;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.pk.poker.R;
import com.pk.poker.base.BaseFragment;
import com.pk.poker.util.PKToast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Poker on 2017/2/20.
 */

public class TakePhotoFragment extends BaseFragment implements View.OnClickListener {

    private static final int TAKE_PHOTO =1;

    private Uri imgUri;
    private ImageView photo;

    @Override
    public View onCreateViewPK(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_media_take_photo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_take_photo).setOnClickListener(this);
        photo = (ImageView) view.findViewById(R.id.img_photo);
        photo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btn_take_photo:
                File outImg = new File(getActivity().getExternalCacheDir(), "out_img.jpg");
                try {
                    if (outImg.exists()) {
                        outImg.delete();
                    }
                    outImg.createNewFile();
                } catch (IOException ioe) {
                    PKToast.makeTip(v.getContext(), "file error");
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    imgUri = FileProvider.getUriForFile(v.getContext(), "com.pk.poker.fileprovider", outImg);
                } else {
                    imgUri = Uri.fromFile(outImg);
                }
                intent = new Intent("android.media.action.IMAGE_CAPTURE");
                intent.putExtra(MediaStore.EXTRA_OUTPUT, imgUri);
                startActivityForResult(intent, TAKE_PHOTO);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == Activity.RESULT_OK) {
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getActivity().getContentResolver().openInputStream(imgUri));
                        photo.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
