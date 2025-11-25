package com.example.medtimeapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class FamiliarFragment extends Fragment {

    private static final int ADD_FAMILIAR_REQUEST = 2;

    private List<Familiar> familiarList = new ArrayList<>();
    private FamiliarAdapter adapter;
    private RecyclerView recyclerView;
    private TextView emptyView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_familiar, container, false);

        recyclerView = view.findViewById(R.id.familiar_recycler_view);
        emptyView = view.findViewById(R.id.familiar_empty_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FamiliarAdapter(familiarList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton fab = view.findViewById(R.id.fab_add_familiar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddFamiliarActivity.class);
                startActivityForResult(intent, ADD_FAMILIAR_REQUEST);
            }
        });

        updateUI();
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_FAMILIAR_REQUEST && resultCode == RESULT_OK && data != null) {
            Familiar newFamiliar = (Familiar) data.getSerializableExtra("familiar");
            if (newFamiliar != null) {
                familiarList.add(newFamiliar);
                adapter.notifyDataSetChanged();
                updateUI();
            }
        }
    }

    private void updateUI() {
        if (familiarList.isEmpty()) {
            recyclerView.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            recyclerView.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
    }
}
