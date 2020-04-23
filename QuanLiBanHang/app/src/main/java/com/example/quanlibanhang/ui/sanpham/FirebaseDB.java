package com.example.quanlibanhang.ui.sanpham;

import com.example.quanlibanhang.thuonghieu.ThuongHieu;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class FirebaseDB {


        DatabaseReference db;

        public FirebaseDB(DatabaseReference db) {
            this.db = db;
        }

        //READ
        public ArrayList<String> retrieve()
        {
            final ArrayList<String> thuongHieu=new ArrayList<>();

            db.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot,thuongHieu);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot,thuongHieu);

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            return thuongHieu;
        }

        private void fetchData(DataSnapshot snapshot, ArrayList<String> thuongHieu)
        {
            thuongHieu.clear();
            for (DataSnapshot ds:snapshot.getChildren())
            {
                String name=ds.getValue(ThuongHieu.class).getTenTH();
                thuongHieu.add(name);
            }

        }
    }

