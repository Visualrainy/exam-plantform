package exam.paperContext.userInterface;

import exam.paperContext.application.AssemblePaperCommand;
import exam.paperContext.application.PaperService;
import exam.paperContext.domain.model.paper.Paper;
import exam.paperContext.domain.model.paper.PaperId;
import exam.paperContext.domain.model.paper.PaperReadRepository;
import exam.paperContext.infrastructure.po.PaperPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaperController {

    private PaperService paperService;
    private final PaperReadRepository paperReadRepository;

    @Autowired
    public PaperController(PaperService paperService, PaperReadRepository paperReadRepository) {
        this.paperService = paperService;
        this.paperReadRepository = paperReadRepository;
    }

    @PostMapping("/papers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    PaperDTO assemble(@RequestBody AssemblePaperCommand command) {
        final PaperId paperId = paperService.assemblePaper(command);
        return PaperDTO.from(paperId);
    }

    @GetMapping("/papers")
    List<Paper> getAll() {
        return paperService.getAll();
    }

    @GetMapping("/papers/{id}")
    PaperResponse findPaper(@PathVariable String id) {
        PaperPO paperPO = paperReadRepository.find(new PaperId(id));
        return PaperResponse.from(paperPO);
    }

    @PutMapping("/papers/{paperId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void reassemble(@PathVariable String paperId, @RequestBody AssemblePaperCommand command) {
        paperService.reassemblePaper(paperId, command);
    }
}
