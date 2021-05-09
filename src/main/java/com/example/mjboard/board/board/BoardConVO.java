package com.example.mjboard.board.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BoardConVO {
    @ApiModelProperty(position=1, value="게시판 번호",example = "1", required = true)
    private Integer bno;

    @ApiModelProperty(position=2, value="제목", example = "제목입니다.")
    private String subject;

    @ApiModelProperty(position=3, value="내용", example = "내용입니다.")
    private  String content;

    @ApiModelProperty(position=4, value="작성자", example = "작성자")
    private String writer;

    @ApiModelProperty(position=5, value="게시일", example = "2020-05-09")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date reg_date;

    @ApiModelProperty(position=6, value="조회", example = "0")
    private Integer hit;

    /**
     * @Data
     * 이 어노테이션은 @Getter와 @Setter 그리고 @RequiredArgsConstructor, @ToString, @EqualsAndHashCode을
     * 한 번에 설정합니다. 그만큼 강력한 어노테이션인만큼 주의해서 사용하는 것이 좋습니다.
     *
     * @ApiModelProperty
     * 객체의 필드 내용을 작성하는 어노테이션입니다. 작성한 내용은 API에서 확인이 가능합니다.
     *
     * @JsonForamt
     * 해당 어노테이션은 Date 타입인 reg_date를 JsonFormat으로 변경합니다. 계층간의 데이터를 주고 받을 때
     * Json형식으로 주고받기 때문에 Format을 변경해주지 않으면 Date 값이 전달이 되지가 않습니다.
     */
}
