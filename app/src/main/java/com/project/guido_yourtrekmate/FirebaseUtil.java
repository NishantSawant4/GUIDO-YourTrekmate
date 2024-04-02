package com.project.guido_yourtrekmate;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class FirebaseUtil {
    public static String currentUserId(){
        return FirebaseAuth.getInstance().getUid();
    }

    public static DocumentReference currentUserDetails(){
        return FirebaseFirestore.getInstance().collection("Users").document(currentUserId());
    }

    public static StorageReference getCurrentProfilPicStorageRef(){
        return FirebaseStorage.getInstance().getReference().child("Profile_Pic")
                .child(FirebaseUtil.currentUserId());
    }
}
