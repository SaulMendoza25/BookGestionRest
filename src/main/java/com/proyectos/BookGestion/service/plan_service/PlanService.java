package com.proyectos.BookGestion.service.plan_service;

import java.util.List;

import com.proyectos.BookGestion.dto.plan_dto.PlanResponseDTO;
import com.proyectos.BookGestion.dto.plan_dto.PlanSaveDTO;
import com.proyectos.BookGestion.dto.plan_dto.PlanUpdateDTO;
import com.proyectos.BookGestion.model.Plan;

public interface PlanService {
    List<PlanResponseDTO>  findAllplans();
    PlanResponseDTO findById(Long id);
    PlanResponseDTO savePlan(PlanSaveDTO planSaveDTO);
    PlanResponseDTO updateById(Long id, PlanUpdateDTO planUpdateDTO);
    void deleteById(Long id);
    

}
