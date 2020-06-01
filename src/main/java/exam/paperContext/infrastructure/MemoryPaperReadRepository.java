package exam.paperContext.infrastructure;

import exam.blankquizcontext.domain.model.blankquiz.BlankQuizId;
import exam.blankquizcontext.domain.model.blankquiz.BlankQuizRepository;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperReadRepository;
import exam.paperContext.domain.model.paper.PaperRepository;
import exam.paperContext.infrastructure.po.BlankQuizPO;
import exam.paperContext.infrastructure.po.PaperPO;
import jdk.internal.net.http.common.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MemoryPaperReadRepository implements PaperReadRepository {

    public final PaperRepository paperRepository;
    public final BlankQuizRepository blankQuizRepository;

    @Autowired
    public MemoryPaperReadRepository(PaperRepository paperRepository, BlankQuizRepository blankQuizRepository) {
        this.paperRepository = paperRepository;
        this.blankQuizRepository = blankQuizRepository;
    }

    @Override
    public PaperPO find(PaperId id) {
        Paper paper = paperRepository.find(id);
        List<BlankQuizPO> blankQuizzes = paper.getQuizzes().stream()
                .map(quiz -> new Pair<>(blankQuizRepository.find(new BlankQuizId(quiz.getQuizId())), quiz.getScore()))
                .map(pair -> BlankQuizPO.from(pair.first, pair.second))
                .collect(Collectors.toList());

        return PaperPO.from(paper, blankQuizzes);
    }
}
