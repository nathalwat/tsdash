/*
 * Copyright 2011 Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.facebook.tsdb.tsdash.client.service.json;

import com.facebook.tsdb.tsdash.client.service.ServiceException;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;

public class ErrorDecoder extends JSONDecoder<ServiceException> {

  @Override
  ServiceException decode(String jsonText) {
    JSONObject errObj = JSONParser.parseStrict(jsonText).isObject();
    String title = "";
    if (errObj.get("error").isNull() == null) {
      title = errObj.get("error").isString().stringValue();
    }
    String stackTrace = errObj.get("stacktrace").isString().stringValue();
    return new ServiceException(title, stackTrace);
  }
}
