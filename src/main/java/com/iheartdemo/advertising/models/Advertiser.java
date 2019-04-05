package com.iheartdemo.advertising.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter @NoArgsConstructor
public class Advertiser {

    @Id @GeneratedValue
    private Long id;

    private String advertiserName;
    private String primaryContactName;
    private Integer maxLimit;

    public Advertiser(String advertiserName, String primaryContactName, Integer maxLimit) {
        this.advertiserName = advertiserName;
        this.primaryContactName = primaryContactName;
        this.maxLimit = maxLimit;
    }
}
