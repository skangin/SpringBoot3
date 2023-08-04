package com.example.project3.repository;

import com.example.project3.entity.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity,Long> {

    Page<BoardEntity> findByTitleContainingOrContentContaining(String searchTitle, String searchContent, Pageable pageable);


}
