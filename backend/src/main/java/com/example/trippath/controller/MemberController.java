package com.example.trippath.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.trippath.entity.Member;
import com.example.trippath.form.MemberForm;
import com.example.trippath.service.MemberService;

import lombok.RequiredArgsConstructor;



@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

    private final MemberService service;

    @PostMapping("/create")
    public ResponseEntity<String> create(@ModelAttribute MemberForm form,  Model model) {
        service.create(form);
        return ResponseEntity.ok()
                    .body("登録完了");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        service.delete(id);
        return ResponseEntity.ok()
                    .body("削除完了");
    }

    @GetMapping("/edit")
    public ResponseEntity<Member> edit(Integer id) {
        Member member = service.findById(id);
        return ResponseEntity.ok()
                    .body(member);
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@ModelAttribute MemberForm form, Model model, Integer id) {
        service.update(form, id);
        return ResponseEntity.ok()
                    .body("編集完了");
    }
    
    
    
}
