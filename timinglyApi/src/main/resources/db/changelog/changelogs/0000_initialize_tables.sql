create table users(
id UUID  NOT NULL PRIMARY KEY,
first_name VARCHAR  NOT NULL,
last_name VARCHAR  NOT NULL,
created_time  TIMESTAMPTZ NOT NULL,
updated_time  TIMESTAMPTZ NOT NULL,
created_by    VARCHAR     NOT NULL,
updated_by    VARCHAR     NOT NULL
);

create  table projects(
id UUID  NOT NULL PRIMARY KEY,
user_id  UUID  NOT null constraint projects_user_id_fkey references users,
project_name  VARCHAR     NOT NULL,
description VARCHAR,
is_deleted BOOLEAN default false NOT null,
created_time  TIMESTAMPTZ NOT NULL,
updated_time  TIMESTAMPTZ NOT NULL,
created_by    VARCHAR     NOT NULL,
updated_by    VARCHAR     NOT NULL
);


create  table timesheets(
id UUID  NOT NULL PRIMARY KEY,
project_id UUID  NOT null constraint timesheets_project_id_fkey references projects,
hours DECIMAL not null,
is_deleted BOOLEAN default false NOT null,
time_sheet_date TIMESTAMPTZ NOT NULL,
created_time  TIMESTAMPTZ NOT NULL,
updated_time  TIMESTAMPTZ NOT NULL,
created_by    VARCHAR     NOT NULL,
updated_by    VARCHAR     NOT NULL
);