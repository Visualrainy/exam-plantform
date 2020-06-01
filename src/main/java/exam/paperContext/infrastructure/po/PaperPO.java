package exam.paperContext.infrastructure.po;

import exam.paperContext.common.mapper.ModelMapperFactory;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class PaperPO {
    private PaperId paperId;
    private List<BlankQuizPO> blankQuizzes;
    private String teacherId;
    private LocalDateTime createTime;

    public static PaperPO from(Paper paper, List<BlankQuizPO> blankQuizzes) {
        PaperPO paperPO = ModelMapperFactory.getMapper().map(paper, PaperPO.class);
        paperPO.blankQuizzes = blankQuizzes;

        return paperPO;
    }
}
