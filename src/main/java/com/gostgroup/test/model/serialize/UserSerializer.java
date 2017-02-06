package com.gostgroup.test.model.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gostgroup.test.model.RolesEntity;
import com.gostgroup.test.model.UsersEntity;

import java.io.IOException;

/**
 * @author: e.medvedev
 * Date: 06.02.2017
 */
public class UserSerializer extends StdSerializer<UsersEntity> {

  public UserSerializer() {
    this(null);
  }

  public UserSerializer(Class<UsersEntity> t) {
    super(t);
  }

  @Override
  public void serialize(UsersEntity usersEntity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
    jsonGenerator.writeStartObject();
    jsonGenerator.writeStringField("login", usersEntity.getLogin());
    jsonGenerator.writeStringField("name", usersEntity.getName());
    jsonGenerator.writeStringField("password", usersEntity.getPassword());

    jsonGenerator.writeArrayFieldStart("roles");
    for (RolesEntity role : usersEntity.getRoles()) {
      jsonGenerator.writeNumber(role.getId());
    }
    jsonGenerator.writeEndArray();

    jsonGenerator.writeEndObject();

  }
}
