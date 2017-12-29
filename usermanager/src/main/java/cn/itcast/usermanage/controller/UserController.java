package cn.itcast.usermanage.controller;

import cn.itcast.usermanage.service.UserService;
import cn.itcast.usermanage.pojo.EasyUIResult;
import cn.itcast.usermanage.pojo.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping(value = "user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "users")
    public String toUsers() {
        return "users";
    }

    @ResponseBody
    @RequestMapping(value = "list")
    public EasyUIResult queryUsersByPage(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize) {
        return this.userService.queryEasyUIResult(pageNum, pageSize);
    }

    @RequestMapping(value = "/page/{pageName}")
    public String toUserAdd(@PathVariable("pageName") String pageName) {
        return pageName;
    }

    /**
     * 新增会员
     * @param user
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public Map<String, Object> addUser(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            Boolean b = this.userService.addUser(user);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 编辑会员
     * @param user
     * @return
     */
    @RequestMapping(value = "edit")
    @ResponseBody
    public Map<String, Object> editUser(User user) {
        Map<String, Object> map = new HashMap<>();
        try {
            Boolean b = this.userService.editUser(user);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public Map<String, Object> deleteUser(@RequestParam("ids") List<Object>ids) {
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            Boolean b = this.userService.deleteUser(ids);
            if (b) {
                map.put("status", "200");
            } else {
                map.put("status", "500");
            }
        } catch (Exception e) {
            map.put("status", "500");
            e.printStackTrace();
        }
        return map;
    }

    @RequestMapping(value = "export/excel")
    public String exportExcel(@RequestParam("page") Integer pageNum, @RequestParam("rows") Integer pageSize, Model model) {
        EasyUIResult easyUIResult = this.userService.queryEasyUIResult(pageNum, pageSize);
        model.addAttribute("userList", easyUIResult.getRows());
        return "userExcelView";
    }

}
