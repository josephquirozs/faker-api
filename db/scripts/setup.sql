IF NOT EXISTS (
    SELECT [name]
        FROM sys.databases
        WHERE [name] = N'faker'
)
CREATE DATABASE faker
GO