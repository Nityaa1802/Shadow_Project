package com.example.shadow_project.entity.Domain;

import com.example.shadow_project.Payload.ApiResponse;
import com.example.shadow_project.entity.Project.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/domain")
public class DomainController {
    @Autowired
    DomainServiceImpl domainService;
    @Autowired
    private DomainRepo domainRepo;

    @PostMapping("/upload/{domain}")
    public ResponseEntity<Domain> uploadDomain(@PathVariable("domain") String domain , @RequestParam("projectId") Long projectId){
        Domain domain1 = domainService.uploadDomain(domain,projectId);
        return ResponseEntity.ok(domain1);
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> updateDomain(@RequestParam("domainsUploadedByUser")List<String> domainsUploadedByUser , @RequestParam("projectId") Long projectId){
        this.domainService.updateDomain(domainsUploadedByUser,projectId);
        return ResponseEntity.ok(new ApiResponse("success",true));
    }

    @GetMapping("/allDomains")
    public ResponseEntity<List<String>> getAllDomains(){
        List<String> domains = this.domainService.allDomains();
        return ResponseEntity.ok(domains);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Project>> searchProjectInDomain(@PathVariable("domain") String domain){
        List<Project> response = this.domainService.searchProjectInDomain(domain);
        return ResponseEntity.ok(response);
    }
    @GetMapping("/domainSpecificProjects")
    public ResponseEntity<List<Project>> allProjectsInDomain(@PathVariable("domain") String domain) throws Exception {
        List<Project> response = this.domainService.allProjectsInDomain(domain);
        return ResponseEntity.ok(response);
    }



}
