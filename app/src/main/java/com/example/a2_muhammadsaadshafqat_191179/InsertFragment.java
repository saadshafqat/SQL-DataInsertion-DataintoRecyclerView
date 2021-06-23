package com.example.a2_muhammadsaadshafqat_191179;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InsertFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InsertFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InsertFragment newInstance(String param1, String param2) {
        InsertFragment fragment = new InsertFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        DBHelper db;

        View view= inflater.inflate(R.layout.fragment_insert, container, false);
        Button btn=(Button) view.findViewById(R.id.insertButton);
        EditText eText1=(EditText) view.findViewById(R.id.first) ;
        EditText eText2=(EditText) view.findViewById(R.id.second) ;
        EditText eText3=(EditText) view.findViewById(R.id.third) ;
        EditText eText4=(EditText) view.findViewById(R.id.fourth);
        db = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stdid=eText1.getText().toString().trim();
                String stdname=eText2.getText().toString().trim();
                String stdcity=eText3.getText().toString().trim();
                String stdage=eText4.getText().toString().trim();
                Boolean test=true;
                if(eText1.getText().toString().length()==0){
                    eText1.setError("Must Enter Data");
                    test=false;
                }
                if(TextUtils.isEmpty(stdname)){
                    eText2.setError("Must Enter Data");
                    test=false;
                }
                if(TextUtils.isEmpty(stdcity)){
                    eText3.setError("Must Enter Data");
                    test=false;
                }
                if(eText4.getText().toString().length()==0){
                    eText4.setError("Must Enter Data");
                    test=false;
                }
                if(test=true){
                    Boolean checkinsertdata = db.insertStudentData(stdid, stdname, stdcity,stdage);
                    if(checkinsertdata==true)
                        Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity(), "Failed!!", Toast.LENGTH_SHORT).show();

                }
            }
        });



        return view;
    }
}