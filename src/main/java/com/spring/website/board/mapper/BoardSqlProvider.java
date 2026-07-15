package com.spring.website.board.mapper;

import com.spring.website.board.dto.BoardDTO;
import com.spring.website.common.dto.PageRequestDTO;

public class BoardSqlProvider {
    public String updateQuery(BoardDTO boardDTO) {
        StringBuilder sql = new StringBuilder();

        sql.append("UPDATE spring_board");
        sql.append("SET b_title = #{boardTitle}, ");
        sql.append("b_content = #{boardContent} ");

        if (boardDTO.getBoardPasswd() != null && !boardDTO.getBoardPasswd().isBlank()) {
            sql.append(", b_pwd = #{boardPasswd} ");
        }

        sql.append("WHERE b_num = #{boardNumber}");

        return sql.toString();
    }

    public String boardListQuery(PageRequestDTO pageRequestDTO) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT b_num, b_name, b_title, TO_CHAR(b_date, 'YYYY-MM-DD') AS b_date, b_readCnt");
        sql.append("FROM spring_board");

        String keyword = pageRequestDTO.getKeyword();
        if (keyword != null && !keyword.isBlank()) {
            String searchColumn = switch (pageRequestDTO.getSearchType()) {
                case "title" -> "b_title";
                case "content" -> "b_content";
                case "name" -> "b_name";
                default -> "b_title";
            };

            sql.append(" WHERE ");
            sql.append(searchColumn);
            sql.append(" LIKE '%' || #{keyword} || '%'");
        }

        sql.append(" ORDER BY b_num DESC");
        return sql.toString();
    }
}
