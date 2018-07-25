package claw.web.dbclawler.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "body_parse", schema = "crawler", catalog = "")
public class BodyParse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bodyParseId;
    @Basic
    private int entryId;
    @Basic
    private String customName;
    @Basic
    private int rank;
    @Basic
    private String cssSelector;



    public BodyParse() {
    }

    public BodyParse(int entryId, String customName, int rank, String cssSelector) {
        this.entryId = entryId;
        this.customName = customName;
        this.rank = rank;
        this.cssSelector = cssSelector;

    }

    public int getBodyParseId() {
        return bodyParseId;
    }

    public void setBodyParseId(int bodyParseId) {
        this.bodyParseId = bodyParseId;
    }

    public int getEntryId() {
        return entryId;
    }

    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    public String getCustomName() {
        return customName;
    }

    public void setCustomName(String customName) {
        this.customName = customName;
    }
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCssSelector() {
        return cssSelector;
    }

    public void setCssSelector(String cssSelector) {
        this.cssSelector = cssSelector;
    }


}
