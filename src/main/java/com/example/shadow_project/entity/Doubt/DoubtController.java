package com.example.shadow_project.entity.Doubt;

import com.example.shadow_project.entity.Announcment.Announcement;
import com.example.shadow_project.entity.Answer.AnswerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doubt")
public class DoubtController {
    @Autowired
    private DoubtServiceImpl doubtService;

    @PostMapping("/register")
    public ResponseEntity<Doubt> uploadDoubt(@RequestBody DoubtDto doubtDto){
        Doubt doubt = doubtService.uploadDoubt(doubtDto);
        return ResponseEntity.ok(doubt);

    }
    @GetMapping("/{doubtId}")
    public ResponseEntity<Doubt> getDoubt(@PathVariable("doubtId") Long id){
        Doubt doubt = doubtService.getDoubt(id);
        return ResponseEntity.ok(doubt);
    }
    @PutMapping("/answer/{doubtId}")
    public ResponseEntity<Doubt> uploadAnsToDoubt(@PathVariable("doubtId") Long id, @RequestBody AnswerDto answerDto){
        Doubt doubt = doubtService.uploadAns(id,answerDto);
        return ResponseEntity.ok(doubt);
    }
    @GetMapping("/latestDoubts")
    public ResponseEntity<List<Doubt>> top6Doubts() throws Exception {
        List<Doubt> doubtList = doubtService.top6Doubts();
        return ResponseEntity.ok(doubtList);
    }

    @GetMapping("/allDoubts")
    public List<Doubt> getAllDoubts(@RequestParam(value = "pageNumber",defaultValue = "0",required = false) int pageNumber,
                                                  @RequestParam(value = "pageSize",defaultValue = "5",required = false) int pageSize){
        List<Doubt> doubtList = this.doubtService.getAllDoubts(pageNumber,pageSize);
        return doubtList;
    }
}
