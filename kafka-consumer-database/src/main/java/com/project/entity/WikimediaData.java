package com.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Author: SANDEEP
 * Date: 02/01/25
 */

@Entity
@Table(name = "wikimedia_recent_change")
public class WikimediaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String wikiEventData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWikiEventData() {
        return wikiEventData;
    }

    public void setWikiEventData(String wikiEventData) {
        this.wikiEventData = wikiEventData;
    }
}
