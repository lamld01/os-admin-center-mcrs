package com.lamld.osadmincentermcrs.domain.shareService.product;

import com.lamld.osadmincentermcrs.domain.repositories.product.ProductInventoryEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.mos.core.base.BaseService;

@Service
public class ProductInventoryShareService extends BaseService {
  @Autowired ProductInventoryEntityRepository productInventoryEntityRepository;
}
