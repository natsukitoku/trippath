package com.example.trippath.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.trippath.entity.TripMember;
import com.example.trippath.form.TripMemberForm;
import com.example.trippath.service.TripMemberService;

import lombok.RequiredArgsConstructor;





@Controller
@RequestMapping("/friend")
@RequiredArgsConstructor
public class TripMemberController {

    private final TripMemberService service;

    @GetMapping("/index")
    public ResponseEntity<List<TripMember>> index(@RequestParam Integer tripId) {
        List<TripMember> members = service.findAllById(tripId);
        return ResponseEntity.ok()
                    .body(members);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFriend(@ModelAttribute TripMemberForm form, Model model) {
        service.addFriend(form);
        return ResponseEntity.ok()
                    .body("友達を旅行に追加しました");
    }
    
    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        service.delete(id);
        return ResponseEntity.ok()
                    .body("友達を旅行から削除しました");
    }
}
