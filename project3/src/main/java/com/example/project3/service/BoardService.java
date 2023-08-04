package com.example.project3.service;

import com.example.project3.entity.BoardEntity;
import com.example.project3.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public void write(BoardEntity boardEntity) throws Exception{
        boardRepository.save(boardEntity);
    }

    public Page<BoardEntity> boardList(Pageable pageable) {

        return boardRepository.findAll(pageable);
    }

    public Page<BoardEntity> boardSearchList(String searchKeyword, Pageable pageable) {
        return boardRepository.findByTitleContainingOrContentContaining(searchKeyword, searchKeyword, pageable);
    }

    public BoardEntity boardView(Long id) {
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Long id) {
        boardRepository.deleteById(id);
    }
}
