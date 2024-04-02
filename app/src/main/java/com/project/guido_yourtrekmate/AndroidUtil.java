package com.project.guido_yourtrekmate;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.security.AccessControlContext;

public class AndroidUtil {
    public static void setProfilePic(Context contextP, Uri imageUri, ImageView imageViewProf){
        Glide.with(contextP).load(imageUri).apply(RequestOptions.circleCropTransform()).into(imageViewProf);
    }
}
