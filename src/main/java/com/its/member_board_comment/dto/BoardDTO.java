package com.its.member_board_comment.dto;

import com.its.member_board_comment.entity.BoardEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long id;
    private String boardTitle;
    private String boardWrite;
    private String boardPassword;
    private String boardContents;
    private int boardHits;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public BoardDTO(String boardTitle, String boardWrite, String boardPassword, String boardContents) {
        this.boardTitle = boardTitle;
        this.boardWrite = boardWrite;
        this.boardPassword = boardPassword;
        this.boardContents = boardContents;
    }

    public static BoardDTO toBoardDTO(BoardEntity boardEntity) {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setId(boardDTO.getId());
        boardDTO.setBoardTitle(boardEntity.getBoardTitle());
        boardDTO.setBoardWrite(boardEntity.getBoardWriter());
        boardDTO.setBoardContents(boardEntity.getBoardContents());
        boardDTO.setBoardHits(boardEntity.getBoardHits());
        boardDTO.setCreatedTime(boardEntity.getCreatedTime());
        boardDTO.setCreatedTime(boardEntity.getUpdatedTime());
        return boardDTO;
    }
}
