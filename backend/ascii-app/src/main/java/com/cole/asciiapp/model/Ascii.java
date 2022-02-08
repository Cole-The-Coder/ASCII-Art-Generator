package com.cole.asciiapp.model;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.content.commons.annotations.ContentId;
import org.springframework.content.commons.annotations.ContentLength;

import javax.persistence.*;

@Entity
public class Ascii {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String title;

    private String description;

    /*
    @ManyToOne
    @JoinColumn(name = "owner", foreignKey = @ForeignKey(name = "owner"))
    public SecurityProperties.User owner;
    */

    @ContentId
    private String contentId;

    @ContentLength
    private long contentLength;

}
