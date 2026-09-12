package com.proyectos.BookGestion.service.plan_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyectos.BookGestion.dto.plan_dto.PlanResponseDTO;
import com.proyectos.BookGestion.dto.plan_dto.PlanSaveDTO;
import com.proyectos.BookGestion.dto.plan_dto.PlanUpdateDTO;
import com.proyectos.BookGestion.error.plan_error.PlanNotFoundException;
import com.proyectos.BookGestion.model.Plan;
import com.proyectos.BookGestion.repository.plan_repository.PlanRepository;
import com.proyectos.BookGestion.service.tools.ToolsMethodsService;

@Service
public class PlanServiceImpl implements PlanService {
    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<PlanResponseDTO> findAllplans() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAllplans'");
    }

    @Override
    public PlanResponseDTO findById(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException("Plano no encontrado"));
        return mapToResponseDTO(plan);
    }

    @Override
    public PlanResponseDTO savePlan(PlanSaveDTO planSaveDTO) {
        Plan plan = mapToPlanSave(planSaveDTO);
        Plan planGuardado = planRepository.save(plan);
        return mapToResponseDTO(planGuardado);
    }

    @Override
    public PlanResponseDTO updateById(Long id, PlanUpdateDTO planUpdateDTO) {
        // TODO Auto-generated method stub
        Plan plan = planRepository.findById(id).orElseThrow(() -> new PlanNotFoundException("No se encontro el plan"));
        if (!ToolsMethodsService.IsEmptyOrBlankString(planUpdateDTO.nombre())) {
            plan.setNombre(planUpdateDTO.nombre());
        }
        if (!(planUpdateDTO.precio()<0)) {

            plan.setPrecio(planUpdateDTO.precio());

        }
        if (!(planUpdateDTO.duracionDias()<0)) {

            plan.setDuracionDias(planUpdateDTO.duracionDias());

        }
        Plan planGuardado = planRepository.save(plan);
        return mapToResponseDTO(planGuardado);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        Plan plan = planRepository.findById(id).orElseThrow(()->new PlanNotFoundException("Plan no encontrado"));
        planRepository.delete(plan);
    }

    // Metodos privado de plan

    private PlanResponseDTO mapToResponseDTO(Plan plan) {
        return new PlanResponseDTO(plan.getId(), plan.getNombre(), plan.getPrecio(), plan.getDuracionDias());
    }

    private Plan mapToPlanSave(PlanSaveDTO planSaveDTO) {
        Plan plan = new Plan();
        plan.setNombre(planSaveDTO.nombre());
        plan.setPrecio(planSaveDTO.precio());
        plan.setDuracionDias(planSaveDTO.duracionDias());
        return plan;
    }

}
