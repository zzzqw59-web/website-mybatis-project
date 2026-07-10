package com.spring.website.board.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardDTO {
    private int boardNumber; // 글번호
    private String boardName; // 작성자
    private String boardTitle; // 제목
    private String boardContent; // 내용
    private String boardDate; // 작성일
    private String boardPasswd; // 비밀번호
    private int boardReadCnt; // 조회수
}
