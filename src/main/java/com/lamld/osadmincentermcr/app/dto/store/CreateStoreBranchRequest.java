package com.lamld.osadmincentermcr.app.dto.store;

import lombok.Data;

@Data
public class CreateStoreBranchRequest {
  private String address;
  private String phoneNumber;
  private String name;
  private Long storeId;
}
