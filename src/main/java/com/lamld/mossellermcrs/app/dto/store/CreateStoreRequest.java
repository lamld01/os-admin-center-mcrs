package com.lamld.mossellermcrs.app.dto.store;

import lombok.Data;
import vn.mos.core.base.type.StoreStatus;

@Data
public class CreateStoreRequest {

  private String address;

  private String phoneNumber;

  private String name;

}
