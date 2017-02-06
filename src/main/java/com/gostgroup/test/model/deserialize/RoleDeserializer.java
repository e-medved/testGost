package com.gostgroup.test.model.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.gostgroup.test.model.RolesEntity;

import java.io.IOException;

/**
 * @author: e.medvedev
 * Date: 06.02.2017
 */
public class RoleDeserializer extends StdDeserializer<RolesEntity> {

  protected RoleDeserializer() {
    this(null);
  }

  protected RoleDeserializer(Class<?> vc) {
    super(vc);
  }

  @Override
  public RolesEntity deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {

    jsonParser.nextToken();
    if (JsonToken.END_OBJECT != jsonParser.nextToken()) {
      int roleId = jsonParser.getValueAsInt();
      return new RolesEntity(roleId);
    }
    return null;
  }
}
