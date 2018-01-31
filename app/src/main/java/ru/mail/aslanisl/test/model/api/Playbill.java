package ru.mail.aslanisl.test.model.api;

import java.util.List;

/**
 * Created by Ivan on 31.01.2018.
 */

public class Playbill {
    private String id;
    private String name;
    private List<PlaybillContainer> playbill;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<PlaybillContainer> getPlaybill() {
        return playbill;
    }
}
