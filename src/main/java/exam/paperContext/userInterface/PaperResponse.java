package exam.paperContext.userInterface;

import exam.paperContext.common.mapper.ModelMapperFactory;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.infrastructure.po.PaperPO;

import java.time.LocalDateTime;
import java.util.List;

public class PaperResponse {
    private PaperId paperId;
    private List<BlankQuizResponse> blankQuizzes;
    private String teacherId;
    private LocalDateTime createTime;

    public static PaperResponse from(PaperPO paper) {
        return ModelMapperFactory.getMapper().map(paper, PaperResponse.class);
    }
}
