package titan.io.studentmsapi.service;

import com.sun.istack.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import titan.io.studentmsapi.model.Result;
import titan.io.studentmsapi.repository.ResultRepository;

import java.util.List;

@Slf4j
@Service
public class ResultService{
    @Autowired
    private ResultRepository resultRepository;

    // get all result
    public List<Result> getAllResult(){
        return resultRepository.findAll();
    }
    // get result by id
    public Result getResultById(@NotNull int id){
        return resultRepository.findById(id).orElse(null);
    }
    // get result by roll
    public Result getResultByRoll(@NotNull int roll){
        return resultRepository.findByRoll(roll);
    }
    // post one result
    public Result postOneResult(@NotNull Result result){
        Result existingResult = resultRepository.findByRoll(result.getRoll());
        if(existingResult != null){
            // roll already exist
            return null;
        }else {
            return resultRepository.save(result);
        }
    }
    // post all result
    public List<Result> postAllResult(@NotNull List<Result> resultList){
        return resultRepository.saveAll(resultList);
    }
    // delete result by id
    public String deleteResultById(@NotNull int id){
        Result existingResult = resultRepository.findById(id).orElse(null);
        if(existingResult == null){
            // no result exist
            return "no result found, id: " + id;
        }else {
            resultRepository.deleteById(id);
            return "result deleted, id: " + id;
        }
    }
    // delete result by result obj
    public String deleteResultByObj(@NotNull Result result){
        Result existingResult = resultRepository.findById(result.getId()).orElse(null);
        if(existingResult == null){
            return "no result found, id: " + result.getId();
        }else{
            resultRepository.delete(result);
            return "result deleted, id: " + result.getId();
        }
    }
    // update result by result obj
    public Result updateResultByResultObj(@NotNull Result result){
        Result existingResult = resultRepository.findById(result.getId()).orElse(null);
        if(existingResult == null){
            return null;
        }else {
            existingResult.setRoll(result.getRoll());
            existingResult.setBangla(result.getBangla());
            existingResult.setEnglish(result.getEnglish());
            existingResult.setMath(result.getMath());
            existingResult.setComputer(result.getComputer());
            existingResult.setPhysics(result.getPhysics());
            existingResult.setChemistry(result.getChemistry());
            existingResult.setBiology(result.getBiology());

            return resultRepository.save(existingResult);
        }
    }
}
