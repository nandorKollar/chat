CREATE TABLE user (
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  password VARCHAR(100) NOT NULL,
  enabled  BOOLEAN     NOT NULL,
  online   BOOLEAN     NOT NULL
);

CREATE TABLE user_roles (
  username VARCHAR(50)            NOT NULL,
  role     VARCHAR_IGNORECASE(50) NOT NULL,
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES user (username)
);

CREATE UNIQUE INDEX ix_auth_username ON user_roles (username, role);

INSERT INTO user (username, password, enabled, online) VALUES ('bence', hash('SHA256', STRINGTOUTF8('bence'), 1), TRUE, FALSE);
INSERT INTO user_roles (username, role) VALUES ('bence', 'PARASZT');
INSERT INTO user (username, password, enabled, online) VALUES ('nandi', hash('SHA256', STRINGTOUTF8('nandi'), 1), TRUE, FALSE);
INSERT INTO user_roles (username, role) VALUES ('nandi', 'PARASZT');