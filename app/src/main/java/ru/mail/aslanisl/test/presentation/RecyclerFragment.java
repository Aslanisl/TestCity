package ru.mail.aslanisl.test.presentation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.mail.aslanisl.test.App;
import ru.mail.aslanisl.test.R;
import ru.mail.aslanisl.test.api.ApiService;
import ru.mail.aslanisl.test.model.api.ApiResponse;
import ru.mail.aslanisl.test.model.api.ResultResponse;

/**
 * Created by Ivan on 31.01.2018.
 */

public class RecyclerFragment extends Fragment implements Callback<ApiResponse>{
    public static final String TAG = RecyclerFragment.class.getSimpleName();

    public enum Type{
        SHARES,
        EVENTS
    }

    private Type type;

    @BindView(R.id.fragment_recycler_progress) ProgressBar progressBar;
    @BindView(R.id.fragment_recycler_view) RecyclerView recyclerView;
    private MyRecyclerAdapter adapter;

    private List<ResultResponse> results;
    private Unbinder unbinder;

    @Inject
    ApiService apiService;

    private Call<ApiResponse> apiCall;

    public static RecyclerFragment newInstance(Type type){
        RecyclerFragment fragment = new RecyclerFragment();
        Bundle args = new Bundle();
        args.putSerializable("type", type);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.getAppComponent().inject(this);
        Bundle args = getArguments();
        if (args != null) {
            type = (Type) args.getSerializable("type");
        } else {
            type = Type.SHARES;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_recycler_layout, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        progressBar.setVisibility(View.VISIBLE);

        switch (type){
            case EVENTS:
                apiCall = apiService.getEventsPosters();
                break;
            case SHARES:
                apiCall = apiService.getShares();
                break;
        }
        adapter = new MyRecyclerAdapter(type);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        apiCall.enqueue(this);

        return rootView;
    }

    @Override
    public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
        onResult();
        if (response.isSuccessful() && response.body() != null && response.body().getResponses() != null){
            results = response.body().getResponses();
            adapter.updateResult(results);
        }
    }

    @Override
    public void onFailure(Call<ApiResponse> call, Throwable t) {
        onResult();
        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
    }

    private void onResult(){
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (apiCall != null) apiCall.cancel();
    }
}
