package claw.web.dbclawler.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "text_parse", schema = "crawler", catalog = "")
public class TextParse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int textParseId;
    @Basic
    private int entryId;
    @Basic
    private String type; //data, sapo, author, title, tag
    @Basic
    private String cssSelector;

    public TextParse() {
    }

    public TextParse(int entryId, String type, String cssSelector) {
        this.entryId = entryId;
        this.type = type;
        this.cssSelector = cssSelector;
    }

    public int getTextParseId() {
        return textParseId;
    }

    public void setTextParseId(int textParseId) {
        this.textParseId = textParseId;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }


}
