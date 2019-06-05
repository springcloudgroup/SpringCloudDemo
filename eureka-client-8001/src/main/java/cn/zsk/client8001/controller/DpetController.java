package cn.zsk.client8001.controller;

import cn.zsk.client8001.service.DeptService;
import cn.zsk.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author:zsk
 * @CreateTime:2019-06-03 11:01
 */
@RequestMapping("dept")
@RestController
public class DpetController {
    @Autowired
    private DeptService deptService;

    @PostMapping("/save")
    public boolean save(@RequestBody DeptEntity deptEntity){

        return deptService.save(deptEntity);
    }
    @GetMapping("/getByDeptId")
    public DeptEntity getByDeptId(@PathVariable("deptId") Long deptId){

        return deptService.getById(deptId);
    }

    @GetMapping("/list")
    public List<DeptEntity> list(){

        return deptService.list();
    }
}