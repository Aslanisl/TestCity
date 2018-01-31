package ru.mail.aslanisl.test.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ivan on 31.01.2018.
 */

public class ResultResponse {
    private int id;
    private String name;
    private int startdate;
    private int enddate;
    private String description;
    private int state;
    private Parameter parameters;
    private List<Playbill> playbill;
    private List<ApiFile> files;
    private String type;
    private String source;
    @SerializedName("source_link")
    @Expose
    private String sourceLink;
    @SerializedName("source_id")
    @Expose
    private int sourceId;
    private int rating;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStartdate() {
        return startdate;
    }

    public int getEnddate() {
        return enddate;
    }

    public String getDescription() {
        return description;
    }

    public int getState() {
        return state;
    }

    public Parameter getParameters() {
        return parameters;
    }

    public List<Playbill> getPlaybill() {
        return playbill;
    }

    public List<ApiFile> getFiles() {
        return files;
    }

    public String getType() {
        return type;
    }

    public String getSource() {
        return source;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public int getSourceId() {
        return sourceId;
    }

    public int getRating() {
        return rating;
    }
}
