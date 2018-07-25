package claw.web.dbclawler.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "entry_parse", schema = "crawler", catalog = "")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int entryId;
    @Basic
    private String urlCategory;
    @Basic
    private String cssSelector;
    @Basic
    private String type;
    @Basic
    private char delimitation;
    @Basic
    private boolean actived;

    public Entry() {
    }

    public Entry(String urlCategory, String cssSelector, String type, char delimitation, boolean actived) {
        this.urlCategory = urlCategory;
        this.cssSelector = cssSelector;
        this.type = type;
        this.delimitation = delimitation;
        this.actived = actived;
    }

    public Entry(int Id, String urlCategory, String cssSelector, String type, char delimitation, boolean actived) {
        this.entryId= Id;
        this.urlCategory = urlCategory;
        this.cssSelector = cssSelector;
        this.type = type;
        this.delimitation = delimitation;
        this.actived = actived;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getUrlCategory() {
        return urlCategory;
    }

    public void setUrlCategory(String urlCategory) {
        this.urlCategory = urlCategory;
    }

    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getDelimitation() {
        return delimitation;
    }

    public void setDelimitation(char delimitation) {
        this.delimitation = delimitation;
    }

    public boolean isActived() {
        return actived;
    }

    public void setActived(boolean actived) {
        this.actived = actived;
    }


}
