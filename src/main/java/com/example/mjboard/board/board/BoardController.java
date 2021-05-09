package com.example.mjboard.board.board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags={"1. Notice"})
@RequestMapping(value="/v1")
public class BoardController {

    private final BoardService boardService;
    @Autowired
    private BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @ApiOperation(value="게시판 작성", notes="bno 유무에 따라 insert, update")
    @PutMapping(value="/board")
    public ResponseEntity<?> boardInsert(@RequestBody BoardResultVO boardResultVO){
        ResponseEntity<ApiResponse> responseEntity;
        try{
            boardService.boardInsert(boardResultVO);
            responseEntity = new ResponseEntity<>(new ApiResponse(true,"저장 성공!"), HttpStatus.OK);
        }
        catch(Exception e){
            responseEntity = new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @ApiOperation(value="게시판 조회",notes="게시판 조회")
    @PostMapping(value="")
    public ResponseEntity<List<BoardResultVO>> boardPost(@RequestBody BoardConVO boardConVO){
        return new ResponseEntity<>(boardService.boardList(boardConVO),HttpStatus.OK);
    }

    @ApiOperation(value="게시판 조회", notes="게시판 조회")
    @GetMapping(value="/board")
    public ResponseEntity<List<BoardResultVO>> boardGet(){
        return new ResponseEntity<List<BoardResultVO>>(boardService.boardList(new BoardConVO()),HttpStatus.OK);
    }

    @ApiOperation(value="게시판 삭제", notes="게시판 삭제")
    @DeleteMapping(value="/board/{bno}")
    public ResponseEntity<?> boardDelete(@PathVariable Integer bno){
        ResponseEntity<ApiResponse> responseEntity;
        try{
            boardService.deleteBoard(bno);
            responseEntity = new ResponseEntity<>(new ApiResponse(true,bno+"번째 글이 삭제되었습니다."),HttpStatus.OK);
        } catch(Exception e){
            responseEntity = new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    /**
     * @Api
     * 해당 어노테이션으로 tags를 통해 Controller의 이름을 지정할 수 있습니다.
     *
     * @RestController
     * 해당 어노테이션으로 별도로 @ResponseBody 어노테이션을 붙이지 않아도 문자열과 JSON 등을 전송할 수가 있습니다.
     * 또한 @Controller와 다르게 문자열과 객체를 리턴하는 메서드를 보유하고 있습니다.
     *
     *
     */

}
