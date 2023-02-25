package com.example.appfirebasepolytech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView tvMessage, tvObject, tvCollection;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("messagePolytech");
    DatabaseReference myRefObject = database.getReference("PolytechEtudiant");
    DatabaseReference myRefCollection = database.getReference("PolytechEtudiants");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCollection = findViewById(R.id.textViewCollection);
        tvMessage = findViewById(R.id.textViewMessage);
        tvObject = findViewById(R.id.textViewObject);
        myRef.addValueEventListener(messageVel);
       myRefObject.addValueEventListener(ObjectVel);
       myRefCollection.addValueEventListener(CollectionVel);
    }
    ValueEventListener messageVel= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            String ch= snapshot.getValue(String.class);
            tvMessage.setText(ch);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    ValueEventListener ObjectVel= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Etudiant e2= snapshot.getValue(Etudiant.class);
            tvObject.setText(e2.getNom()+": "+e2.getPrenom());

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };
    ValueEventListener CollectionVel= new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            Etudiant e1;
            String ch="";
            for (DataSnapshot ds:snapshot.getChildren()){
                 e1= ds.getValue(Etudiant.class);
                ch=ch+"\n"+e1.getNom()+": "+e1.getPrenom();
            }

            tvCollection.setText(ch);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    public void MessageClick(View view) {
        // Write a message to the database
        myRef.setValue("Hello, World!");
    }

    public void ObjectClick(View view) {
        Adresse a = new Adresse("5000", "Monastir", "ibn ljazar");
        Etudiant e1 = new Etudiant("benOthmen", "ilhem", new Date(1666, 05, 25), a);
        myRefObject.setValue(e1);
    }

    public void CollectionCllick(View view) {
        Adresse a = new Adresse("5000", "Monastir", "ibn ljazar");
        Etudiant e1 = new Etudiant("benOthmen", "ilhem", new Date(1666, 05, 25), a);
        myRefObject.setValue(e1);
        Etudiant e2 = new Etudiant("kallel", "sahar", new Date(1996, 05, 25), a);
        myRefObject.setValue(e1);
        //myRefCollection.child("1").setValue(e1);
        //myRefCollection.child("2").setValue(e2);
        myRefCollection.push().setValue(e1);
        myRefCollection.push().setValue(e2);
    }

}
