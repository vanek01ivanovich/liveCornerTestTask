package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.entity.AnimalClass;
import org.example.model.entity.AnimalType;
import org.example.model.entity.StorageLocation;
import org.example.model.entity.dto.AnimalCreateDto;
import org.example.model.entity.dto.AnimalRepresentationDto;
import org.example.service.AnimalClassService;
import org.example.service.AnimalService;
import org.example.service.AnimalTypeService;
import org.example.service.StorageLocationService;
import org.example.service.facade.DataEntryFacadeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
public class DataEntryController {

    private final DataEntryFacadeService dataEntryFacadeService;
    private final AnimalClassService animalClassService;
    private final AnimalTypeService animalTypeService;
    private final StorageLocationService storageLocationService;
    private final AnimalService animalService;

    @GetMapping
    public String getDataEntrySave(Model model) {
        List<AnimalClass> allAnimalClasses = animalClassService.getAllAnimalClasses();
        List<AnimalType> allAnimalTypes = animalTypeService.getAllAnimalTypes();
        List<StorageLocation> allStorageLocation = storageLocationService.getAllStorageLocation();
        model.addAttribute("animalCreateDto", new AnimalCreateDto());
        model.addAttribute("allAnimalClasses", allAnimalClasses);
        model.addAttribute("allAnimalTypes", allAnimalTypes);
        model.addAttribute("allStorageLocation", allStorageLocation);
        return "data_entry_save";
    }

    @PostMapping()
    public String addAnimal(@ModelAttribute("animalCreateDto") AnimalCreateDto animalCreateDto) {
        log.info("addAnimal with animalCreateDto {}", animalCreateDto);
        boolean result = dataEntryFacadeService.createDataEntry(animalCreateDto);
        if (result) {
            return "success";
        } else {
            return "failure";
        }
    }

    @GetMapping("/all")
    public String getAllData(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size, Model model) {
        log.info("getAllData started page {} size {}", page, size);
        List<AnimalRepresentationDto> allAnimals = animalService.getAllAnimals(page, size);
        model.addAttribute("allAnimals", allAnimals);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", allAnimals.size() / size);
        return "all";
    }

    @GetMapping("/all/without-pagination")
    public String getAllDataWithoutPagination(Model model){
        List<AnimalRepresentationDto> allAnimals = animalService.getAllAnimals();
        model.addAttribute("allAnimals", allAnimals);
        return "all_without_pagination";
    }

}
