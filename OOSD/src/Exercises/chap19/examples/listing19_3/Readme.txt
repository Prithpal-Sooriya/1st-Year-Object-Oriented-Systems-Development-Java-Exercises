detect end of file

This is an exception called EOFException (End Of File Exception)

we can use this to catch the end of a file
(in case the file is corrupted or program is still trying to read a file)

Will be using Buffered input stream inside the Data stream
    --> Buffered streams can be significantly faster by saving data into a buffer
    --> Default size of buffered streams are 512