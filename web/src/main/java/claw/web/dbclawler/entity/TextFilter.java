package claw.web.dbclawler.entity;

import javax.persistence.*;

@Entity
public class TextFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int textFilterId;
    @Basic
    private int entryId;
    @Basic
    private int type;
    @Basic
    private String target;
    @Basic
    private String replace; //data, sapo, author, title, tag

    public TextFilter() {
    }

    public TextFilter(int entryId, int type, String target, String replace) {
        this.entryId = entryId;
        this.type = type;
        this.target = target;
        this.replace = replace;
    }

    public int getTextFilterId() {
        return textFilterId;
    }

    public void setTextFilterId(int textFilterId) {
        this.textFilterId = textFilterId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getReplace() {
        return replace;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }
}
