package com.iheartdemo.advertising.models;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString @EqualsAndHashCode
public class Advertiser {

    private Long id;

    private String advertiserName;
    private String primaryContactName;
    private Integer maxLimit;

}
