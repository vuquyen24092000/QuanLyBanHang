package com.example.quanlibanhang.ui.sanpham;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.quanlibanhang.MainActivity;
import com.example.quanlibanhang.R;
import com.example.quanlibanhang.thuonghieu.ThuongHieu;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Constants;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class ThemSanPhamAcitivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    EditText edMaSP, edTenSP, edNSX, edHSD, edGiaNhap, edGiaBan, edMoTa;
    Spinner spinner;
    Button btnPicNSX, btnChoosePic, btnThemSP;
    ImageButton btnCamera;
    ImageView imgSP;
    Bitmap bitmap;
    DatabaseReference mData;
    FirebaseDB firebaseDB;
    int REQUEST_CODE_IMAGE = 100;
    int REQUEST_CODE_IMAGE_STORAGE = 200;
    FirebaseStorage storage = FirebaseStorage.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham_acitivity);
        setTitle("Thêm Sản Phẩm");
        AnhXa();

        mData = FirebaseDatabase.getInstance().getReference();
        final StorageReference storageRef = storage.getReferenceFromUrl("gs://quanlibanhang-1d8ea.appspot.com");
        firebaseDB = new FirebaseDB(mData);

        try {
            Intent intent = getIntent();
            Bundle b = intent.getBundleExtra("bundleSP");
            edMaSP.setText(b.getString("maSP"));
        } catch (Exception e) {
            e.printStackTrace();
        }


        spinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, firebaseDB.retrieve()));

        btnChoosePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePicture();
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturePicture();
            }
        });

        btnThemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final StorageReference mountainsRef = storageRef.child("imageSP" + calendar.getTimeInMillis() + "png");
                imgSP.setDrawingCacheEnabled(true);
                imgSP.buildDrawingCache();
                Bitmap bitmap = ((BitmapDrawable) imgSP.getDrawable()).getBitmap();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] data = baos.toByteArray();

                UploadTask uploadTask = mountainsRef.putBytes(data);
                uploadTask.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception exception) {
                        // Handle unsuccessful uploads
                        Toast.makeText(ThemSanPhamAcitivity.this, "Lỗi!!!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                        if (taskSnapshot.getMetadata() != null) {
                            if (taskSnapshot.getMetadata().getReference() != null) {
                                Task<Uri> downloadUrl = taskSnapshot.getMetadata().getReference().getDownloadUrl();
                                downloadUrl.addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        SanPham sanPham = new SanPham(uri.toString(), edMaSP.getText().toString(), edTenSP.getText().toString(), String.valueOf(spinner.getSelectedItem()), edNSX.getText().toString(), edHSD.getText().toString(), edMoTa.getText().toString(), Double.parseDouble(edGiaNhap.getText().toString()), Double.parseDouble(edGiaBan.getText().toString()));
                                        mData.child("SanPham").push().setValue(sanPham, new DatabaseReference.CompletionListener() {
                                            @Override
                                            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                                                if (databaseError == null) {
                                                    Toast.makeText(ThemSanPhamAcitivity.this, "Lưu dữ liệu thành công", Toast.LENGTH_LONG).show();
                                                } else {
                                                    Toast.makeText(ThemSanPhamAcitivity.this, "Lỗi!!!" + databaseError, Toast.LENGTH_LONG).show();
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
        edMaSP = findViewById(R.id.edMaSP);
        edTenSP = findViewById(R.id.edTenSP);
        edNSX = findViewById(R.id.edNSX);
        edHSD = findViewById(R.id.edHSD);
        edGiaNhap = findViewById(R.id.edGiaNhap);
        edGiaBan = findViewById(R.id.edGiaBan);
        edMoTa = findViewById(R.id.edMoTa);
        spinner = findViewById(R.id.spinner);
        btnPicNSX = findViewById(R.id.btnPicNSX);
        btnCamera = findViewById(R.id.btnCamera);
        btnChoosePic = findViewById(R.id.btnImage);
        btnThemSP = findViewById(R.id.btnThemSP);
        imgSP = findViewById(R.id.imgSP);
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
            imgSP.setImageBitmap(bitmap);
        } else if (requestCode == REQUEST_CODE_IMAGE_STORAGE && resultCode == RESULT_OK) {
            try {
                //xử lý lấy ảnh chọn từ điện thoại:
                Uri imageUri = data.getData();
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                imgSP.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = new GregorianCalendar(year, month, dayOfMonth);
        setDate(cal);
    }


    private void setDate(Calendar calendar) {
        edNSX.setText(sdf.format(calendar.getTime()));
    }

    public static class DatePickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), (DatePickerDialog.OnDateSetListener) getActivity(), year, month, day);
        }
    }

    public void datePicker1(View view) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.show(getSupportFragmentManager(), "NSX");
    }

}
