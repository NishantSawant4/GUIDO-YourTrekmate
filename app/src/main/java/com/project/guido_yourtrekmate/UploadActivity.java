package com.project.guido_yourtrekmate;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UploadActivity extends AppCompatActivity {
Button btpost;
EditText postmsg;
String msg;
    private FirebaseDatabase databasePost;
    private DatabaseReference postRef;
    private String name,uid,profileimgurl;
    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        btpost = findViewById(R.id.bt_post);
        postmsg = findViewById(R.id.et_upload);

        databasePost = FirebaseDatabase.getInstance();
        postRef = databasePost.getReference("post");

        name = mUser.getDisplayName();
//        profileimgurl = mUser.getPhotoUrl().toString();
         btpost.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                msg = postmsg.getText().toString();
                DatabaseReference newPostRef = postRef.push();
                String postId = newPostRef.getKey();
                DatabaseReference postDataRef = postRef.child(postId);
                postDataRef.child("name").setValue(name);
                postDataRef.child("profile").setValue(profileimgurl);
                postDataRef.child("message").setValue(msg);
                postDataRef.child("postId").setValue(postId);
             }
         });
    }
}