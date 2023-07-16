package org.example.service.facade;

import org.example.model.entity.dto.AnimalCreateDto;

public interface DataEntryFacadeService {

    boolean createDataEntry(AnimalCreateDto animalCreateDto);
}
