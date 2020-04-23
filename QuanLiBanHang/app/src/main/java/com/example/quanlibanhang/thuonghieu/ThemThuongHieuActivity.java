package com.example.quanlibanhang.thuonghieu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlibanhang.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

public class ThemThuongHieuActivity extends AppCompatActivity {
    ImageView imgTH;
    EditText edTenTH, edMaTH;
    Button btnThemTH, btnImage;
    ImageButton btnCamera;
    int REQUEST_CODE_IMAGE = 100;
    int REQUEST_CODE_IMAGE_STORAGE = 200;
    Bitmap bitmap;
    FirebaseStorage storage = FirebaseStorage.getInstance();
    DatabaseReference mData;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_thuong_hieu);
        setTitle("Thêm Thương Hiệu");
        AnhXa();

        mData = FirebaseDatabase.getInstance().getReference();
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://quanlibanhang-1d8ea.appspot.com");

        try {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("bundleTH");
            edMaTH.setText(b.getString("maTH"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                capturePicture();
            }
        });
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosePicture();
            }
        });
        btnThemTH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final StorageReference mountainsRef = storageRef.child("imageTH" + calendar.getTimeInMillis() + ".png");
                imgTH.setDrawingCacheEnabled(true);
                imgTH.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imgTH.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(ThemThuongHieuActivity.this, "Lỗi!!!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        // ...
                        if (taskSnapshot.getMetadata() != null) {
                            if (taskSnapshot.getMetadata().getReference() != null) {
                                Task<Uri> downloadUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                                Toast.makeText(ThemThuongHieuActivity.this, "Thành công", Toast.LENGTH_LONG).show();
                                downloadUrl.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        ThuongHieu thuongHieu = new ThuongHieu(edMaTH.getText().toString(), edTenTH.getText().toString(), uri.toString());
                                        Log.d("AA", uri + "");
                                        //tạo node trong database
                                        mData.child("ThuongHieu").push().setValue(thuongHieu, new DatabaseReference.CompletionListener() {
                                            @Override
                                            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                if (databaseError == null) {
                                                    Toast.makeText(ThemThuongHieuActivity.this, "Lưu dữ liệu thành công", Toast.LENGTH_LONG).show();

                                                } else {
                                                    Toast.makeText(ThemThuongHieuActivity.this, "Lỗi!!!" + databaseError, Toast.LENGTH_LONG).show();
                                                }
                                            }
                                        });
                                    }
                                });

                            }
                        }


                    }
                });
            }
        });


    }

    private void AnhXa() {
        btnCamera = findViewById(R.id.btnCamera);
        btnImage = findViewById(R.id.btnImage);
        imgTH = findViewById(R.id.imgTH);
        edMaTH = findViewById(R.id.edMaTH);
        edTenTH = findViewById(R.id.edTenTH);
        btnThemTH = findViewById(R.id.btnThemTH);
    }


    private void choosePicture() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(pickPhoto, REQUEST_CODE_IMAGE_STORAGE);//one can be replaced with any action code
    }

    //xử lý chụp hình
    private void capturePicture() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, REQUEST_CODE_IMAGE);
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_IMAGE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && resultCode == RESULT_OK && data != null) {
            //xử lí h.ả lúc chụp
            bitmap = (Bitmap) data.getExtras().get("data");
            imgTH.setImageBitmap(bitmap);
        } else if (requestCode == REQUEST_CODE_IMAGE_STORAGE && resultCode == RESULT_OK) {
            try {
                //xử lý lấy ảnh chọn từ điện thoại:
                Uri imageUri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imgTH.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
