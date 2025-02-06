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

import com.example.trippath.entity.Destination;
import com.example.trippath.form.DestinationForm;
import com.example.trippath.service.DestinationService;

import lombok.RequiredArgsConstructor;



@Controller
@RequestMapping("/destination")
@RequiredArgsConstructor
public class DestinationsController {

    private final DestinationService service;
    
    @GetMapping("/index")
    public ResponseEntity<List<Destination>> index(@RequestParam Integer tripId) {
        List<Destination> destinations = service.getAllDestinations(tripId);
        return ResponseEntity.ok()
                    .body(destinations);
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@ModelAttribute DestinationForm form, Model model) {
        service.create(form);
        return ResponseEntity.ok()
                    .body("行きたい場所リストに登録完了");
    }

    @GetMapping("/edit")
    public Destination edit(@RequestParam Integer id) {
       Destination destination = service.findById(id);
       return destination;
    }

    @PostMapping("/update")
    public ResponseEntity<String> update(@ModelAttribute DestinationForm form, Model model, Integer id) {
        service.update(form, id);
        return ResponseEntity.ok()
                    .body("目的地情報の更新完了");
    }

    @PostMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam Integer id) {
        service.delete(id);
        return ResponseEntity.ok()
                    .body("目的地の削除完了");
    }
}