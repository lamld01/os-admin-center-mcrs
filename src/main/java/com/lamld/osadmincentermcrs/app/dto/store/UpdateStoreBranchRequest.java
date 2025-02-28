package com.lamld.osadmincentermcrs.app.dto.store;

import lombok.Data;
import vn.mos.core.base.type.StoreBranchStatus;

@Data
public class UpdateStoreBranchRequest {
  private String address;
  private String phoneNumber;
  private String name;
  private StoreBranchStatus status;
}
