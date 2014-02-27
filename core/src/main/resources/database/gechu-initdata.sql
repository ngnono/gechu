USE Gechu;


INSERT INTO User (Username, Password)
VALUES ('gechuAdmin', 123456);


INSERT INTO Role (Name)
VALUES ('admin'), ('manager'), ('user'), ('guest');

INSERT INTO UserRoleRelation (User_Id, Role_Id)
  SELECT
    b.Id,
    a.Id
  FROM (

         SELECT
           Id
         FROM Role
         WHERE Name = 'admin'
       ) AS a, (
                 SELECT
                   Id
                 FROM
                   User
                 WHERE
                   Username = 'gechuAdmin'
               ) AS b;

INSERT INTO Permission(Name)
VALUES ('view'),('edit');

INSERT INTO RolePermissionRelation(Role_Id,Permission_Id)
  SELECT

    a.Id,
    b.Id
  FROM (

         SELECT
           Id
         FROM Role
         WHERE Name = 'admin'
       ) AS a, (
                 SELECT
                   Id
                 FROM
                   Permission
                 WHERE
                   Name = 'edit'
               ) AS b;

