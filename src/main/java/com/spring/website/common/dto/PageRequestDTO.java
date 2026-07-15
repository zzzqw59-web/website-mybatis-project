package com.spring.website.common.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PageRequestDTO {
    private String searchType = "";
    private String keyword = "";
}
