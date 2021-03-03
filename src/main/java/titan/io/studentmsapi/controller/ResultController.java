package titan.io.studentmsapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import titan.io.studentmsapi.service.ResultService;

@Slf4j
@RestController
public class ResultController {
    @Autowired
    private ResultService resultService;
}
