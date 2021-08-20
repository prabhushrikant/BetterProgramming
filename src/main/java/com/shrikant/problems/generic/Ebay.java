package com.shrikant.problems.generic;

public class Ebay 
{
    
    byte[] buffer = new byte[4000];
    int offset = 0;
    FileReader4KB fileReader4KB;

    public Ebay(FileReader4KB fileReader4KB)
    {
        this.fileReader4KB = fileReader4KB;
    }

    public byte[] read(int size)
    {
        byte[] result = new byte[size];
        //check if offset is 0 or more than 4000 
        //get the next block into buffer
        int pos = 0;
        while (pos < size) 
        {
            if (this.offset == 0 || this.offset >= 4000)
            {
                readNext4KB();
            }

            if (this.buffer[offset] == '\0') {
                result[pos++] = '\0';
                break;
            }
            result[pos++] = this.buffer[offset++];
        }    

        return result;
    }

    private void readNext4KB() 
    {
        this.buffer = this.fileReader4KB.read();
        this.offset = 0;
    }
    
}

class FileReader4KB {

    private int offset = 0;
    public byte[] read() {

        byte[] result = new byte[4000];
        int counter = 0;
        while (counter < 4000)
        {
            result[counter] = (byte) this.offset++;
        }

        return result;
    }
}
