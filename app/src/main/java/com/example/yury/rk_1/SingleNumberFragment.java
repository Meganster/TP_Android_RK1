package com.example.yury.rk_1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SingleNumberFragment extends Fragment {

    private final static String KEY_NUMBER = "num";
    private Integer number;
    TextView textView;

    public static Fragment newInstance(Integer num) {
        SingleNumberFragment singleNumberFragment = new SingleNumberFragment();

        Bundle myBundle = new Bundle();
        myBundle.putInt(KEY_NUMBER, num);
        singleNumberFragment.setArguments(myBundle);

        return singleNumberFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle arguments = getArguments();

        if (arguments != null) {
            number = arguments.getInt(KEY_NUMBER);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.singlenumber_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView = view.findViewById(R.id.text);
        textView.setTextSize(50);

        if (number % 2 == 0) {
            textView.setTextColor(getResources().getColor(R.color.red));
        } else {
            textView.setTextColor(getResources().getColor(R.color.blue));
        }

        textView.setText(String.valueOf(number));
    }
}