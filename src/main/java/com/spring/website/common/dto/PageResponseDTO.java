package com.spring.website.common.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PageResponseDTO<E> {
    private final List<E> list;
    private final PageRequestDTO pageRequestDTO;

//    public PageRequestDTO(List<E> list, PageRequestDTO pageResponseDTO) {
//        this.list = list;
//        this.pageRequestDTO = pageResponseDTO;
//    }
}
