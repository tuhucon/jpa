package com.example.jpa;

import com.example.jpa.workflow.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    public final H1Repository h1Repository;
    public final H2Repository h2Repository;
    public final WorkflowRepository workflowRepository;
    public final PersonRepository personRepository;

    @GetMapping("/workflow")
    public String workflow() {
        Workflow workflow = new LegalWorkflow();
        workflow.setState(new ApproveState());
        workflowRepository.save(workflow);

        workflow = new LegalWorkflow();
        workflow.setState(new RejectState());
        workflowRepository.save(workflow);

        workflow = new ContentWorkflow();
        workflow.setState(new ApproveState());
        workflowRepository.save(workflow);

        workflow = new ContentWorkflow();
        workflow.setState(new RejectState());
        workflowRepository.save(workflow);
        return "OK";
    }

    @GetMapping("/read")
    public String read() {
        for(long i = 1; i <= 4; i++) {
            Workflow workflow = workflowRepository.findById(i).get();
            System.out.println(workflow.execute());
            System.out.println(workflow.getState().execute());
            System.out.println("------------------");

            System.out.println(workflow.getState().getClass());
            System.out.println(workflow.getState().getOriginState().getClass());

            break;


        }
        return "OK";
    }

    @GetMapping("/h1")
    public String hello() {
        H1 a = h1Repository.getById(1L);
        H1 b = h1Repository.getById(2L);
        System.out.println(a.toString());
        System.out.println(a.getH2());
        System.out.println(b.toString());
        System.out.println(b.getH2().toString());
        return "OK";
    }

    @GetMapping("/h2")
    public String helloH2() {
        H2 a = new H2A();
        H2 b = new H2B();
//        a.setH1Id(1L);
//        b.setH1Id(2L);
        h2Repository.save(a);
        h2Repository.save(b);
        return "OK";
    }

    @GetMapping("/rf")
    public String rf() {
        System.out.println(StateFactory.getState(1).execute());
        System.out.println(StateFactory.getState(2).execute());
        return "OK";
    }

    @GetMapping("/person")
    public String person() {
        return personRepository.getAgeById(2L).age.toString();
    }
}
