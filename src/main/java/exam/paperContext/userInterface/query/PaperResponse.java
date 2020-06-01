package exam.paperContext.userInterface.query;

import exam.paperContext.common.mapper.ModelMapperFactory;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.infrastructure.po.PaperPO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class PaperResponse {
    private PaperId paperId;
    private List<BlankQuizResponse> blankQuizzes;
    private String teacherId;
    private LocalDateTime createTime;

    public static PaperResponse from(PaperPO paper) {
        return ModelMapperFactory.getMapper().map(paper, PaperResponse.class);
    }
}
