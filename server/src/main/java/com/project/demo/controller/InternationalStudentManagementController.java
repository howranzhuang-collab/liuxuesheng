package com.project.demo.controller;

import com.project.demo.entity.InternationalStudentManagement;
import com.project.demo.service.InternationalStudentManagementService;
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
 * 留学生管理：(InternationalStudentManagement)表控制层
 *
 */
@RestController
@RequestMapping("/international_student_management")
public class InternationalStudentManagementController extends BaseController<InternationalStudentManagement, InternationalStudentManagementService> {

    /**
     * 留学生管理对象
     */
    @Autowired
    public InternationalStudentManagementController(InternationalStudentManagementService service) {
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
