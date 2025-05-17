package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRequestDTO.CreateStore;

public interface StoreCommandService {
    void createStore(Long regionId, CreateStore request);
}

