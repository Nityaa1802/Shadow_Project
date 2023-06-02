package com.example.shadow_project.entity.Doubt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doubt")
public class DoubtController {
    @Autowired
    private DoubtServiceImpl doubtService;
    @Autowired
    private DoubtRepo doubtRepo;

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
}
