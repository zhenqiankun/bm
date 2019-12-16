package Test;

import java.io.*;

public class MyObjectStream extends ObjectOutputStream {
    public  static  File file;
    private MyObjectStream(OutputStream out,File file) throws IOException {
        super(out);

    }
    public static MyObjectStream newInstance(OutputStream out,File file1) throws IOException {
        file=file1;
        return new MyObjectStream(out,file);
    }
    @Override
    protected void writeStreamHeader() throws IOException {

        if(file.length()==0){
            super.writeStreamHeader();
        }else {
            super.reset();
        }
    }
}
