Serialisable --> makes a class/object be read and written by ObjectStream

    -->this can also be used to allow ObjectStream to read an array

    -->when making a class serialisable, static methods are not read/recognised
        -->to make sure that some data you dont want to be read/writted use transient
            --> transient int x = 5;