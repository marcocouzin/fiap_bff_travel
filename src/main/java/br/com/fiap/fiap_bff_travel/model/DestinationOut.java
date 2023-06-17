package br.com.fiap.fiap_bff_travel.model;

public class DestinationOut {
    private String group;
    private Destination subgroup;

    public DestinationOut(String group, Destination subgroup) {
        this.group = group;
        this.subgroup = subgroup;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Destination getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Destination subgroup) {
        this.subgroup = subgroup;
    }
}
