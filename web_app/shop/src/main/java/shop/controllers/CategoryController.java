package shop.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.dto.category.CategoryCreateDTO;
import shop.dto.category.CategoryItemDTO;
import shop.entities.CategoryEntity;
import shop.mapper.CategoryMapper;
import shop.repositories.CategoryRepository;
import shop.storage.StorageService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/categories")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final StorageService storageService;

    @GetMapping
    public ResponseEntity<List<CategoryItemDTO>> index() {
        var list = categoryRepository.findAll();
        var model = categoryMapper.CategoryItemsByCategories(list);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<CategoryItemDTO> create(@ModelAttribute CategoryCreateDTO model) {
        var fileName = storageService.saveMultipartFile(model.getFile()); //storageService.save(model.getBase64());
        CategoryEntity category = categoryMapper.CategoryByCreateDTO(model);
        category.setImage(fileName);
        categoryRepository.save(category);
        var result = categoryMapper.CategoryItemByCategory(category);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
