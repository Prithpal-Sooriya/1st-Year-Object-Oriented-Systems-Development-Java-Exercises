FindUserTables:

    --> Loads the JDBC Driver
        --> Class.forName("com.mysql.jdbc.Driver");

    --> Creates a connection
        --> DriverManager.getConnection("jdbc:mysql://localhost/javabook?useSSL=false", "Prithpal", "psooriya");

    --> gets the database metadata
        --> DatabaseMetaData

    --> Create a result set
        --> will be used to hold metadata of the tables of the database

    --> process the tables stored in result set
    
    --> close the connection
====================================
    --> obtain the tables information through the getTabes(...) method
    
    --> the ResultSet created contains a column called TABLE_NAME
        --> .getString("TABLE_NAME") (on the ResultSet) will receive the column name

    --> other columns in the result set:

TABLE_CAT String => table catalog (may be null)
TABLE_SCHEM String => table schema (may be null)
TABLE_NAME String => table name
TABLE_TYPE String => table type. Typical types are "TABLE", "VIEW", "SYSTEM TABLE", "GLOBAL TEMPORARY", "LOCAL TEMPORARY", "ALIAS", "SYNONYM".
REMARKS String => explanatory comment on the table
TYPE_CAT String => the types catalog (may be null)
TYPE_SCHEM String => the types schema (may be null)
TYPE_NAME String => type name (may be null)
SELF_REFERENCING_COL_NAME String => name of the designated "identifier" column of a typed table (may be null)
REF_GENERATION String => specifies how values in SELF_REFERENCING_COL_NAME are created. Values are "SYSTEM", "USER", "DERIVED". (may be null)