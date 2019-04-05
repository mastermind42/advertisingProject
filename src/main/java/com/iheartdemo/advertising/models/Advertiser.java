package com.iheartdemo.advertising.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Advertiser {

    @Id @GeneratedValue
    private Long id;

    private String advertiserName;
    private String primaryContactName;
    private Integer maxLimit;

}
