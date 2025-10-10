package com.poly.lab3.service;

import com.poly.lab3.entity.Staff;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class StaffService {
    private final List<Staff> dynamicList = new CopyOnWriteArrayList<>();

    public List<Staff> getSampleStaffList() {
        if (dynamicList.isEmpty()) {
            dynamicList.addAll(List.of(
                    Staff.builder().id("user1@gmail.com").fullname("nguyễn văn user1").photo("oip.jpeg").level(0).build(),
                    Staff.builder().id("user2@gmail.com").fullname("nguyễn văn user2").photo("oip.jpeg").level(1).build(),
                    Staff.builder().id("user3@gmail.com").fullname("nguyễn văn user3").photo("oip.jpeg").level(2).build(),
                    Staff.builder().id("user4@gmail.com").fullname("nguyễn văn user4").photo("oip.jpeg").level(2).build(),
                    Staff.builder().id("user5@gmail.com").fullname("nguyễn văn user5").photo("oip.jpeg").level(1).build(),
                    Staff.builder().id("user6@gmail.com").fullname("nguyễn văn user6").photo("oip.jpeg").level(0).build()
            ));
        }
        return dynamicList;
    }

    public void addStaff(Staff staff) {
        if (staff.getId() == null || staff.getId().isBlank()) {
            staff.setId("staff" + (dynamicList.size() + 1) + "@mail.com");
        }
        if (staff.getPhoto() == null || staff.getPhoto().isBlank()) {
            staff.setPhoto("oip.jpeg");
        }
        dynamicList.add(staff);
    }

    public Map<Integer, List<Staff>> groupByLevel() {
        return getSampleStaffList().stream().collect(Collectors.groupingBy(Staff::getLevel, TreeMap::new, Collectors.toList()));
    }

    public Map<Integer, String> getLevelLabels() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(0, "Úy");
        map.put(1, "Tá");
        map.put(2, "Tướng");
        return map;
    }
}

