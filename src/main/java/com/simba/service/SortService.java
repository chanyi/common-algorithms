package com.simba.service;

import java.util.Collection;

public interface SortService {

  <T> Collection<T> descSort(Collection<T> collection);
}
