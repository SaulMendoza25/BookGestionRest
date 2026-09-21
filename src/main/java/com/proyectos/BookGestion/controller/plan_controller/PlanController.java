package com.proyectos.BookGestion.controller.plan_controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectos.BookGestion.dto.plan_dto.PlanResponseDTO;
import com.proyectos.BookGestion.dto.plan_dto.PlanSaveDTO;
import com.proyectos.BookGestion.dto.plan_dto.PlanUpdateDTO;
import com.proyectos.BookGestion.model.Plan;
import com.proyectos.BookGestion.service.plan_service.PlanService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/plan")
public class PlanController {
    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<PlanResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(planService.findById(id));
    }

    @GetMapping("/findAllPlans")

    public ResponseEntity<List<PlanResponseDTO>> findAll() {

        return ResponseEntity.ok(planService.findAllplans());
    }

    @PostMapping("/savePlan")
    public ResponseEntity<PlanResponseDTO> savePlan(@RequestBody PlanSaveDTO planSaveDTO) {
        // TODO: process POST request

        return ResponseEntity.status(HttpStatus.CREATED).body(planService.savePlan(planSaveDTO));
    }

    @PutMapping("updatePlan/{id}")
    public ResponseEntity<PlanResponseDTO> updatePlan(@PathVariable Long id, @RequestBody PlanUpdateDTO planUpdateDTO) {
        // TODO: process PUT request

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(planService.updateById(id, planUpdateDTO));
    }

    @DeleteMapping("/deletePlan/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        planService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
