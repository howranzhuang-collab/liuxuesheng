package com.project.demo.controller;

import com.project.demo.entity.TuitionPayment;
import com.project.demo.service.TuitionPaymentService;
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
 * 学费缴纳：(TuitionPayment)表控制层
 *
 */
@RestController
@RequestMapping("/tuition_payment")
public class TuitionPaymentController extends BaseController<TuitionPayment, TuitionPaymentService> {

    /**
     * 学费缴纳对象
     */
    @Autowired
    public TuitionPaymentController(TuitionPaymentService service) {
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
