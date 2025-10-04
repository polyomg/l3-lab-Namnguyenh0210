package com.poly.lab3.controller;

import com.poly.lab3.entity.Staff;
import com.poly.lab3.service.StaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@Controller
public class StaffController {

    private final StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @RequestMapping("/staff/detail")
    public String detail(Model model) {
        Staff staff = Staff.builder()
                .id("user@gmail.com")
                .fullname("nguyễn văn user")
                .photo("oip.jpeg")
                .level(2)
                .build();
        model.addAttribute("staff", staff);
        return "demo/staff-detail";
    }

    @RequestMapping("/staff/list")
    public String list(Model model) {
        List<Staff> list = staffService.getSampleStaffList();
        model.addAttribute("list", list);
        return "demo/staff-list";
    }

    @RequestMapping("/staff/list-status")
    public String listStatus(Model model) {
        List<Staff> list = staffService.getSampleStaffList();
        model.addAttribute("list", list);
        return "demo/list-status";
    }

    @RequestMapping("/staff/list-controls")
    public String listControls(Model model) {
        List<Staff> list = staffService.getSampleStaffList();
        model.addAttribute("list", list);
        return "demo/list-controls";
    }

    // Bài 3: Group theo cấp bậc
    @GetMapping("/staff/group")
    public String groupByLevel(Model model) {
        Map<Integer, List<Staff>> grouped = staffService.groupByLevel();
        model.addAttribute("grouped", grouped);
        model.addAttribute("levels", staffService.getLevelLabels());
        return "demo/group-staff";
    }

    // Bài 6: Form tạo mới Staff
    @GetMapping("/staff/new")
    public String newStaffForm(Model model) {
        model.addAttribute("staff", Staff.builder().photo("oip.jpeg").build());
        model.addAttribute("levels", staffService.getLevelLabels());
        return "demo/staff-form";
    }

    @PostMapping("/staff/save")
    public String saveStaff(@ModelAttribute("staff") Staff staff, Model model) {
        // Thêm vào bộ nhớ tạm (list động trong service)
        staffService.addStaff(staff);
        model.addAttribute("staff", staff);
        return "demo/staff-detail"; // tái sử dụng trang detail để hiển thị lại
    }

    @RequestMapping("/")
    public String home() {
        return "demo/index";
    }
}
