This is to understand the difference between file input/output stream to data input stream

FileInputStream/FileOutputStream
These streams read/write data as bytes
    -->read()/write() ...

DataInputStream/DataOutputStream
These streams read/write data as primitives
    -->readUTF()/writeUTF; readBoolean()/writeBoolean(); readBytes()/writeBytes(); chars(); floats(); doubles()

DataInputStream/DataOutputStream require an input/output stream when created