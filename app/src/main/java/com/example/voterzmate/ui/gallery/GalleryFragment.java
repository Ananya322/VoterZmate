package com.example.voterzmate.ui.gallery;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.voterzmate.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class GalleryFragment extends Fragment {
    String myChildText;
    Firebase myFirebase;
    ImageView button;
    TextView txt;
    ImageView img1;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        txt = view.findViewById(R.id.textView);
        button = view.findViewById(R.id.voting_scan);
        img1 = view.findViewById(R.id.ongoing_elections_bg);
        button.setVisibility(View.GONE);
        Firebase.setAndroidContext(getContext());
        myFirebase = new Firebase("https://voterzmate-default-rtdb.firebaseio.com/Text");
        myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myChildText = dataSnapshot.getValue(String.class);
                txt.setText(myChildText);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                txt.setText(firebaseError.toString());
            }
        });
        txt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (myChildText.equals("."))
                {
                    img1.setImageResource(R.drawable.voting_time);
                    button.setVisibility(View.VISIBLE);

                }
                else
                {   img1.setImageResource(R.drawable.ongoing_elections_bg);
                    button.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}