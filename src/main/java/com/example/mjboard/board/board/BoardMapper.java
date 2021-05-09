package com.example.mjboard.board.board;

import com.example.mjboard.board.board.BoardConVO;
import com.example.mjboard.board.board.BoardResultVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //게시글 작성
    public void boardInsert(BoardResultVO boardResultVO);
    //게시글 목록
    List<BoardResultVO> boardList(BoardConVO boardConVO);
    //게시글 삭제
    void boardDelete(Integer bno);

    /**
     * 이 어노테이션은 해당 Interface를 Mybatis Mapper로 등록한다는 뜻이다.
     * 해당 어노테이션을 사용함으로써 resources에 위치한 Mapper.xml에 있는 SQL을 인터페이스로 호출합니다.
     */

}
