package claw.web.dbclawler.entity;

import javax.persistence.*;

@Entity
//@Table(name = "entry_filter", schema = "crawler", catalog = "")
public class EntryFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Basic
    private int entryId;
    @Basic
    private String text;
    @Basic
    private boolean selected;

    public EntryFilter() {
    }

    public EntryFilter(int entryId, String text, boolean selected) {
        this.entryId = entryId;
        this.text = text;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
