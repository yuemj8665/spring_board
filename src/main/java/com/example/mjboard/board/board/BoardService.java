package com.example.mjboard.board.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class BoardService {

        private final BoardMapper boardMapper;

        @Autowired
        public BoardService(BoardMapper boardMapper){
            this.boardMapper = boardMapper;
        }
        void boardInsert(BoardResultVO boardResultVO){
            boardMapper.boardInsert(boardResultVO);
        }
        List<BoardResultVO> boardList(BoardConVO boardConVO){
            List<BoardResultVO> returnResult = boardMapper.boardList(boardConVO);
            return returnResult;
        }
        List<BoardResultVO> boardList(Integer bno){
            BoardConVO boardConVO = new BoardConVO();
            boardConVO.setBno(bno);
            List<BoardResultVO> returnResult = boardMapper.boardList(boardConVO);
            return returnResult;
        }
        void deleteBoard(Integer bno){
            boardMapper.boardDelete(bno);
        }
}
