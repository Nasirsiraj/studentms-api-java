package titan.io.studentmsapi.controller;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import titan.io.studentmsapi.model.Result;
import titan.io.studentmsapi.service.ResultService;

import java.util.List;

@Slf4j
@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;

    // get all result
    @GetMapping("/results")
    public List<Result> getAllResult(){
        return resultService.getAllResult();
    }
    // get result by id
    @GetMapping("/result/{id}")
    public Result getResultById(@PathVariable @NotNull int id){
        return resultService.getResultById(id);
    }
    // get result by roll
     @GetMapping("/resultByRoll/{roll}")
    public Result getResultByRoll(@PathVariable @NotNull int roll){
        return resultService.getResultByRoll(roll);
     }
    // post one result
    @PostMapping("/result")
    public Result postOneResult(@RequestBody @NotNull Result result){
        return resultService.postOneResult(result);
    }
    // post all result
    @PostMapping("/results")
    public List<Result> postAllResult(@RequestBody @NotNull List<Result> resultList){
        return resultService.postAllResult(resultList);
    }
    // delete result by id
    @DeleteMapping("/result/{id}")
    public String deleteResultById(@PathVariable @NotNull int id){
        return resultService.deleteResultById(id);
    }
    // delete result by result obj
    @DeleteMapping("/result")
    public String deleteResultByResultObj(@RequestBody @NotNull Result result){
        return resultService.deleteResultByObj(result);
    }
    // update result by result obj
    @PutMapping("/result")
    public Result updateResultByResultObj(@RequestBody @NotNull Result result){
        return resultService.updateResultByResultObj(result);
    }
}
