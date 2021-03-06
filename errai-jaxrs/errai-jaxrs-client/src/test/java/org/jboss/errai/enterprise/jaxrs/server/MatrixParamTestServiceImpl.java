/*
 * Copyright 2011 JBoss, by Red Hat, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.errai.enterprise.jaxrs.server;

import org.jboss.errai.enterprise.jaxrs.client.shared.MatrixParamTestService;

/**
 * Implementation of {@link MatrixParamTestService} returning test data.
 * 
 * @author Christian Sadilek <csadilek@redhat.com>
 */
public class MatrixParamTestServiceImpl implements MatrixParamTestService {

  @Override
  public String getWithSingleMatrixParam(String path, String id) {
    return path + "/" + id;
  }

  @Override
  public String getWithMatrixParams(long first, long last) {
    return first + "/" + last;
  }

  @Override
  public String postWithMatrixParams(String entity, String first, String last) {
    return entity+ "/" + first + "/" + last;
  }

  @Override
  public String putWithMatrixParams(String first, String middle, String last) {
    return first + "/" + middle + "/" + last;
  }

  @Override
  public String deleteWithMatrixParams(String first, String last) {
    return first + "/" + last;
  }

  @Override
  public void headWithMatrixParams(String first, String middle, String last) {}

}