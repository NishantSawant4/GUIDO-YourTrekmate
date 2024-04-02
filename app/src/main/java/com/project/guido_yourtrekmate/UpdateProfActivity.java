package com.project.guido_yourtrekmate;

import static java.security.AccessController.getContext;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.UploadTask;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class UpdateProfActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> imagePickerLauncher;
    Uri selectedImageUri;
    EditText newName, newEmail, newPassword;

    ImageView profilePic;
    Button updateProfile , updateEmail, updatePassword;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    FirebaseUser mUser = mAuth.getCurrentUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_prof);

        profilePic = findViewById(R.id.iv_profilePic);
        newName = findViewById(R.id.et_newName);
        newEmail = findViewById(R.id.et_newEmail);
        newPassword = findViewById(R.id.et_newPassword);
        updateProfile = findViewById(R.id.bt_updated);
        updateEmail = findViewById(R.id.bt_updatedEmail);
        updatePassword = findViewById(R.id.bt_updatedPass);

//        updateProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(selectedImageUri!=null) {
//                    FirebaseUtil.getCurrentProfilPicStorageRef().putFile(selectedImageUri)
//                            .addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//                                @Override
//                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
//                                    updatedProfile();
//                                    updatedEmail();
//                                }
//                            });
//                }
//            }
//
//        });

        updateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedProfile();
            }
        });
        updateEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatedEmail();
            }
        });

        imagePickerLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
        result ->{
            if(result.getResultCode() == Activity.RESULT_OK){
                Intent data = result.getData();
                if(data!=null && data.getData() != null){
                    selectedImageUri = data.getData();
                    AndroidUtil.setProfilePic(getBaseContext(),selectedImageUri,profilePic);
                }
            }
        }        );


        profilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(UpdateProfActivity.this).cropSquare().compress(512).maxResultSize(512,512)
                        .createIntent(new Function1<Intent, Unit>() {
                            @Override
                            public Unit invoke(Intent intent) {
                                imagePickerLauncher.launch(intent);
                                return null;
                            }
                        });
            }
        });
    }

    private void updatedEmail() {
        mUser.updateEmail(newEmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(UpdateProfActivity.this,"Email Updated",Toast.LENGTH_SHORT).show();
                    mAuth.signOut();
                    startActivity(new Intent(UpdateProfActivity.this, LoginActivity.class));
                    finish();
                }else{
                    Toast.makeText(UpdateProfActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void updatedProfile() {
        UserProfileChangeRequest updatedProfile = new UserProfileChangeRequest.Builder()
                .setDisplayName(newName.getText().toString())
                .build();
        mUser.updateProfile(updatedProfile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(UpdateProfActivity.this,"Profile Updated",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateProfActivity.this,ProfileActivity.class));
                    finish();
                }else{
                    Toast.makeText(UpdateProfActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}