package exam.paperContext.userInterface.query;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BlankQuizResponse {
    private String id;
    private String number;
    private int score;
    private String content;
    private String referenceAnswer;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private LocalDateTime removeTime;
}
