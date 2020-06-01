package exam.paperContext.infrastructure.po;

import exam.blankquizcontext.domain.model.blankquiz.BlankQuiz;
import exam.paperContext.common.mapper.ModelMapperFactory;

import java.time.LocalDateTime;

public class BlankQuizPO {
    private String id;
    private String number;
    private int score;
    private String content;
    private String referenceAnswer;
    private LocalDateTime createTime;
    private LocalDateTime lastUpdateTime;
    private LocalDateTime removeTime;

    public static BlankQuizPO from(BlankQuiz blankQuiz, int score) {
        BlankQuizPO quizPO = ModelMapperFactory.getMapper().map(blankQuiz, BlankQuizPO.class);
        quizPO.score = score;

        return quizPO;
    }
}
