package com.lamld.osadmincentermcr.domain.shareService.product;

import com.lamld.osadmincentermcr.domain.repositories.product.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.mos.core.base.BaseService;

@Service
public class ProductShareService extends BaseService {
  @Autowired ProductEntityRepository productEntityRepository;
}
