package exam.paperContext.domain.model.paper;

import exam.paperContext.infrastructure.po.PaperPO;

public interface PaperReadRepository {
    PaperPO find(PaperId id);
}
