package ru.mail.aslanisl.test.model.api;

import ru.mail.aslanisl.test.api.ApiService;

/**
 * Created by Ivan on 31.01.2018.
 */

public class ApiFile {
    private int id;
    private String name;
    private String role;
    private String type;
    private String link;
    private String order;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getType() {
        return type;
    }

    public String getLink() {
        return ApiService.IMAGE_URL + link;
    }

    public String getOrder() {
        return order;
    }
}
