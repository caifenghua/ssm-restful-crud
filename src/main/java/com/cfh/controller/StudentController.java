package com.cfh.controller;

import com.cfh.entity.Student;
import com.cfh.service.StudentService;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    /**
     * 主页面
     * @return
     */
    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String index(){
        return "redirect:/index.jsp";
    }

    /**
     * 添加页面
     * @return
     */
    @RequestMapping(value="/addjsp",method= RequestMethod.GET)
    public String addjsp(){
        return "add";
    }

    /**
     * 修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/updatejsp/{id}",method = RequestMethod.GET)
    public String updatejsp(@PathVariable(value = "id") Integer id, Model model){
        model.addAttribute("stu",studentService.getStudentByID(id));

        return "update";
    }

    /**
     * 显示列表
     * @param model
     * @return
     */
    @RequestMapping(value="/student",method=RequestMethod.GET)
    public String getAllStudent(Model model){
        List<Student> stus=studentService.showStudentList();
        model.addAttribute("stus",stus);

        return "show";
    }

    /**
     * @ 添加restful风格
     * @return
     */
    @RequestMapping(value="/student",method=RequestMethod.POST)
    public String add(@ModelAttribute("stu")Student stu, Model model){
        if(studentService.checkID(stu.getSno())){
            model.addAttribute("message",stu.getSno()+"学号已有，添加失败！");
            return "message";
        }else{
            studentService.addStudent(stu);
            return "redirect:student";
            //model.addAttribute("message",stu.getSno()+"添加成功！");
        }

    }

    /**
     * 删除restful风格
     */
        @RequestMapping(value = "/student", method = RequestMethod.DELETE)
        @ResponseBody
        public Map deleteStudentByID(@RequestParam(value = "sno",required = true ,defaultValue = "null")  int sno, Model model){
            System.out.println("传过来的值是"+sno);
            int i = studentService.deleteByID(sno);
            Map map = new HashMap();
            if (i == 1){
                map.put("i",i);
                return map;
            }
            else{
                map.put("i",i);
                return map;
            }
        }

    /**
     * 修改restful风格
     */
    @RequestMapping(value="/student",method=RequestMethod.PUT)
    public String update(@ModelAttribute("stu")Student stu, Model model){
        System.out.println(stu);
        int i = studentService.updateByID(stu);
        if (i == 1)
            return "redirect:student";
        else{
            model.addAttribute("message",stu.getSno()+"修改失败");

            return "message";
        }
    }
}
