package com.pk.poker._8_media;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
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

public class PhotoFragment extends BaseFragment implements View.OnClickListener {

    private static final int TAKE_PHOTO = 1;
    private static final int CHOOSE_PHOTO = 2;

    private Uri imgUri;
    private ImageView photo;

    @Override
    public View onCreateViewPK(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pk_media_photo, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_take_photo).setOnClickListener(this);
        view.findViewById(R.id.btn_choose_photo).setOnClickListener(this);

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
                break;
            case R.id.btn_choose_photo:
//                if (ContextCompat.checkSelfPermission(v.getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
//                } else {
//                    intent = new Intent("android.intent.action.GET_CONTENT");
//                    intent.setType("image/*");
                    intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, CHOOSE_PHOTO);
//                    break;
//                }
                break;

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
            case CHOOSE_PHOTO:
                if (resultCode == Activity.RESULT_OK) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        handleImgOnKitKat(data);
                    }


                    Uri selectedImg = data.getData();
                    String[] filePathColumn = {MediaStore.Images.Media.DATA};
                    Cursor cursor = getActivity().getContentResolver().query(selectedImg, filePathColumn, null, null, null);
                    cursor.moveToFirst();
                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String imgPath = cursor.getString(columnIndex);
                    cursor.close();

                    photo.setImageBitmap(BitmapFactory.decodeFile(imgPath));
                }
        }
    }

    @TargetApi(19)
    private void handleImgOnKitKat(Intent intent) {
        String imgPath = null;
        Uri uri = intent.getData();
        if (DocumentsContract.isDocumentUri(getContext(), uri)) {
            String docId = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imgPath = getImgPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://woenloads/public_downloads"), Long.valueOf(docId));
                imgPath = getImgPath(contentUri, null);
            }
        } else if ("content".equalsIgnoreCase(uri.getScheme())) {
            imgPath = getImgPath(uri, null);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            imgPath = uri.getPath();
        }
        displayImg(imgPath);
    }

    private String getImgPath(Uri uri, String selection) {
        String path = null;
        Cursor cursor = getActivity().getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImg(String imgPath) {
        if (imgPath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgPath);
            photo.setImageBitmap(bitmap);
        }else {
            PKToast.makeTip(getContext(), "failed to get image");
        }
    }

}