# insaludPrueba Técnica - Practicante TI

## Modelo de Datos

- Persona

  | CAMPO      | TIPO      | CONSTRAINT                |
  | ---------- | --------- | ------------------------- |
  | id_persona | INT       | PRIMARY KEY AUTOINCREMENT |
  | nombre     | CHAR(150) | NOT NULL                  |
  | email      | CHAR(50)  | NOT NULL UNIQUE           |
  | estado     | BOOLEAN   | NOT NULL                  |

- Usuario

  | CAMPO      | TIPO      | CONSTRAINT                |
  | ---------- | --------- | ------------------------- |
  | id_usuario | INT       | PRIMARY KEY AUTOINCREMENT |
  | usuario    | CHAR(100) | NOT NULL UNIQUE           |
  | contraseña | CHAR(100) | NOT NULL                  |
  | id_persona | INT       | FOREIGN KEY NOT NULL      |

- Paciente

  | CAMPO           | TIPO      | CONSTRAINT                |
  | --------------- | --------- | ------------------------- |
  | id_paciente     | INT       | PRIMARY KEY AUTOINCREMENT |
  | id_persona      | CHAR(100) | FOREIGN KEY NOT NULL      |
  | rol             | CHAR(100) | NOT NULL                  |
  | estado          | BOOLEAN   | NOT NULL                  |

- Empleado

  | CAMPO           | TIPO      | CONSTRAINT                |
  | --------------- | --------- | ------------------------- |
  | id_empleado     | INT       | PRIMARY KEY AUTOINCREMENT |
  | id_persona      | CHAR(100) | FOREIGN KEY NOT NULL      |
  | rol             | CHAR(100) | NOT NULL                  |
  | estado          | BOOLEAN   | NOT NULL                  |

- Especialidad

  | CAMPO              | TIPO      | CONSTRAINT                |
  | ------------------ | --------- | ------------------------- |
  | id_especialidad    | INT       | PRIMARY KEY AUTOINCREMENT |
  | nombre             | CHAR(100) | NOT NULL                  |
  | estado             | BOOLEAN   | NOT NULL                  |

- Medico Especialidad

  | CAMPO           | TIPO      | CONSTRAINT                |
  | --------------- | --------- | ------------------------- |
  | id_empleado     | INT       | FOREIGN KEY NOT NULL      |
  | id_especialidad | INT       | FOREIGN KEY NOT NULL      |

- Atencion

  | CAMPO       | TIPO      | CONSTRAINT                |
  | ----------- | --------- | ------------------------- |
  | id_atencion | INT       | FOREIGN KEY NOT NULL      |
  | fecha       | DATE      | NOT NULL                  |
  | motivo      | CHAR(50)  | NOT NULL                  |
  | id_paciente | INT       | FOREIGN KEY NOT NULL      |
  | id_empleado | INT       | FOREIGN KEY NOT NULL      |
  | estado      | BOOLEAN   | NOT NULL                  |