package com.phonytive.astive.ami.action;

public class DataGetAction extends ActionMessage {
    private String path;
    private String search;
    private String filter;

    public DataGetAction(String path) {
        super(ActionType.DATA_GET);
        this.path = path;
    }

    public DataGetAction(String path, String search) {
        super(ActionType.DATA_GET);
        this.path = path;
        this.search = search;
    }

    public DataGetAction(String path, String search, String filter) {
        super(ActionType.DATA_GET);
        this.path = path;
        this.search = search;
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
