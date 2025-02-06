package com.example.trippath.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.trippath.entity.Trip;
import com.example.trippath.form.TripForm;
import com.example.trippath.service.TripService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/trip")
@RequiredArgsConstructor
public class TripController {

    private final TripService service;

    @GetMapping("/index")
    public ResponseEntity<List<Trip>> index(HttpSession session) {
        session.setAttribute("member", 1);
        Integer creatorId = (Integer) session.getAttribute("member");
        List<Trip> trips = service.getAllTrips(creatorId);
        return ResponseEntity.ok()
                    .body(trips);
    }
    

    @PostMapping("/create")
    public ResponseEntity<String> create(@ModelAttribute TripForm form, Model model, HttpSession session) {
        session.setAttribute("member", 1);
        Integer creatorId = (Integer) session.getAttribute("member");
        service.create(form, creatorId);
        return ResponseEntity.ok()
                    .body("旅の登録完了");
    }

    @GetMapping("/edit")
    public ResponseEntity<Trip> edit(Integer id) {
        Trip trip = service.findById(id);
        return ResponseEntity.ok()
                    .body(trip);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@ModelAttribute TripForm form, Integer id) {
        service.update(form, id);
        return ResponseEntity.ok()
                    .body("旅の編集完了");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(Integer id) {
        service.delete(id);
        return ResponseEntity.ok()
                    .body("旅の削除完了");
    }
}
