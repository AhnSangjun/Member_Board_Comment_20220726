package com.its.member_board_comment.service;

import com.its.member_board_comment.dto.BoardDTO;
import com.its.member_board_comment.entity.BoardEntity;
import com.its.member_board_comment.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save(BoardDTO boardDTO) {
       Long savedId = boardRepository.save(BoardEntity.toSaveEntity(boardDTO)).getId();
       return savedId;
    }

    public List<BoardDTO> findAll() {
       List<BoardEntity> boardEntityList = boardRepository.findAll();
       List<BoardDTO> boardDTOList = new ArrayList<>();
        for (BoardEntity boardEntity: boardEntityList) {
            boardDTOList.add(BoardDTO.toBoardDTO(boardEntity));
        }
        return boardDTOList;
    }

    public BoardDTO findById(Long id) {
        // 조회수 처리
        // native sql: update board_table set boardHits=boardHits+1 where id=?
        boardRepository.boardHits(id);
        Optional<BoardEntity> optionalBoardEntity = boardRepository.findById(id);
        if (optionalBoardEntity.isPresent()) {
            return BoardDTO.toBoardDTO(optionalBoardEntity.get());
        } else {
            return null;
        }
    }
}












