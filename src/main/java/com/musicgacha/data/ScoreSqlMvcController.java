//package com.musicgacha.data;
//
//
//import com.musicgacha.data.SQL.*;
//import org.json.simple.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.*;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.validation.Valid;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//// Built using article: https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/mvc.html
//// or similar: https://asbnotebook.com/2020/04/11/spring-boot-thymeleaf-form-validation-example/
//@Controller
//public class ScoreSqlMvcController implements WebMvcConfigurer {
//
//    // Autowired enables Control to connect HTML and POJO Object to Database easily for CRUD
//    @Autowired
//    private ScoreSqlRepository repository;
//
//    @GetMapping("/data/score")
//    public String score(Model model) {
//        List<Score> list = repository.listAll();
//        model.addAttribute("list", list);
//        return "/data/score";
//    }
//
//    /*  The HTML template Forms and PersonForm attributes are bound
//        @return - template for person form
//        @param - Person Class
//    */
//    @GetMapping("/data/scorecreate")
//    public String scoreAdd(Score score) {
//        return "/data/scorecreate";
//    }
//
//    /* Gathers the attributes filled out in the form, tests for and retrieves validation error
//    @param - Person object with @Valid
//    @param - BindingResult object
//     */
//    @PostMapping("/data/scorecreate")
//    public String scoreSave(@Valid Score score, BindingResult bindingResult) {
//        // Validation of Decorated PersonForm attributes
//        if (bindingResult.hasErrors()) {
//            return "/data/scorecreate";
//        }
//        repository.save(score);
//        // Redirect to next step
//        return "redirect:/data/score";
//    }
//
//    @GetMapping("/data/scoreupdate/{id}")
//    public String scoreUpdate(@PathVariable("id") int id, Model model) {
//        model.addAttribute("score", repository.get(id));
//        return "/data/scoreupdate";
//    }
//
//    @PostMapping("/data/scoreupdate")
//    public String scoreUpdateSave(@Valid Score score, BindingResult bindingResult) {
//        // Validation of Decorated PersonForm attributes
//        if (bindingResult.hasErrors()) {
//            return "/data/scoreupdate";
//        }
//        repository.save(score);
//        // Redirect to next step
//        return "redirect:/data/score";
//    }
//
//    @GetMapping("/data/scoredelete/{id}")
//    public String scoreDelete(@PathVariable("id") long id) {
//        repository.delete(id);
//        return "redirect:/data/score";
//    }
//
//    /*
//    #### RESTful API section ####
//    Resource: https://spring.io/guides/gs/rest-service/
//    */
//
//    /*
//    GET List of People
//     */
//    @RequestMapping(value = "/api/score/get")
//    public ResponseEntity<List<Score>> getScores() {
//        return new ResponseEntity<>( repository.listAll(), HttpStatus.OK);
//    }
//
//    /*
//    GET individual Person using ID
//     */
//    @RequestMapping(value = "/api/score/get/{id}")
//    public ResponseEntity<Score> getScore(@PathVariable long id) {
//        return new ResponseEntity<>( repository.get(id), HttpStatus.OK);
//    }
//
//    /*
//    DELETE individual Person using ID
//     */
//    @RequestMapping(value = "/api/score/delete/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Object> deleteScores(@PathVariable long id) {
//        repository.delete(id);
//        return new ResponseEntity<>( ""+ id +" deleted", HttpStatus.OK);
//    }
//
//
//    /*
//    POST Aa record by Requesting Parameters from URI
//     */
//    @RequestMapping(value = "/api/score/post", method = RequestMethod.POST)
//    public ResponseEntity<Object> postScore(@RequestParam("email") String email,
//                                             @RequestParam("name") String name,
//                                             @RequestParam("dob") String dobString) {
//        String dob = null;
//        /*try {
//            dob = new SimpleDateFormat("MM-dd-yyyy").parse(dobString);
//        } catch (Exception e) {
//            return new ResponseEntity<>(dobString +" error; try MM-dd-yyyy", HttpStatus.BAD_REQUEST);
//        }*/
//        // A person object WITHOUT ID will create a new record
//        Score score = new Score(email, name, dob);
//        repository.save(score);
//        return new ResponseEntity<>(email +" is created successfully", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/data/score_search")
//    public String score() {
//        return "/data/score_search";
//    }
//
//    /*
//    The personSearch API looks across database for partial match to term (k,v) passed by RequestEntity body
//     */
//    @RequestMapping(value = "/api/score_search", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> scoreSearch(RequestEntity<Object> request) {
//
//        // extract term from RequestEntity
//        JSONObject json = new JSONObject((Map) Objects.requireNonNull(request.getBody()));
//        String term = (String) json.get("term");
//
//        // custom JPA query to filter on term
//        List<Score> list = repository.listLikeNative(term);
//
//        // return resulting list and status, error checking should be added
//        return new ResponseEntity<>(list, HttpStatus.OK);
//    }
//
//}
