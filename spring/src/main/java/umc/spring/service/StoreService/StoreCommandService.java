package umc.spring.service.StoreService;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO.CreateStore;

public interface StoreCommandService {
    Store createStore(Long regionId, CreateStore request);
}

