package com.project.demo.controller;

import com.project.demo.entity.ApplicationForStudyingAbroad;
import com.project.demo.service.ApplicationForStudyingAbroadService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


/**
 * 留学申报：(ApplicationForStudyingAbroad)表控制层
 *
 */
@RestController
@RequestMapping("/application_for_studying_abroad")
public class ApplicationForStudyingAbroadController extends BaseController<ApplicationForStudyingAbroad, ApplicationForStudyingAbroadService> {

    /**
     * 留学申报对象
     */
    @Autowired
    public ApplicationForStudyingAbroadController(ApplicationForStudyingAbroadService service) {
        setService(service);
    }


    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
