package ru.mail.aslanisl.test.presentation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.mail.aslanisl.test.R;
import ru.mail.aslanisl.test.model.api.ApiFile;
import ru.mail.aslanisl.test.model.api.Parameter;
import ru.mail.aslanisl.test.model.api.ResultResponse;

/**
 * Created by Ivan on 31.01.2018.
 */

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private RecyclerFragment.Type type;

    private List<ResultResponse> items = new ArrayList<>();

    public MyRecyclerAdapter(RecyclerFragment.Type type) {
        this.type = type;
    }

    public void updateResult(List<ResultResponse> results) {
        items.clear();
        items.addAll(results);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (type){
            case SHARES:
                View sharesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_shares, parent, false);
                return new SharesViewHolder(sharesView);
            case EVENTS:
                View eventsView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_events, parent, false);
                return new EventsViewHolder(eventsView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ResultResponse result = items.get(position);
        switch (type){
            case SHARES:
                SharesViewHolder sharesHolder = (SharesViewHolder) holder;
                sharesHolder.bindHolder(result);
                break;
            case EVENTS:
                EventsViewHolder eventsHolder = (EventsViewHolder) holder;
                eventsHolder.bindHolder(result);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class SharesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_shares_image) ImageView image;
        @BindView(R.id.item_shares_title) TextView title;
        @BindView(R.id.item_shares_description) TextView description;
        public SharesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindHolder(ResultResponse result){
            if (result != null){
                itemView.setVisibility(View.VISIBLE);

                String imageUrl = null;
                List<ApiFile> files = result.getFiles();
                if (files != null && !files.isEmpty()){
                    imageUrl = files.get(0).getLink();
                }
                Glide.with(itemView).load(imageUrl).into(image);

                title.setText(result.getName() != null ? result.getName() : "");
                description.setText(result.getDescription() != null ? result.getDescription() : "");
            } else {
                itemView.setVisibility(View.GONE);
            }
        }
    }

    static class EventsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.item_events_image) ImageView image;
        @BindView(R.id.item_events_title) TextView title;
        @BindView(R.id.item_events_description) TextView description;
        @BindView(R.id.item_events_youtube_id) TextView youtubeId;
        public EventsViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void bindHolder(ResultResponse result){
            if (result != null){
                itemView.setVisibility(View.VISIBLE);

                String imageUrl = null;
                List<ApiFile> files = result.getFiles();
                if (files != null && !files.isEmpty()){
                    imageUrl = files.get(0).getLink();
                }
                Glide.with(itemView).load(imageUrl).into(image);

                title.setText(result.getName() != null ? result.getName() : "");
                description.setText(result.getDescription() != null ? result.getDescription() : "");
                Parameter parameter = result.getParameters();
                if (parameter != null){
                    youtubeId.setText(parameter.getTrailer() != null ? parameter.getTrailer() : "");
                } else {
                    youtubeId.setText("");
                }

            } else {
                itemView.setVisibility(View.GONE);
            }
        }
    }
}
