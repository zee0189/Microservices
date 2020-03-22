package com.project.microserivces.coursesservice.model;

import com.google.common.base.Enums;
import java.util.Map;

public enum Slot {
  A1("a1", 1),
  A2("a2", 2),
  B1("b1", 3),
  B2("b2", 4);

  private String slot;
  private int priority;

  Slot(String slot, int priority) {
    this.slot = slot;
    this.priority = priority;
  }
}
