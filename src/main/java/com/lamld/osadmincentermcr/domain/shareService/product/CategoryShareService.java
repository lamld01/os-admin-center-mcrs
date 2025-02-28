package com.lamld.osadmincentermcr.domain.shareService.product;

import com.lamld.osadmincentermcr.domain.entities.product.CategoryEntity;
import com.lamld.osadmincentermcr.domain.repositories.product.CategoryEntityRepository;
import jakarta.persistence.criteria.Predicate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import vn.mos.core.base.BaseService;
import vn.mos.core.base.type.BusinessErrorCode;
import vn.mos.core.base.type.ProductCategoryType;
import vn.mos.core.exceptions.BusinessException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryShareService extends BaseService {
  @Autowired
  CategoryEntityRepository categoryEntityRepository;

  public CategoryEntity getCategoryById(Long id) {
    String key = redisKey.format(redisKey.CATEGORY_BY_ID, id);
    CategoryEntity category = cacheUtil.getJson(key, CategoryEntity.class);
    if (category == null) {
      category = categoryEntityRepository.findById(id).orElse(null);
      if (category != null) {
        cacheUtil.setJson(key, category);
      }
    }
    return category;
  }

  public CategoryEntity getExistCategoryById(Long id) {
    CategoryEntity category = getCategoryById(id);
    if (category == null) {
      throw new BusinessException(BusinessErrorCode.CATEGORY_NOT_FOUND);
    }
    return category;
  }

  public List<CategoryEntity> getAllCategories(Long parentId, String name, String description, ProductCategoryType type) {
    return categoryEntityRepository.findAll(createSpecification(parentId, name, description, type));
  }

  public Specification<CategoryEntity> createSpecification(Long parentId, String name, String description, ProductCategoryType type) {
    return (root, query, cb) -> {
      List<Predicate> predicates = new ArrayList<>();
      if (parentId != null) {
        predicates.add(cb.equal(root.get("parentId"), parentId));
      }
      if (StringUtils.isNotBlank(name)) {
        predicates.add(cb.like(root.get("name"), "%" + name + "%"));
      }
      if (StringUtils.isNotBlank(description)) {
        predicates.add(cb.like(root.get("description"), "%" + description + "%"));
      }
      if (type != null) {
        predicates.add(cb.equal(root.get("type"), type));
      }
      return cb.and(predicates.toArray(new Predicate[0]));
    };
  }

  public CategoryEntity save(CategoryEntity category) {
    removeCategoryCache(category);
    return categoryEntityRepository.saveAndFlush(category);
  }

  public void removeCategoryCache(CategoryEntity category) {
    cacheUtil.delete(redisKey.format(redisKey.CATEGORY_BY_ID, category.getId()));
  }
}
